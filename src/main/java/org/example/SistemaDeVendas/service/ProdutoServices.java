package org.example.SistemaDeVendas.service;

import org.example.SistemaDeVendas.model.Produto;
import org.example.SistemaDeVendas.repository.ProdutoRepository;

import java.util.List;

public class ProdutoServices {

    private ProdutoRepository produtoRepository;

    public ProdutoServices(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void cadastrarProduto(Produto produto) {
        Produto produtoCadastradoCodigoDeBarras = produtoRepository.buscarProduto(produto.getCodigoBarras());

        if (produtoCadastradoCodigoDeBarras != null) {
            throw new RuntimeException("[----------------------------------------------]\n" +
                    "Código de carras já cadastrado cadastrado para outro produto.\n" +
                    "[-----------------------------------------------]");
        }

        if (!validarCodigoDeBarras(produto.getCodigoBarras())) {
            throw new RuntimeException("[--------------------]\n" +
                    "Código de barras inválido.\n" +
                    "[--------------------]");
        }
        produtoRepository.cadastrarProduto(produto);
    }

    private boolean validarCodigoDeBarras(String codigoBarras) {
        int tamanhoPadraoCodigo = 12;
        return codigoBarras.length() == tamanhoPadraoCodigo;
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.listarProdutos();
    }

    public Produto buscarProduto(String codigoBarras){
        return produtoRepository.buscarProduto(codigoBarras);
    }
}
