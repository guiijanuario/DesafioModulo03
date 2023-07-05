package org.example.SistemaDeVendas.repository;

import org.example.SistemaDeVendas.model.Cliente;
import org.example.SistemaDeVendas.model.Venda;
import org.example.SistemaDeVendas.model.Vendedor;
import org.example.SistemaDeVendas.service.VendaServices;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VendaDB implements VendaRepository{

    private List<Venda> vendas;

    public VendaDB() {
        this.vendas = new ArrayList<>();
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    @Override
    public void cadastrarVenda(Venda venda) {
        vendas.add(venda);
    }

    @Override
    public List<Venda> buscarVendaPelaData(LocalDate data) {
        List<Venda> vendasEncontradas = new ArrayList<>();
        for (Venda venda : vendas){
            if(venda.getHorarioDaVenda().equals(data)){
                vendasEncontradas.add(venda);
                return vendasEncontradas;
            }
        }
        return null;
    }

    @Override
    public List<Venda> buscarVendaPeloCliente(String clienteCpf) {
        List<Venda> clientesVendas = new ArrayList<>();
        for(Venda venda : vendas){
            if(venda.getCliente().getCpf().equalsIgnoreCase(clienteCpf)){
                clientesVendas.add(venda);
            }
        }
        return clientesVendas;
    }

    @Override
    public List<Venda> buscarVendaPeloVendedor(String vendedorEmail) {
        List<Venda> vendedorVendas = new ArrayList<>();
        for(Venda venda : vendas){
            if(venda.getVendedor().getEmail().equalsIgnoreCase(vendedorEmail)){
                vendedorVendas.add(venda);
                return vendedorVendas;
            }

        }
        return null;
    }

    @Override
    public List<Venda> listarVendas() {
        return vendas;
    }
}
