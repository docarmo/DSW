package lv

class Descricao {

    static belongsTo = Produto
    
    static constraints = {
        texto(blank: false, maxSize: 500)
        imagem(blank: false)
        audio(nullable: true)
        video(nullable: true)
        produto(unique: true)
    }
    
    String texto // descricao textual
    
    String imagem // nome do arquivo imagem
    
    String audio // nome do arquivo audio
    
    String video // nome do arquivo video
    
    Produto produto
}
