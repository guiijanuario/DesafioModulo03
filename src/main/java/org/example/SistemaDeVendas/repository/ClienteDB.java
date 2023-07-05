package org.example.SistemaDeVendas.repository;


import org.example.SistemaDeVendas.model.Cliente;

import java.util.ArrayList;
import java.util.List;

//Classe para armazenar os dados do cliente
public class ClienteDB implements ClienteRepository{

    private List<Cliente> clientes;

    public ClienteDB() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public Cliente buscarCliente(String cpf) {
        for(Cliente cliente : clientes){
            if(cliente.getCpf().equalsIgnoreCase(cpf)){
                return cliente;
            }
        }
        return null;
    }

    @Override
    public List<Cliente> listarClientes() {
        return clientes;
    }
}
