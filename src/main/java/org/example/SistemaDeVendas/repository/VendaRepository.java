package org.example.SistemaDeVendas.repository;

import org.example.SistemaDeVendas.model.Venda;

import java.time.LocalDate;
import java.util.List;

public interface VendaRepository {

    void cadastrarVenda(Venda venda);
    List<Venda> buscarVendaPelaData(LocalDate data);
    List<Venda> buscarVendaPeloCliente(String clienteCpf);
    List<Venda> buscarVendaPeloVendedor(String vendedorEmail);
    List<Venda> listarVendas();
}
