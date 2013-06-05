package lv



import org.junit.*
import grails.test.mixin.*

@TestFor(DescricaoController)
@Mock(Descricao)
class DescricaoControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/descricao/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.descricaoInstanceList.size() == 0
        assert model.descricaoInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.descricaoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.descricaoInstance != null
        assert view == '/descricao/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/descricao/show/1'
        assert controller.flash.message != null
        assert Descricao.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/descricao/list'

        populateValidParams(params)
        def descricao = new Descricao(params)

        assert descricao.save() != null

        params.id = descricao.id

        def model = controller.show()

        assert model.descricaoInstance == descricao
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/descricao/list'

        populateValidParams(params)
        def descricao = new Descricao(params)

        assert descricao.save() != null

        params.id = descricao.id

        def model = controller.edit()

        assert model.descricaoInstance == descricao
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/descricao/list'

        response.reset()

        populateValidParams(params)
        def descricao = new Descricao(params)

        assert descricao.save() != null

        // test invalid parameters in update
        params.id = descricao.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/descricao/edit"
        assert model.descricaoInstance != null

        descricao.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/descricao/show/$descricao.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        descricao.clearErrors()

        populateValidParams(params)
        params.id = descricao.id
        params.version = -1
        controller.update()

        assert view == "/descricao/edit"
        assert model.descricaoInstance != null
        assert model.descricaoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/descricao/list'

        response.reset()

        populateValidParams(params)
        def descricao = new Descricao(params)

        assert descricao.save() != null
        assert Descricao.count() == 1

        params.id = descricao.id

        controller.delete()

        assert Descricao.count() == 0
        assert Descricao.get(descricao.id) == null
        assert response.redirectedUrl == '/descricao/list'
    }
}
