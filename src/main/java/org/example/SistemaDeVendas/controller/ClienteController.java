package org.example.SistemaDeVendas.controller;


import org.example.SistemaDeVendas.model.Cliente;
import org.example.SistemaDeVendas.service.ClienteServices;

import java.util.List;
import java.util.Scanner;

//Classe para cuidar e interagir com o usuário
public class ClienteController {

    private ClienteServices clienteService;

    public ClienteController(ClienteServices clienteService) {
        this.clienteService = clienteService;
    }


    public void cadastrarClienteMenu() {
        System.out.println("\n[---------------------------------]");
        System.out.println("      Cadastro de Cliente");
        System.out.println("[---------------------------------]");

        System.out.print("Digite o CPF: ");
        String cpf = new Scanner(System.in).nextLine();

        System.out.print("Nome Completo: ");
        String nome = new Scanner(System.in).nextLine();

        System.out.print("E-mail: ");
        String email = new Scanner(System.in).nextLine();

        Cliente cliente = new Cliente(nome, cpf, email);

        try {
            clienteService.cadastrarCliente(cliente);
            System.out.println("\n[--------------------------------------]");
            System.out.println("Sucess: Cliente cadastrado com sucesso!\n");

            System.out.println("  -> Nome cliente: " + cliente.getNome());
            System.out.println("  -> CPF: " + cliente.getCpf());
            System.out.println("  -> E-mail: " + cliente.getEmail());
            System.out.println("[--------------------------------------]\n");
        } catch (RuntimeException e) {
            System.out.println("\n[--------------------------------------]");
            System.out.println("Error: Erro ao cadastrar cliente: " + e.getMessage());
            System.out.println("[--------------------------------------]");
        }
    }

    public void listarClientesMenu(){
        List<Cliente> clientes = clienteService.listarClientes();

        System.out.print("\n[---------------------------------]");
        System.out.print("\n Esses são os clientes cadastrados");
        System.out.print("\n[---------------------------------]\n");

        for (Cliente cliente : clientes) {
            System.out.println("Nome completo: " + cliente.getNome());
            System.out.println("E-mail: " + cliente.getEmail());
            System.out.println("CPF: " + cliente.getCpf() + "\n");
        }
    }

    public void buscarClienteMenu() {

        System.out.print("\n[---------------------------------]");
        System.out.print("\n  Buscar o Cliente pelo CPF");
        System.out.print("\n[---------------------------------]\n");

        System.out.print("Digite o CPF do cliente: ");
        String cpfCliente = new Scanner(System.in).nextLine();

        Cliente cliente = clienteService.buscarCliente(cpfCliente);

        if (cliente != null) {
            System.out.println("[------------ Cliente encontrado ------------]");
            System.out.println("Nome do vendedor: " + cliente.getNome());
            System.out.println("E-mail vendedor: " + cliente.getEmail());
            System.out.println("CPF vendedor: " + cliente.getCpf());
            System.out.println("[---------------------------------------------]");
        } else {
            System.out.println("[-------------------------------]");
            System.out.println("Error: Cliente não encontrado.");
            System.out.println("[-------------------------------]");
        }
    }
}
