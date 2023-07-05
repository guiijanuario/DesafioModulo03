package org.example.SistemaDeVendas.service;

import org.example.SistemaDeVendas.model.Cliente;
import org.example.SistemaDeVendas.repository.ClienteRepository;

import java.util.List;

//Nessa classe colocamos as validações
public class ClienteServices {

    private ClienteRepository clienteRepository;

    public ClienteServices(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void cadastrarCliente(Cliente cliente) {
        Cliente clienteCadastradoCpf = clienteRepository.buscarCliente(cliente.getCpf());
        Cliente clienteCadastradoEmail = clienteRepository.buscarCliente(cliente.getEmail());

        if (clienteCadastradoCpf != null) {
            throw new RuntimeException("[------------------------------------]\n" +
                    "CPF já cadastrado para outro cliente.\n" +
                    "[------------------------------------]");
        }

        if (clienteCadastradoEmail != null) {
            throw new RuntimeException("[------------------------------------]\n" +
                    "E-mail já cadastrado para outro cliente.\n" +
                    "[------------------------------------]");
        }

        if (!validarEmailArroba(cliente.getEmail())) {
            throw new RuntimeException("[---------------]\n" +
                    "E-mail inválido.\n" +
                    "[---------------]");
        }
        clienteRepository.cadastrarCliente(cliente);
    }

    private boolean validarEmailArroba(String email) {
        return email.contains("@");
    }


    public List<Cliente> listarClientes(){
        return clienteRepository.listarClientes();
    }

    public Cliente buscarCliente(String cpf){
        return clienteRepository.buscarCliente(cpf);
    }
}
