package lv

import org.springframework.dao.DataIntegrityViolationException

class CdController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [cdInstanceList: Cd.list(params), cdInstanceTotal: Cd.count()]
    }

    def create() {
        [cdInstance: new Cd(params)]
    }

    def save() {
        def cdInstance = new Cd(params)
        if (!cdInstance.save(flush: true)) {
            render(view: "create", model: [cdInstance: cdInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'cd.label', default: 'Cd'), cdInstance.id])
        redirect(action: "show", id: cdInstance.id)
    }

    def show(Long id) {
        def cdInstance = Cd.get(id)
        if (!cdInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'cd.label', default: 'Cd'), id])
            redirect(action: "list")
            return
        }

        [cdInstance: cdInstance]
    }

    def edit(Long id) {
        def cdInstance = Cd.get(id)
        if (!cdInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'cd.label', default: 'Cd'), id])
            redirect(action: "list")
            return
        }

        [cdInstance: cdInstance]
    }

    def update(Long id, Long version) {
        def cdInstance = Cd.get(id)
        if (!cdInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'cd.label', default: 'Cd'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (cdInstance.version > version) {
                cdInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'cd.label', default: 'Cd')] as Object[],
                          "Another user has updated this Cd while you were editing")
                render(view: "edit", model: [cdInstance: cdInstance])
                return
            }
        }

        cdInstance.properties = params

        if (!cdInstance.save(flush: true)) {
            render(view: "edit", model: [cdInstance: cdInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'cd.label', default: 'Cd'), cdInstance.id])
        redirect(action: "show", id: cdInstance.id)
    }

    def delete(Long id) {
        def cdInstance = Cd.get(id)
        if (!cdInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'cd.label', default: 'Cd'), id])
            redirect(action: "list")
            return
        }

        try {
            cdInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'cd.label', default: 'Cd'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'cd.label', default: 'Cd'), id])
            redirect(action: "show", id: id)
        }
    }
}
