package agenda

import grails.converters.JSON

import org.springframework.dao.DataIntegrityViolationException

import grails.plugins.springsecurity.Secured
@Secured(['ROLE_USER'])
class ContatoController {
    def springSecurityService
    
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        params.put("sort", "nome")
        params.put("order", "asc")
        def usuario = springSecurityService.getCurrentUser()
        def contatos = Contato.findAllByUsuario(usuario, params)
        [contatoInstanceList: contatos,
            contatoInstanceTotal: contatos.size()]
    }

    def create() {
        [contatoInstance: new Contato(params)]
    }

    def save() {
        def usuario = springSecurityService.getCurrentUser()
        params.put("usuario", usuario)
        def contatoInstance = new Contato(params)

        if (!contatoInstance.save(flush: true)) {
            render(view: "create", model: [contatoInstance: contatoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'contato.label', default: 'Contato'), contatoInstance.id])
        redirect(action: "show", id: contatoInstance.id)
    }

    def show(Long id) {
        def contatoInstance = Contato.get(id)
        if (!contatoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'contato.label', default: 'Contato'), id])
            redirect(action: "list")
            return
        }

        [contatoInstance: contatoInstance]
    }

    def edit(Long id) {
        def contatoInstance = Contato.get(id)
        if (!contatoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'contato.label', default: 'Contato'), id])
            redirect(action: "list")
            return
        }

        [contatoInstance: contatoInstance]
    }

    def update(Long id, Long version) {
        def contatoInstance = Contato.get(id)
        if (!contatoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'contato.label', default: 'Contato'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (contatoInstance.version > version) {
                contatoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                    [message(code: 'contato.label', default: 'Contato')] as Object[],
                          "Another user has updated this Contato while you were editing")
                render(view: "edit", model: [contatoInstance: contatoInstance])
                return
            }
        }

        contatoInstance.properties = params

        if (!contatoInstance.save(flush: true)) {
            render(view: "edit", model: [contatoInstance: contatoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'contato.label', default: 'Contato'), contatoInstance.id])
        redirect(action: "show", id: contatoInstance.id)
    }

    def delete(Long id) {
        def contatoInstance = Contato.get(id)
        if (!contatoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'contato.label', default: 'Contato'), id])
            redirect(action: "list")
            return
        }

        try {
            contatoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'contato.label', default: 'Contato'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'contato.label', default: 'Contato'), id])
            redirect(action: "show", id: id)
        }
    }
    
    def cidadesAJAX(){
        def cidades = Cidade.findAllByEstado(params['estado']);
        render cidades as JSON
    }
    
    def searchAJAX () {
        
	// busca contatos
        def contatos = Contato.findAllByNomeLike("%${params.query}%")
	
	// cria resposta XML
	render(contentType: "text/xml") { // retorna os contatos encontrados
            results() { 
                contatos.each { contato ->result(){
                        name(contato.nome)
                        id (contato.id)
                    }
                }
            }
	}
    }
}
