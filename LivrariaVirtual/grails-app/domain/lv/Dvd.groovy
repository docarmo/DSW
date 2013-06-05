package lv

class Dvd extends Produto {
    
    static constraints = {
        diretor(blank:false, maxLength:50, nullable: false)
    }

    String diretor // nome do diretor
}
