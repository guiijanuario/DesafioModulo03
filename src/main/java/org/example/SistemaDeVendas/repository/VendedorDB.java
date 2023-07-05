package org.example.SistemaDeVendas.repository;

import org.example.SistemaDeVendas.model.Vendedor;

import java.util.ArrayList;
import java.util.List;

public class VendedorDB implements VendedorRepository{

    private List<Vendedor> vendedores;

    public VendedorDB() {
        this.vendedores = new ArrayList<>();
    }


    @Override
    public void cadastrarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    @Override
    public Vendedor buscarVendedorPorEmail(String email) {
        for (Vendedor vendedor : vendedores){
            if (vendedor.getEmail().equalsIgnoreCase(email)){
                return vendedor;
            }
        }
        return null;
    }

    @Override
    public List<Vendedor> listarVendedores() {
        return vendedores;
    }
}
