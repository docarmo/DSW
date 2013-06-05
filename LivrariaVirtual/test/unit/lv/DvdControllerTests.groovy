package lv



import org.junit.*
import grails.test.mixin.*

@TestFor(DvdController)
@Mock(Dvd)
class DvdControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/dvd/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.dvdInstanceList.size() == 0
        assert model.dvdInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.dvdInstance != null
    }

    void testSave() {
        controller.save()

        assert model.dvdInstance != null
        assert view == '/dvd/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/dvd/show/1'
        assert controller.flash.message != null
        assert Dvd.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/dvd/list'

        populateValidParams(params)
        def dvd = new Dvd(params)

        assert dvd.save() != null

        params.id = dvd.id

        def model = controller.show()

        assert model.dvdInstance == dvd
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/dvd/list'

        populateValidParams(params)
        def dvd = new Dvd(params)

        assert dvd.save() != null

        params.id = dvd.id

        def model = controller.edit()

        assert model.dvdInstance == dvd
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/dvd/list'

        response.reset()

        populateValidParams(params)
        def dvd = new Dvd(params)

        assert dvd.save() != null

        // test invalid parameters in update
        params.id = dvd.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/dvd/edit"
        assert model.dvdInstance != null

        dvd.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/dvd/show/$dvd.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        dvd.clearErrors()

        populateValidParams(params)
        params.id = dvd.id
        params.version = -1
        controller.update()

        assert view == "/dvd/edit"
        assert model.dvdInstance != null
        assert model.dvdInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/dvd/list'

        response.reset()

        populateValidParams(params)
        def dvd = new Dvd(params)

        assert dvd.save() != null
        assert Dvd.count() == 1

        params.id = dvd.id

        controller.delete()

        assert Dvd.count() == 0
        assert Dvd.get(dvd.id) == null
        assert response.redirectedUrl == '/dvd/list'
    }
}
