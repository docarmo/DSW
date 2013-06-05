package lv

class Livro extends Produto {
    
    static constraints = {
        autor(blank:false, maxLength:50)
    }

    String autor
}