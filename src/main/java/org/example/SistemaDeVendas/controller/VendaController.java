package org.example.SistemaDeVendas.controller;

import org.example.SistemaDeVendas.model.Cliente;
import org.example.SistemaDeVendas.model.Produto;
import org.example.SistemaDeVendas.model.Venda;
import org.example.SistemaDeVendas.model.Vendedor;
import org.example.SistemaDeVendas.service.ClienteServices;
import org.example.SistemaDeVendas.service.ProdutoServices;
import org.example.SistemaDeVendas.service.VendaServices;
import org.example.SistemaDeVendas.service.VendedorServices;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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

        if (clienteEncontrado == null){
            System.out.println("\n[ --------------------------------------------------------------]");
            System.out.println(" Error: Cliente não encontrado. Não é possível cadastrar a venda.");
            System.out.println("[--------------------------------------------------------------]\n");
            return;
        }

        System.out.print("Digite o e-mail do Vendedor: ");
        String emailVendedor = new Scanner(System.in).nextLine();
        Vendedor vendedorEncontrato = vendedorServices.buscarVendedor(emailVendedor);

        if (vendedorEncontrato == null){
            System.out.println("\n[ --------------------------------------------------------------]");
            System.out.println("Vendedor não encontrado. Não é possível cadastrar a venda.");
            System.out.println("[--------------------------------------------------------------]\n");
            return;
        }

        System.out.print("Digite o código de barras do produto: ");
        String codigoDeBarras = new Scanner(System.in).nextLine();
        Produto produtoEncontrato = produtoServices.buscarProduto(codigoDeBarras);

        if (produtoEncontrato == null){
            System.out.println("\n[ --------------------------------------------------------------]");
            System.out.println("Produto não encontrado. Não é possível cadastrar a venda.");
            System.out.println("[--------------------------------------------------------------]\n");
            return;
        }

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

    public void listarVendasMenu(){
        try {

            List<Venda> vendas = vendaServices.listarVendas();

            System.out.print("\n[---------------------------------]");
            System.out.print("\n Esses são as vendas cadastradas");
            System.out.print("\n[---------------------------------]\n");

            for (Venda venda : vendas) {
                System.out.println("[---------------------------------------------]");
                System.out.println("Nome do cliente: " + venda.getCliente().getNome());
                System.out.println("CPF do Cliente: " + venda.getCliente().getCpf());
                System.out.println("Produto que comprou: " + venda.getProduto().getNome());
                System.out.println("Valor total da venda: " + venda.getProduto().getPreco());
                System.out.println("Vendedor que atendeu: " + venda.getVendedor().getNome());
                System.out.println("Comissão de 5% do vendedor: " +((venda.getTotalVenda() * 5) / 100) ) ;
                System.out.println("[---------------------------------------------]");
            }
        } catch (Exception e){
            System.out.println("Ocorreu um erro ao listar as vendas: " + e.getMessage());
        }
    }

    public void buscarVendaMenu() {
        try {
            int opcaoMenuListar;
            do {
                System.out.println("\n============ Área para Buscar Venda ==========");
                System.out.println("1. Buscar venda pelo Cliente");
                System.out.println("2. Buscar venda pelo Vendedor");
                System.out.println("3. Buscar venda pela Data");
                System.out.println("4. Sair");
                System.out.print("Digite a opção desejada: ");
                opcaoMenuListar = new Scanner(System.in).nextInt();

                switch (opcaoMenuListar) {
                    case 1:
                        System.out.print("\n[-----------------------------------]");
                        System.out.print("\n  Buscar venda pelo CPF do Cliente");
                        System.out.print("\n[-----------------------------------]\n");

                        System.out.print("Digite o CPF do cliente: ");
                        String cpfCliente = new Scanner(System.in).nextLine();

                        vendaServices.buscarVendaPeloCliente(cpfCliente);

                        break;
                    case 2:
                        System.out.print("\n[---------------------------------------]");
                        System.out.print("\n  Buscar venda pelo E-mail do Vendedor");
                        System.out.print("\n[---------------------------------------]\n");

                        System.out.print("Digite o E-mail do vendedor: ");
                        String emailVendedor = new Scanner(System.in).nextLine();

                        vendaServices.buscarVendaPeloVendedor(emailVendedor);
                        break;
                    case 3:
                        System.out.print("\n[------------------------------------]");
                        System.out.print("\n  Buscar venda pela data da venda");
                        System.out.print("\n[------------------------------------]\n");

                        System.out.print("Digite a data da compra (YYYY-MM-DD): ");
                        String dataString = new Scanner(System.in).nextLine();

                        try{
                            LocalDate dataBusca = LocalDate.parse(dataString);

                            vendaServices.buscarVendaPelaData(dataBusca);
                        } catch (DateTimeParseException e) {
                            System.out.print("\n[----------------------------------------------------------------------------]");
                            System.out.println("Erro: Data inválida. Certifique-se de usar o formato correto (yyyy-MM-dd).");
                            System.out.print("[----------------------------------------------------------------------------]");
                        }
                        break;
                    case 4:
                        System.out.println("Saindo do programa...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } while (opcaoMenuListar != 4);
        } catch (Exception e){
            System.out.println("Ocorreu um erro ao listar menu de busca: " + e.getMessage());
        }
    }

}
