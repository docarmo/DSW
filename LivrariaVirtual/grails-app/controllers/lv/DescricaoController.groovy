package lv

import org.springframework.dao.DataIntegrityViolationException

class DescricaoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [descricaoInstanceList: Descricao.list(params), descricaoInstanceTotal: Descricao.count()]
    }

    def create() {
        [descricaoInstance: new Descricao(params)]
    }

    def save() {
        def descricaoInstance = new Descricao(params)
        
        def webRootDir = servletContext.getRealPath("/")
        def prodDir = new File(webRootDir, "/produto/${descricaoInstance.produto.id}")
        prodDir.mkdirs()

        def imageFile = request.getFile('imagem')

        if(!imageFile.empty){
            imageFile.transferTo( new File( prodDir, imageFile.originalFilename))
            descricaoInstance.imagem = imageFile.originalFilename
        }

        def audioFile = request.getFile('audio')

        if(!audioFile.empty){
            audioFile.transferTo( new File( prodDir, audioFile.originalFilename))
            descricaoInstance.audio = audioFile.originalFilename
        }

        def videoFile = request.getFile('video')

        if(!videoFile.empty){
            videoFile.transferTo( new File( prodDir, videoFile.originalFilename))
            descricaoInstance.video = videoFile.originalFilename
        }
        
        if (!descricaoInstance.save(flush: true)) {
            render(view: "create", model: [descricaoInstance: descricaoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'descricao.label', default: 'Descricao'), descricaoInstance.id])
        redirect(action: "show", id: descricaoInstance.id)
    }

    def show(Long id) {
        def descricaoInstance = Descricao.get(id)
        if (!descricaoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'descricao.label', default: 'Descricao'), id])
            redirect(action: "list")
            return
        }

        [descricaoInstance: descricaoInstance]
    }

    def edit(Long id) {
        def descricaoInstance = Descricao.get(id)
        if (!descricaoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'descricao.label', default: 'Descricao'), id])
            redirect(action: "list")
            return
        }

        [descricaoInstance: descricaoInstance]
    }

    def update(Long id, Long version) {
        def descricaoInstance = Descricao.get(id)
        if (!descricaoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'descricao.label', default: 'Descricao'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (descricaoInstance.version > version) {
                descricaoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                    [message(code: 'descricao.label', default: 'Descricao')] as Object[],
                          "Another user has updated this Descricao while you were editing")
                render(view: "edit", model: [descricaoInstance: descricaoInstance])
                return
            }
        }

        descricaoInstance.properties = params
        def webRootDir = servletContext.getRealPath("/")
        def prodDir = new File(webRootDir, "/produto/${descricaoInstance.produto.id}")
        prodDir.mkdirs()

        def imageFile = request.getFile('imagem')

        if(!imageFile.empty){
            imageFile.transferTo( new File( prodDir, imageFile.originalFilename))
            descricaoInstance.imagem = imageFile.originalFilename
        }

        def audioFile = request.getFile('audio')

        if(!audioFile.empty){
            audioFile.transferTo( new File( prodDir, audioFile.originalFilename))
            descricaoInstance.audio = audioFile.originalFilename
        }

        def videoFile = request.getFile('video')

        if(!videoFile.empty){
            videoFile.transferTo( new File( prodDir, videoFile.originalFilename))
            descricaoInstance.video = videoFile.originalFilename
        }
        
        if (!descricaoInstance.save(flush: true)) {
            render(view: "edit", model: [descricaoInstance: descricaoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'descricao.label', default: 'Descricao'), descricaoInstance.id])
        redirect(action: "show", id: descricaoInstance.id)
    }

    def delete(Long id) {
        def descricaoInstance = Descricao.get(id)
        if (!descricaoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'descricao.label', default: 'Descricao'), id])
            redirect(action: "list")
            return
        }

        try {
            descricaoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'descricao.label', default: 'Descricao'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'descricao.label', default: 'Descricao'), id])
            redirect(action: "show", id: id)
        }
    }
}
