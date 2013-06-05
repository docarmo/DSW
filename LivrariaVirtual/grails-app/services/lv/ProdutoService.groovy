package lv

class ProdutoService {

    static expose = ['cxf']
    
    Produto[] getProdutos() {
        Produto.list() as Produto[]
    }
}
