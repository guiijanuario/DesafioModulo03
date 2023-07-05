package org.example.SistemaDeVendas.repository;

import org.example.SistemaDeVendas.model.Vendedor;

import java.util.List;

public interface VendedorRepository {

    void cadastrarVendedor(Vendedor vendedor);
    Vendedor buscarVendedorPorEmail(String email);
    List<Vendedor> listarVendedores();
}
