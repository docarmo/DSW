package agenda

class Usuario extends UsuarioSec {

    static hasMany = [contatos: Contato]

    static constraints = {
        nome (blank: false)
    }

    String nome
    
    String toString () {
        return nome
    }
    
    static Collection papeis () {
        return PapelSec . findAll()
    }
}