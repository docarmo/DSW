package lv



import org.junit.*
import grails.test.mixin.*

@TestFor(CdController)
@Mock(Cd)
class CdControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/cd/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.cdInstanceList.size() == 0
        assert model.cdInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.cdInstance != null
    }

    void testSave() {
        controller.save()

        assert model.cdInstance != null
        assert view == '/cd/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/cd/show/1'
        assert controller.flash.message != null
        assert Cd.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/cd/list'

        populateValidParams(params)
        def cd = new Cd(params)

        assert cd.save() != null

        params.id = cd.id

        def model = controller.show()

        assert model.cdInstance == cd
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/cd/list'

        populateValidParams(params)
        def cd = new Cd(params)

        assert cd.save() != null

        params.id = cd.id

        def model = controller.edit()

        assert model.cdInstance == cd
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/cd/list'

        response.reset()

        populateValidParams(params)
        def cd = new Cd(params)

        assert cd.save() != null

        // test invalid parameters in update
        params.id = cd.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/cd/edit"
        assert model.cdInstance != null

        cd.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/cd/show/$cd.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        cd.clearErrors()

        populateValidParams(params)
        params.id = cd.id
        params.version = -1
        controller.update()

        assert view == "/cd/edit"
        assert model.cdInstance != null
        assert model.cdInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/cd/list'

        response.reset()

        populateValidParams(params)
        def cd = new Cd(params)

        assert cd.save() != null
        assert Cd.count() == 1

        params.id = cd.id

        controller.delete()

        assert Cd.count() == 0
        assert Cd.get(cd.id) == null
        assert response.redirectedUrl == '/cd/list'
    }
}
