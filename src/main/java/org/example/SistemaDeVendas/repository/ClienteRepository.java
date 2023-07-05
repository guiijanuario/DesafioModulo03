package org.example.SistemaDeVendas.repository;


import org.example.SistemaDeVendas.model.Cliente;

import java.util.List;


public interface ClienteRepository {


    void cadastrarCliente(Cliente cliente);
    Cliente buscarCliente(String cpf);
    List<Cliente> listarClientes();


}
