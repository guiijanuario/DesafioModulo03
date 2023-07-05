package org.example.SistemaDeVendas.service;

import org.example.SistemaDeVendas.model.Cliente;
import org.example.SistemaDeVendas.model.Vendedor;
import org.example.SistemaDeVendas.repository.VendedorRepository;

import java.util.List;

public class VendedorServices {

    private VendedorRepository vendedorRepository;

    public VendedorServices(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    public void cadastrarVendedor(Vendedor vendedor) {
        Vendedor vendedorCadastrado = vendedorRepository.buscarVendedorPorEmail(vendedor.getEmail());

        if (vendedorCadastrado != null) {
            throw new RuntimeException("[------------------------------------]\n" +
                    "E-MAIL já cadastrado para outro vendedor.\n" +
                    "[------------------------------------]");
        }

        if (!validarEmailArroba(vendedor.getEmail())) {
            throw new RuntimeException("[---------------]\n" +
                    "E-mail inválido.\n" +
                    "[---------------]");
        }
        vendedorRepository.cadastrarVendedor(vendedor);
    }

    private boolean validarEmailArroba(String email) {
        return email.contains("@");
    }

    public List<Vendedor> listarVendedores(){
        return vendedorRepository.listarVendedores();
    }

    public Vendedor buscarVendedor(String email){
        return vendedorRepository.buscarVendedorPorEmail(email);
    }

}
