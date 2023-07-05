package org.example.SistemaDeVendas.controller;

import org.example.SistemaDeVendas.model.Produto;
import org.example.SistemaDeVendas.model.Vendedor;
import org.example.SistemaDeVendas.service.VendedorServices;

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
}
