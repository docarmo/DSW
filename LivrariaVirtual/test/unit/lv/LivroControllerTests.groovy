package lv



import org.junit.*
import grails.test.mixin.*

@TestFor(LivroController)
@Mock(Livro)
class LivroControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/livro/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.livroInstanceList.size() == 0
        assert model.livroInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.livroInstance != null
    }

    void testSave() {
        controller.save()

        assert model.livroInstance != null
        assert view == '/livro/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/livro/show/1'
        assert controller.flash.message != null
        assert Livro.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/livro/list'

        populateValidParams(params)
        def livro = new Livro(params)

        assert livro.save() != null

        params.id = livro.id

        def model = controller.show()

        assert model.livroInstance == livro
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/livro/list'

        populateValidParams(params)
        def livro = new Livro(params)

        assert livro.save() != null

        params.id = livro.id

        def model = controller.edit()

        assert model.livroInstance == livro
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/livro/list'

        response.reset()

        populateValidParams(params)
        def livro = new Livro(params)

        assert livro.save() != null

        // test invalid parameters in update
        params.id = livro.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/livro/edit"
        assert model.livroInstance != null

        livro.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/livro/show/$livro.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        livro.clearErrors()

        populateValidParams(params)
        params.id = livro.id
        params.version = -1
        controller.update()

        assert view == "/livro/edit"
        assert model.livroInstance != null
        assert model.livroInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/livro/list'

        response.reset()

        populateValidParams(params)
        def livro = new Livro(params)

        assert livro.save() != null
        assert Livro.count() == 1

        params.id = livro.id

        controller.delete()

        assert Livro.count() == 0
        assert Livro.get(livro.id) == null
        assert response.redirectedUrl == '/livro/list'
    }
}
