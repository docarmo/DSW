package lv

class Cd extends Produto {

    static constraints = {
        artista(blank:false, maxLength:50)
    }

    String artista // nome do artista ou banda
}