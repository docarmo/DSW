package lv

class Produto {

    static hasMany = [descricao: Descricao]
        
    static constraints = {
        nome(blank: false, maxLength:50)
        preco(nullable: false, min:new Float(0.01))
        quantidade(nullable:false, min: 0)
    }
    
    String nome // nome do produto
    float preco // preco do produto
    int quantidade // quantidade em estoque

    String toString () {
        return "[" +  this.getClass().getSimpleName() + "] " + nome
    }
}
