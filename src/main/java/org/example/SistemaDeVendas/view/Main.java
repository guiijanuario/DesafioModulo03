package org.example.SistemaDeVendas.view;


import org.example.SistemaDeVendas.controller.ClienteController;
import org.example.SistemaDeVendas.controller.ProdutoController;
import org.example.SistemaDeVendas.controller.VendaController;
import org.example.SistemaDeVendas.controller.VendedorController;
import org.example.SistemaDeVendas.repository.*;
import org.example.SistemaDeVendas.service.ClienteServices;
import org.example.SistemaDeVendas.service.ProdutoServices;
import org.example.SistemaDeVendas.service.VendaServices;
import org.example.SistemaDeVendas.service.VendedorServices;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ClienteRepository clienteRepository = new ClienteDB();
        ClienteServices clienteServices = new ClienteServices(clienteRepository);
        ClienteController clienteController = new ClienteController(clienteServices);

        ProdutoRepository produtoRepository = new ProdutoDB();
        ProdutoServices produtoServices = new ProdutoServices(produtoRepository);
        ProdutoController produtoController = new ProdutoController(produtoServices);

        VendedorRepository vendedorRepository = new VendedorDB();
        VendedorServices vendedorServices = new VendedorServices(vendedorRepository);
        VendedorController vendedorController = new VendedorController(vendedorServices);

        VendaRepository vendaRepository = new VendaDB();
        VendaServices vendaServices = new VendaServices(vendaRepository);
        VendaController vendaController = new VendaController(vendaServices, clienteServices, produtoServices, vendedorServices);



        int opcaoMenuPrincipal;
        do {
            System.out.println("============ SISTEMA DE VENDAS ==========");
            System.out.println("1. Área de Cadastro");
            System.out.println("2. Área de Buscar");
            System.out.println("3. Área de Listar");
            System.out.println("4. Sair");
            System.out.print("Digite a opção desejada: ");
            opcaoMenuPrincipal = new Scanner(System.in).nextInt();

            switch (opcaoMenuPrincipal) {
                case 1:
                    int opcaoMenuCadastro;
                    do {
                        System.out.println("============ Área de cadastro ==========");
                        System.out.println("1. Cadastrar Cliente");
                        System.out.println("2. Cadastrar Vendedor");
                        System.out.println("3. Cadastrar Produto");
                        System.out.println("4. Cadastrar Venda");
                        System.out.println("5. Sair");
                        System.out.print("Digite a opção desejada: ");
                        opcaoMenuCadastro = new Scanner(System.in).nextInt();

                        switch (opcaoMenuCadastro) {
                            case 1:
                                clienteController.cadastrarClienteMenu();
                                break;
                            case 2:
                                vendedorController.cadastrarVendedorMenu();
                                break;
                            case 3:
                                produtoController.cadastrarProdutoMenu();
                                break;
                            case 4:
                                vendaController.cadastrarVendaMenu();
                                break;
                            case 5:
                                System.out.println("Saindo do programa...");
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }
                    } while (opcaoMenuCadastro != 5);
                    break;
                case 2:
                    int opcaoMenuBusca;
                    do {
                        System.out.println("============ Área de Busca ==========");
                        System.out.println("1. Buscar Cliente");
                        System.out.println("2. Buscar Vendedor");
                        System.out.println("3. Buscar Produto");
                        System.out.println("4. Buscar Venda");
                        System.out.println("5. Sair");
                        System.out.print("Digite a opção desejada: ");
                        opcaoMenuBusca = new Scanner(System.in).nextInt();

                        switch (opcaoMenuBusca) {
                            case 1:
                                clienteController.buscarClientePorCPF();
                                break;
                            case 2:
                                vendedorController.buscarVendedorMenu();
                                break;
                            case 3:
                                clienteController.buscarClientePorCPF();
                                break;
                            case 4:
                                System.out.println("Saindo dosdasd programa...");
                                break;
                            case 5:
                                System.out.println("Saindo do programa...");
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }
                    } while (opcaoMenuBusca != 5);
                    break;
                case 3:
                    int opcaoMenuListar;
                    do {
                        System.out.println("============ Área de listar os cadastros ==========");
                        System.out.println("1. Listar Cliente");
                        System.out.println("2. Listar Vendedor");
                        System.out.println("3. Listar Produto");
                        System.out.println("4. Listar Venda");
                        System.out.println("5. Sair");
                        System.out.print("Digite a opção desejada: ");
                        opcaoMenuListar = new Scanner(System.in).nextInt();

                        switch (opcaoMenuListar) {
                            case 1:
                                clienteController.listarClientesMenu();
                                break;
                            case 2:
                                vendedorController.listarVendedorMenu();
                                break;
                            case 3:
                                produtoController.listarProdutosMenu();
                                break;
                            case 4:
                                vendaController.listarVendasMenu();
                                break;
                            case 5:
                                System.out.println("Saindo do programa...");
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }
                    } while (opcaoMenuListar != 5);
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcaoMenuPrincipal != 4);



    }
}

