import org.example.SistemaDeVendas.model.Cliente;
import org.example.SistemaDeVendas.model.Produto;
import org.example.SistemaDeVendas.model.Venda;
import org.example.SistemaDeVendas.model.Vendedor;
import org.example.SistemaDeVendas.repository.VendaRepository;
import org.example.SistemaDeVendas.service.VendaServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VendaServicesTest {

    @Mock
    private VendaRepository vendaRepository;

    private VendaServices vendaServices;

    @BeforeEach
    public void config() {
        MockitoAnnotations.openMocks(this);
        vendaServices = new VendaServices(vendaRepository);
    }

    @Test
    public void testandoCadastroDeUmaVenda() {
        //criando os parâmetros necessários para criar uma venda
        Cliente cliente = new Cliente("Cliente teste", "123.123.123-12", "cliente@gmail.com");
        Vendedor vendedor = new Vendedor("Vendedor Teste", "234.234.234-12", "vendedor@gmail.com");
        Produto produto = new Produto("Produto Teste", 21.20, "123234345456");
        double totalVenda = 21.20;
        LocalDate data = LocalDate.now();

        //acessando o método
        vendaServices.cadastrarVenda(cliente, vendedor, produto, totalVenda, data);

        //Usamos o Mockito.times(1) para chamar exatamente 1 vez o método cadastrarVenda de vendaRepository com qualquer objeto "venda" como argumento, ...
        //usamos o Mockito.any(Venda.class) para mocar esse objeto.
        Mockito.verify(vendaRepository, Mockito.times(1)).cadastrarVenda(Mockito.any(Venda.class));
    }

    @Test
    public void testeParaVerSeEstaLitandoAsVendasCorretamente() {
        Cliente cliente = new Cliente("Cliente teste", "123.123.123-12", "cliente@gmail.com");
        Vendedor vendedor = new Vendedor("Vendedor Teste", "234.234.234-12", "vendedor@gmail.com");
        Produto produto = new Produto("Produto Teste", 21.20, "123234345456");
        double totalVenda = 21.20;
        LocalDate data = LocalDate.now();

        Cliente cliente2 = new Cliente("Cliente teste 2", "345.345.345-34", "cliente2@gmail.com");
        Vendedor vendedor2 = new Vendedor("Vendedor Teste 2", "567.567.567-56", "vendedor2@gmail.com");
        Produto produto2 = new Produto("Produto Teste 2", 41.20, "345456567678");
        double totalVenda2 = 41.20;
        LocalDate data2 = LocalDate.now();

        //criando lista para add as 2 vendas
        List<Venda> vendas = new ArrayList<>();

        //criando as 2 vendas e add na lista
        vendas.add(new Venda(cliente, vendedor,produto, totalVenda, data));
        vendas.add(new Venda(cliente2,vendedor2, produto2, totalVenda2 ,data2));

        Mockito.when(vendaRepository.listarVendas()).thenReturn(vendas);

        List<Venda> resultadoLista = vendaServices.listarVendas();

        Assertions.assertEquals(vendas, resultadoLista);
    }

    @Test
    public void testandoSeEstaBuscandoAVendaPelaData() {
        Cliente cliente = new Cliente("Cliente teste", "123.123.123-12", "cliente@gmail.com");
        Vendedor vendedor = new Vendedor("Vendedor Teste", "234.234.234-12", "vendedor@gmail.com");
        Produto produto = new Produto("Produto Teste", 21.20, "123234345456");
        double totalVenda = 21.20;
        LocalDate data = LocalDate.now();

        Cliente cliente2 = new Cliente("Cliente teste 2", "345.345.345-34", "cliente2@gmail.com");
        Vendedor vendedor2 = new Vendedor("Vendedor Teste 2", "567.567.567-56", "vendedor2@gmail.com");
        Produto produto2 = new Produto("Produto Teste 2", 41.20, "345456567678");
        double totalVenda2 = 41.20;
        LocalDate data2 = LocalDate.now();

        List<Venda> vendas = new ArrayList<>();
        vendas.add(new Venda(cliente, vendedor,produto, totalVenda, data));
        vendas.add(new Venda(cliente2,vendedor2, produto2, totalVenda2 ,data2));

        Mockito.when(vendaRepository.buscarVendaPelaData(data)).thenReturn(vendas);

        List<Venda> resultadoBuscaaPelaData = vendaServices.buscarVendaPelaData(data);

        Assertions.assertEquals(vendas, resultadoBuscaaPelaData);
    }

    @Test
    public void testeSeEstaBuscandoAsVendasPeloCpfDoCliente() {
        Cliente cliente = new Cliente("Cliente teste", "123.123.123-12", "cliente@gmail.com");
        Vendedor vendedor = new Vendedor("Vendedor Teste", "234.234.234-12", "vendedor@gmail.com");
        Produto produto = new Produto("Produto Teste", 21.20, "123234345456");
        double totalVenda = 21.20;
        LocalDate data = LocalDate.now();

        Cliente cliente2 = new Cliente("Cliente teste 2", "345.345.345-34", "cliente2@gmail.com");
        Vendedor vendedor2 = new Vendedor("Vendedor Teste 2", "567.567.567-56", "vendedor2@gmail.com");
        Produto produto2 = new Produto("Produto Teste 2", 41.20, "345456567678");
        double totalVenda2 = 41.20;
        LocalDate data2 = LocalDate.now();

        List<Venda> vendas = new ArrayList<>();
        vendas.add(new Venda(cliente, vendedor,produto, totalVenda, data));
        vendas.add(new Venda(cliente2,vendedor2, produto2, totalVenda2 ,data2));

        Mockito.when(vendaRepository.buscarVendaPeloCliente("123.123.123-12")).thenReturn(vendas);

        List<Venda> resultadoBusca = vendaServices.buscarVendaPeloCliente("123.123.123-12");

        Assertions.assertEquals(vendas, resultadoBusca);
    }

    @Test
    public void testBuscarVendaPeloVendedor() {
        Cliente cliente = new Cliente("Cliente teste", "123.123.123-12", "cliente@gmail.com");
        Vendedor vendedor = new Vendedor("Vendedor Teste", "234.234.234-12", "vendedor@gmail.com");
        Produto produto = new Produto("Produto Teste", 21.20, "123234345456");
        double totalVenda = 21.20;
        LocalDate data = LocalDate.now();

        Cliente cliente2 = new Cliente("Cliente teste 2", "345.345.345-34", "cliente2@gmail.com");
        Vendedor vendedor2 = new Vendedor("Vendedor Teste 2", "567.567.567-56", "vendedor2@gmail.com");
        Produto produto2 = new Produto("Produto Teste 2", 41.20, "345456567678");
        double totalVenda2 = 41.20;
        LocalDate data2 = LocalDate.now();

        List<Venda> vendas = new ArrayList<>();
        vendas.add(new Venda(cliente, vendedor,produto, totalVenda, data));
        vendas.add(new Venda(cliente2,vendedor2, produto2, totalVenda2 ,data2));

        Mockito.when(vendaRepository.buscarVendaPeloVendedor("vendedor2@gmail.com")).thenReturn(vendas);

        List<Venda> resultadoBusca = vendaServices.buscarVendaPeloVendedor("vendedor2@gmail.com");

        Assertions.assertEquals(vendas, resultadoBusca);
    }
}
