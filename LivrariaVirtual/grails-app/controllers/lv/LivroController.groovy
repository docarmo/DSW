package lv

import org.springframework.dao.DataIntegrityViolationException

class LivroController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [livroInstanceList: Livro.list(params), livroInstanceTotal: Livro.count()]
    }

    def create() {
        [livroInstance: new Livro(params)]
    }

    def save() {
        def livroInstance = new Livro(params)
        if (!livroInstance.save(flush: true)) {
            render(view: "create", model: [livroInstance: livroInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'livro.label', default: 'Livro'), livroInstance.id])
        redirect(action: "show", id: livroInstance.id)
    }

    def show(Long id) {
        def livroInstance = Livro.get(id)
        if (!livroInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'livro.label', default: 'Livro'), id])
            redirect(action: "list")
            return
        }

        [livroInstance: livroInstance]
    }

    def edit(Long id) {
        def livroInstance = Livro.get(id)
        if (!livroInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'livro.label', default: 'Livro'), id])
            redirect(action: "list")
            return
        }

        [livroInstance: livroInstance]
    }

    def update(Long id, Long version) {
        def livroInstance = Livro.get(id)
        if (!livroInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'livro.label', default: 'Livro'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (livroInstance.version > version) {
                livroInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'livro.label', default: 'Livro')] as Object[],
                          "Another user has updated this Livro while you were editing")
                render(view: "edit", model: [livroInstance: livroInstance])
                return
            }
        }

        livroInstance.properties = params

        if (!livroInstance.save(flush: true)) {
            render(view: "edit", model: [livroInstance: livroInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'livro.label', default: 'Livro'), livroInstance.id])
        redirect(action: "show", id: livroInstance.id)
    }

    def delete(Long id) {
        def livroInstance = Livro.get(id)
        if (!livroInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'livro.label', default: 'Livro'), id])
            redirect(action: "list")
            return
        }

        try {
            livroInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'livro.label', default: 'Livro'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'livro.label', default: 'Livro'), id])
            redirect(action: "show", id: id)
        }
    }
}
