package agenda

class Cidade {
    
    static constraints = {
        nome (blank: false, size: 1..80)
        estado (blank: false, size: 2..2)
    }
    String nome // nome da cidade
    String estado // sigla do estado
    String toString () {
        return nome + "−" + estado
    }
    static Set estados = null
    static Collection estados () {
        if (estados == null) {
            estados = new TreeSet()
            estados.add("")
            def cidades = Cidade.findAll()
            cidades.each { cidade-> estados.add(cidade.estado) }
        }
        return estados
    }
}
