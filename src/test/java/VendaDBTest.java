import org.example.SistemaDeVendas.model.Cliente;
import org.example.SistemaDeVendas.model.Produto;
import org.example.SistemaDeVendas.model.Venda;
import org.example.SistemaDeVendas.model.Vendedor;
import org.example.SistemaDeVendas.repository.VendaDB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;

public class VendaDBTest {

    private VendaDB vendaDB;

    @BeforeEach
    public void setup() {
        vendaDB = new VendaDB();
    }


    @Test
    public void tentandoSeCadastraUmaVenda() {

        Cliente clienteMock = Mockito.mock(Cliente.class);
        Vendedor vendedorMock = Mockito.mock(Vendedor.class);
        Produto produtoMock = Mockito.mock(Produto.class);

        Mockito.when(clienteMock.getNome()).thenReturn("Guilherme Januário");
        Mockito.when(clienteMock.getCpf()).thenReturn("123.123.123-12");
        Mockito.when(clienteMock.getEmail()).thenReturn("guilherme@gmail.com");

        Mockito.when(vendedorMock.getNome()).thenReturn("Carlos Alberto");
        Mockito.when(vendedorMock.getCpf()).thenReturn("098.098.098-12");
        Mockito.when(vendedorMock.getEmail()).thenReturn("vendedor@gmail.com");

        Mockito.when(produtoMock.getNome()).thenReturn("Caderno");
        Mockito.when(produtoMock.getPreco()).thenReturn(12.98);
        Mockito.when(produtoMock.getCodigoBarras()).thenReturn("123234345456");

        String dataString = "2023-07-03";
        LocalDate dataBusca = LocalDate.parse(dataString);

        Venda venda = new Venda(clienteMock, vendedorMock, produtoMock, 12.98, dataBusca);
        vendaDB.cadastrarVenda(venda);

        List<Venda> vendas = vendaDB.listarVendas();
        Assertions.assertEquals(1, vendas.size());
        Assertions.assertEquals(venda, vendas.get(0));
    }

    @Test
    public void tentandoBuscaDaVendaPelaDataDaVenda() {

        Cliente clienteMock = Mockito.mock(Cliente.class);
        Vendedor vendedorMock = Mockito.mock(Vendedor.class);
        Produto produtoMock = Mockito.mock(Produto.class);

        Mockito.when(clienteMock.getNome()).thenReturn("Guilherme Januário");
        Mockito.when(clienteMock.getCpf()).thenReturn("123.123.123-12");
        Mockito.when(clienteMock.getEmail()).thenReturn("guilherme@gmail.com");

        Mockito.when(vendedorMock.getNome()).thenReturn("Carlos Alberto");
        Mockito.when(vendedorMock.getCpf()).thenReturn("098.098.098-12");
        Mockito.when(vendedorMock.getEmail()).thenReturn("vendedor@gmail.com");

        Mockito.when(produtoMock.getNome()).thenReturn("Caderno");
        Mockito.when(produtoMock.getPreco()).thenReturn(12.98);
        Mockito.when(produtoMock.getCodigoBarras()).thenReturn("123234345456");

        String dataString = "2023-07-03";
        LocalDate dataBusca = LocalDate.parse(dataString);

        Venda venda = new Venda(clienteMock, vendedorMock, produtoMock, 12.98, dataBusca);

        vendaDB.cadastrarVenda(venda);

        LocalDate data = venda.getHorarioDaVenda();
        List<Venda> vendasEncontradas = vendaDB.buscarVendaPelaData(data);

        Assertions.assertEquals(1, vendasEncontradas.size());
        Assertions.assertEquals(venda, vendasEncontradas.get(0));
    }


    @Test
    public void tentandoBuscaDaVendaPeloCpfDoCliente() {
        Cliente clienteMock = Mockito.mock(Cliente.class);
        Vendedor vendedorMock = Mockito.mock(Vendedor.class);
        Produto produtoMock = Mockito.mock(Produto.class);

        Mockito.when(clienteMock.getNome()).thenReturn("Guilherme Januário");
        Mockito.when(clienteMock.getCpf()).thenReturn("123.123.123-12");
        Mockito.when(clienteMock.getEmail()).thenReturn("guilherme@gmail.com");

        Mockito.when(vendedorMock.getNome()).thenReturn("Carlos Alberto");
        Mockito.when(vendedorMock.getCpf()).thenReturn("098.098.098-12");
        Mockito.when(vendedorMock.getEmail()).thenReturn("vendedor@gmail.com");

        Mockito.when(produtoMock.getNome()).thenReturn("Caderno");
        Mockito.when(produtoMock.getPreco()).thenReturn(12.98);
        Mockito.when(produtoMock.getCodigoBarras()).thenReturn("123234345456");

        String dataString = "2023-07-03";
        LocalDate dataBusca = LocalDate.parse(dataString);

        Venda venda = new Venda(clienteMock, vendedorMock, produtoMock, 12.98, dataBusca);

        vendaDB.cadastrarVenda(venda);

        String clienteCpf = venda.getCliente().getCpf();
        List<Venda> vendasCliente = vendaDB.buscarVendaPeloCliente(clienteCpf);

        Assertions.assertEquals(1, vendasCliente.size());
        Assertions.assertEquals(venda, vendasCliente.get(0));
    }



    @Test
    public void tentandoBuscaDaVendaPeloEmailDoVendedor() {
        Cliente clienteMock = Mockito.mock(Cliente.class);
        Vendedor vendedorMock = Mockito.mock(Vendedor.class);
        Produto produtoMock = Mockito.mock(Produto.class);

        Mockito.when(clienteMock.getNome()).thenReturn("Guilherme Januário");
        Mockito.when(clienteMock.getCpf()).thenReturn("123.123.123-12");
        Mockito.when(clienteMock.getEmail()).thenReturn("guilherme@gmail.com");

        Mockito.when(vendedorMock.getNome()).thenReturn("Carlos Alberto");
        Mockito.when(vendedorMock.getCpf()).thenReturn("098.098.098-12");
        Mockito.when(vendedorMock.getEmail()).thenReturn("vendedor@gmail.com");

        Mockito.when(produtoMock.getNome()).thenReturn("Caderno");
        Mockito.when(produtoMock.getPreco()).thenReturn(12.98);
        Mockito.when(produtoMock.getCodigoBarras()).thenReturn("123234345456");

        String dataString = "2023-07-03";
        LocalDate dataBusca = LocalDate.parse(dataString);

        Venda venda = new Venda(clienteMock, vendedorMock, produtoMock, 12.98, dataBusca);

        vendaDB.cadastrarVenda(venda);

        String vendedorEmail = venda.getVendedor().getEmail();
        List<Venda> vendasVendedor = vendaDB.buscarVendaPeloVendedor(vendedorEmail);

        Assertions.assertEquals(1, vendasVendedor.size());
        Assertions.assertEquals(venda, vendasVendedor.get(0));
    }


    @Test
    public void testandoSeEstaListandoTodasAsVendas() {

        Cliente clienteMock = Mockito.mock(Cliente.class);
        Vendedor vendedorMock = Mockito.mock(Vendedor.class);
        Produto produtoMock = Mockito.mock(Produto.class);

        Cliente clienteMock2 = Mockito.mock(Cliente.class);
        Vendedor vendedorMock2 = Mockito.mock(Vendedor.class);
        Produto produtoMock2 = Mockito.mock(Produto.class);

        Mockito.when(clienteMock.getNome()).thenReturn("Guilherme Januário");
        Mockito.when(clienteMock.getCpf()).thenReturn("123.123.123-12");
        Mockito.when(clienteMock.getEmail()).thenReturn("guilherme@gmail.com");

        Mockito.when(vendedorMock.getNome()).thenReturn("Carlos Alberto");
        Mockito.when(vendedorMock.getCpf()).thenReturn("098.098.098-12");
        Mockito.when(vendedorMock.getEmail()).thenReturn("vendedor@gmail.com");

        Mockito.when(produtoMock.getNome()).thenReturn("Caderno");
        Mockito.when(produtoMock.getPreco()).thenReturn(12.98);
        Mockito.when(produtoMock.getCodigoBarras()).thenReturn("123234345456");

        Mockito.when(clienteMock2.getNome()).thenReturn("Cliente teste");
        Mockito.when(clienteMock2.getCpf()).thenReturn("345.345.345-45");
        Mockito.when(clienteMock2.getEmail()).thenReturn("cliente@email.com");

        Mockito.when(vendedorMock2.getNome()).thenReturn("Vendedor Teste");
        Mockito.when(vendedorMock2.getCpf()).thenReturn("765.765.765-34");
        Mockito.when(vendedorMock2.getEmail()).thenReturn("vend@teste.com");

        Mockito.when(produtoMock2.getNome()).thenReturn("caneta");
        Mockito.when(produtoMock2.getPreco()).thenReturn(2.50);
        Mockito.when(produtoMock2.getCodigoBarras()).thenReturn("098987876765");

        String dataString = "2023-07-03";
        LocalDate dataBusca = LocalDate.parse(dataString);


        Venda venda1 = new Venda(clienteMock, vendedorMock, produtoMock, 12.98, dataBusca);
        Venda venda2 = new Venda(clienteMock2, vendedorMock2, produtoMock2, 2.50, dataBusca);

        vendaDB.cadastrarVenda(venda1);
        vendaDB.cadastrarVenda(venda2);

        List<Venda> vendas = vendaDB.listarVendas();
        Assertions.assertEquals(2, vendas.size());
        Assertions.assertTrue(vendas.contains(venda1));
        Assertions.assertTrue(vendas.contains(venda2));
    }

}
