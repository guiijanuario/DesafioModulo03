package org.example.SistemaDeVendas.controller;

import org.example.SistemaDeVendas.model.Cliente;
import org.example.SistemaDeVendas.model.Produto;
import org.example.SistemaDeVendas.model.Venda;
import org.example.SistemaDeVendas.model.Vendedor;
import org.example.SistemaDeVendas.repository.ClienteRepository;
import org.example.SistemaDeVendas.repository.ProdutoRepository;
import org.example.SistemaDeVendas.repository.VendaRepository;
import org.example.SistemaDeVendas.repository.VendedorRepository;
import org.example.SistemaDeVendas.service.ClienteServices;
import org.example.SistemaDeVendas.service.ProdutoServices;
import org.example.SistemaDeVendas.service.VendaServices;
import org.example.SistemaDeVendas.service.VendedorServices;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

//Classe para cuidar e interagir com o usuário
public class VendaController{

    private VendaServices vendaServices;

    private ClienteServices clienteServices;
    private ProdutoServices produtoServices;
    private VendedorServices vendedorServices;

    public VendaController(VendaServices vendaServices, ClienteServices clienteServices, ProdutoServices produtoServices, VendedorServices vendedorServices) {
        this.vendaServices = vendaServices;
        this.clienteServices = clienteServices;
        this.produtoServices = produtoServices;
        this.vendedorServices = vendedorServices;
    }

    public void cadastrarVendaMenu(){
        System.out.println("\n[---------------------------------]");
        System.out.println("      Cadastrar Venda");
        System.out.println("[---------------------------------]");

        System.out.print("Digite o CPF do Cliente: ");
        String cpfCliente = new Scanner(System.in).nextLine();
        Cliente clienteEncontrado = clienteServices.buscarCliente(cpfCliente);

        System.out.print("Digite o e-mail do Vendedor: ");
        String emailVendedor = new Scanner(System.in).nextLine();
        Vendedor vendedorEncontrato = vendedorServices.buscarVendedor(emailVendedor);

        System.out.print("Digite o código de barras do produto: ");
        String codigoDeBarras = new Scanner(System.in).nextLine();
        Produto produtoEncontrato = produtoServices.buscarProduto(codigoDeBarras);

        System.out.print("Digite o valor da venda: ");
        double valorTotalVenda = new Scanner(System.in).nextDouble();

        try {
            vendaServices.cadastrarVenda(clienteEncontrado, vendedorEncontrato,produtoEncontrato, valorTotalVenda, LocalDate.now());
            System.out.println("\n[--------------------------------------]");
            System.out.println("Sucess: Venda cadastrada com sucesso!");
            System.out.println("[--------------------------------------]\n");

        } catch (RuntimeException e) {
            System.out.println("\n[--------------------------------------]");
            System.out.println("Error: Erro ao cadastrar venda: " + e.getMessage());
            System.out.println("[--------------------------------------]");
        }
    }

   /* public void listarVendasPorData(){
        List<Venda> vendas = vendaServices.listarVendaPelaData();

        System.out.print("\n[---------------------------------]");
        System.out.print("\n Esses são os clientes cadastrados");
        System.out.print("\n[---------------------------------]\n");

        for (Cliente cliente : clientes) {
            System.out.println("Nome completo: " + cliente.getNome());
            System.out.println("E-mail: " + cliente.getEmail());
            System.out.println("CPF: " + cliente.getCpf() + "\n");
        }
    }*/

}