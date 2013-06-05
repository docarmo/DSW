package agenda

class Contato {
    static belongsTo = [usuario: Usuario]

    static constraints = {
        nome (blank: false)
        endereco (blank: true)
        complemento (blank: true)
        cidade (blank: true )
        fixo (matches: /^\(?(\d{2})?\)?\d{4}-\d{4}$/)
        celular (matches: /^\(?(\d{2})?\)?\d{4}-\d{4}$/)
        principal (email: true, blank: false)
        alternativo (email: true)
        homepage (url: true)
        dataNasc (blank: true)
    }
    String nome
    String endereco
    String complemento
    Cidade cidade
    String fixo
    String celular
    Date dataNasc
    String principal
    String alternativo
    String homepage
    
    String toString () {
        return nome
    }
}
