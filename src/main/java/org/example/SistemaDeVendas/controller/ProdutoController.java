package org.example.SistemaDeVendas.controller;

import org.example.SistemaDeVendas.model.Cliente;
import org.example.SistemaDeVendas.model.Produto;
import org.example.SistemaDeVendas.service.ProdutoServices;

import java.util.List;
import java.util.Scanner;

public class ProdutoController {

    private ProdutoServices produtoServices;

    public ProdutoController(ProdutoServices produtoServices) {
        this.produtoServices = produtoServices;
    }

    public void cadastrarProdutoMenu() {
        System.out.println("\n[---------------------------------]");
        System.out.println("      Cadastro de Produto");
        System.out.println("[---------------------------------]");

        System.out.print("Digite o Código de Barras: ");
        String codigoBarras = new Scanner(System.in).nextLine();

        System.out.print("Nome do Produto: ");
        String nome = new Scanner(System.in).nextLine();

        System.out.print("Preço do Produto: ");
        double preco = new Scanner(System.in).nextDouble();

        Produto produto = new Produto(nome,preco,codigoBarras);

        try {
            produtoServices.cadastrarProduto(produto);
            System.out.println("\n[--------------------------------------]");
            System.out.println("Sucess: Produto cadastrado com sucesso!");
            System.out.println("[--------------------------------------]\n");
        } catch (RuntimeException e) {
            System.out.println("\n[--------------------------------------]");
            System.out.println("Error: Erro ao cadastrar produto: " + e.getMessage());
            System.out.println("[--------------------------------------]");
        }
    }

    public void listarProdutosMenu(){
        List<Produto> produtos = produtoServices.listarProdutos();

        System.out.print("\n[---------------------------------]");
        System.out.print("\n Esses são os produtos cadastrados");
        System.out.print("\n[---------------------------------]\n");

        for (Produto produto : produtos) {
            System.out.println("Código de Barras: " + produto.getCodigoBarras());
            System.out.println("Nome Produto: " + produto.getNome());
            System.out.println("Preço Produto: " + produto.getPreco() + "\n");
        }
    }
}
