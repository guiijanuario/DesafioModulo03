package org.example.SistemaDeVendas.repository;

import org.example.SistemaDeVendas.model.Cliente;
import org.example.SistemaDeVendas.model.Produto;

import java.util.List;

public interface ProdutoRepository {

    void cadastrarProduto(Produto produto);
    Produto buscarProduto(String codigoDeBarras);
    List<Produto> listarProdutos();
}
