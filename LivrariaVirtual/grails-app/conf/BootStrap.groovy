import lv.Cd
import lv.Dvd
import lv.Livro

class BootStrap {

    def init = { servletContext ->
            new Cd(nome:"In a Silent Way", preco:17.90,
                quantidade:4, artista:"Miles Davis").save()
            new Dvd(nome:"O Exterminador do Futuro", preco:19.90,
                quantidade:6, diretor:"James Cameron").save()
            new Livro(nome:"Engenharia Web", preco:77.90,
                quantidade:1, autor:"Roger Pressman & David Lowe").save()
    }
    
    def destroy = {
    }
}
