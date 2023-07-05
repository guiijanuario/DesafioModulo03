package org.example.SistemaDeVendas.model;

import java.time.LocalDate;

public class Venda {

    private Cliente cliente;
    private Vendedor vendedor;
    private Produto produto;
    private double totalVenda;
    private LocalDate horarioDaVenda;

    public Venda(Cliente cliente, Vendedor vendedor, Produto produto, double totalVenda, LocalDate horarioDaVenda) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.produto = produto;
        this.totalVenda = totalVenda;
        this.horarioDaVenda = horarioDaVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(double totalVenda) {
        this.totalVenda = totalVenda;
    }

    public LocalDate getHorarioDaVenda() {
        return horarioDaVenda;
    }

    public void setHorarioDaVenda(LocalDate horarioDaVenda) {
        this.horarioDaVenda = horarioDaVenda;
    }
}
