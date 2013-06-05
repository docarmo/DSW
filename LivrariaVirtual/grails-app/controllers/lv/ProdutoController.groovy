package lv

class ProdutoController {
    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [produtoInstanceList: Produto.list(params),
            produtoInstanceTotal: Produto.count()]
    }
}

