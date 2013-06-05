package lv

import org.springframework.dao.DataIntegrityViolationException

class DvdController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [dvdInstanceList: Dvd.list(params), dvdInstanceTotal: Dvd.count()]
    }

    def create() {
        [dvdInstance: new Dvd(params)]
    }

    def save() {
        def dvdInstance = new Dvd(params)
        if (!dvdInstance.save(flush: true)) {
            render(view: "create", model: [dvdInstance: dvdInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'dvd.label', default: 'Dvd'), dvdInstance.id])
        redirect(action: "show", id: dvdInstance.id)
    }

    def show(Long id) {
        def dvdInstance = Dvd.get(id)
        if (!dvdInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'dvd.label', default: 'Dvd'), id])
            redirect(action: "list")
            return
        }

        [dvdInstance: dvdInstance]
    }

    def edit(Long id) {
        def dvdInstance = Dvd.get(id)
        if (!dvdInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'dvd.label', default: 'Dvd'), id])
            redirect(action: "list")
            return
        }

        [dvdInstance: dvdInstance]
    }

    def update(Long id, Long version) {
        def dvdInstance = Dvd.get(id)
        if (!dvdInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'dvd.label', default: 'Dvd'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (dvdInstance.version > version) {
                dvdInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'dvd.label', default: 'Dvd')] as Object[],
                          "Another user has updated this Dvd while you were editing")
                render(view: "edit", model: [dvdInstance: dvdInstance])
                return
            }
        }

        dvdInstance.properties = params

        if (!dvdInstance.save(flush: true)) {
            render(view: "edit", model: [dvdInstance: dvdInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'dvd.label', default: 'Dvd'), dvdInstance.id])
        redirect(action: "show", id: dvdInstance.id)
    }

    def delete(Long id) {
        def dvdInstance = Dvd.get(id)
        if (!dvdInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'dvd.label', default: 'Dvd'), id])
            redirect(action: "list")
            return
        }

        try {
            dvdInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'dvd.label', default: 'Dvd'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'dvd.label', default: 'Dvd'), id])
            redirect(action: "show", id: id)
        }
    }
}
