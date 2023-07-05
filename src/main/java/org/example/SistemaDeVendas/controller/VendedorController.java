package org.example.SistemaDeVendas.controller;

import org.example.SistemaDeVendas.model.Cliente;
import org.example.SistemaDeVendas.model.Produto;
import org.example.SistemaDeVendas.model.Venda;
import org.example.SistemaDeVendas.model.Vendedor;
import org.example.SistemaDeVendas.service.VendedorServices;

import java.util.List;
import java.util.Scanner;

//Classe para cuidar e interagir com o usuário
public class VendedorController {

    private VendedorServices vendedorServices;

    public VendedorController(VendedorServices vendedorServices) {
        this.vendedorServices = vendedorServices;
    }

    public void cadastrarVendedorMenu() {
        System.out.println("\n[---------------------------------]");
        System.out.println("      Cadastro de Vendedor");
        System.out.println("[---------------------------------]");

        System.out.print("Digeite o nome do Vendedor: ");
        String nomeVendedor = new Scanner(System.in).nextLine();

        System.out.print("Digite o cpf do vendedor: ");
        String cpfVendedor = new Scanner(System.in).nextLine();

        System.out.print("Digite o e-mail do vendedor: ");
        String emailVendedor = new Scanner(System.in).nextLine();

        Vendedor vendedor = new Vendedor(nomeVendedor,cpfVendedor,emailVendedor);

        try {
            vendedorServices.cadastrarVendedor(vendedor);
            System.out.println("\n[--------------------------------------]");
            System.out.println("Sucess: Vendedor cadastrado com sucesso!");
            System.out.println("[--------------------------------------]\n");
        } catch (RuntimeException e) {
            System.out.println("\n[--------------------------------------]");
            System.out.println("Error: Erro ao cadastrar vendedor: " + e.getMessage());
            System.out.println("[--------------------------------------]");
        }
    }

    public void listarVendedorMenu(){
        try {
            List<Vendedor> vendedores = vendedorServices.listarVendedores();

            System.out.print("\n[-------------------------------------]");
            System.out.print("\n Esses são os vendedores cadastrados");
            System.out.print("\n[-------------------------------------]\n");

            for (Vendedor vendedor : vendedores) {
                System.out.println("[---------------------------------------------]");
                System.out.println("Nome do vendedor: " + vendedor.getNome());
                System.out.println("E-mail vendedor: " + vendedor.getEmail());
                System.out.println("CPF vendedor: " + vendedor.getCpf());
                System.out.println("[---------------------------------------------]");
            }
        } catch (Exception e){
            System.out.println("Ocorreu um erro ao listar vendedor: " + e.getMessage());
        }
    }

    public void buscarVendedorMenu() {

        try{
            System.out.print("\n[---------------------------------]");
            System.out.print("\n  Buscar o vendedor pelo e-mail");
            System.out.print("\n[---------------------------------]\n");

            System.out.print("Digite o E-mail do Vendedor: ");
            String emailVendedor = new Scanner(System.in).nextLine();

            Vendedor vendedor = vendedorServices.buscarVendedor(emailVendedor);

            if (vendedor != null) {
                System.out.println("[------------ Vendedor encontrado ------------]");
                System.out.println("Nome do vendedor: " + vendedor.getNome());
                System.out.println("E-mail vendedor: " + vendedor.getEmail());
                System.out.println("CPF vendedor: " + vendedor.getCpf());
                System.out.println("[---------------------------------------------]");
            } else {
                System.out.println("[-------------------------------]");
                System.out.println("Error: Vendedor não encontrado.");
                System.out.println("[-------------------------------]");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao listar o vendedor: " + e.getMessage());
        }
    }
}
