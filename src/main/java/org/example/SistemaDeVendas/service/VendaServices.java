package org.example.SistemaDeVendas.service;

import org.example.SistemaDeVendas.model.Cliente;
import org.example.SistemaDeVendas.model.Produto;
import org.example.SistemaDeVendas.model.Venda;
import org.example.SistemaDeVendas.model.Vendedor;
import org.example.SistemaDeVendas.repository.VendaRepository;

import java.time.LocalDate;
import java.util.List;

public class VendaServices {

    private VendaRepository vendaRepository;

    public VendaServices(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public void cadastrarVenda(Cliente cliente, Vendedor vendedor, Produto produto, double totalVenda, LocalDate data){
        Venda venda = new Venda(cliente, vendedor, produto, totalVenda, data);
        vendaRepository.cadastrarVenda(venda);
    }

    public List<Venda> listarVendas() {
        return vendaRepository.listarVendas();
    }

    public List<Venda> listarVendaPelaData(LocalDate data){
        return vendaRepository.buscarVendaPelaData(data);
    }

    public List<Venda> buscarVendaPeloCliente(String clienteCpf){
        return vendaRepository.buscarVendaPeloCliente(clienteCpf);
    }

    public List<Venda> buscarVendaPeloVendedor(String vendedorCpf){
        return vendaRepository.buscarVendaPeloVendedor(vendedorCpf);
    }

    public double calcularTotalCompraCliente(String clienteCpf){
        List<Venda> compras = vendaRepository.buscarVendaPeloCliente(clienteCpf);
        double total = 0;
        for(Venda compra : compras){
            total += compra.getTotalVenda();
        }
        return total;
    }

}
