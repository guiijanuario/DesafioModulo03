package org.example.SistemaDeVendas.repository;

import org.example.SistemaDeVendas.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDB implements ProdutoRepository{
    private List<Produto> produtos;

    public ProdutoDB() {
        this.produtos = new ArrayList<>();
    }


    @Override
    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
    }

    @Override
    public Produto buscarProduto(String codigoBarras) {
        for (Produto produto : produtos){
            if (produto.getCodigoBarras().equalsIgnoreCase(codigoBarras)){
                return produto;
            }
        }
        return null;
    }

    @Override
    public List<Produto> listarProdutos() {
        return produtos;
    }
}
