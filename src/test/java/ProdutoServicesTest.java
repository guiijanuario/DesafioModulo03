import org.example.SistemaDeVendas.model.Cliente;
import org.example.SistemaDeVendas.model.Produto;
import org.example.SistemaDeVendas.repository.ClienteRepository;
import org.example.SistemaDeVendas.repository.ProdutoRepository;
import org.example.SistemaDeVendas.service.ClienteServices;
import org.example.SistemaDeVendas.service.ProdutoServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class ProdutoServicesTest {

    @Mock
    private ProdutoRepository produtoRepository;

    private ProdutoServices produtoServices;

    @BeforeEach
    public void config() {
        MockitoAnnotations.openMocks(this);
        produtoServices = new ProdutoServices(produtoRepository);
    }

    @Test
    public void testandoSeEstaCadastrandoUmProduto() {

        Produto produto = new Produto("Roupão", 49.90, "345456567678");

        Mockito.when(produtoRepository.buscarProduto(produto.getCodigoBarras())).thenReturn(null);

        produtoServices.cadastrarProduto(produto);

        Mockito.verify(produtoRepository, Mockito.times(1)).cadastrarProduto(produto);
    }

    @Test
    public void testaSeOThrowsDeCodigoDeBarrasRepetidoEstaFuncionando() {
        Produto produto = new Produto("Roupão", 49.90, "345456567678");

        Mockito.when(produtoRepository.buscarProduto(produto.getCodigoBarras())).thenReturn(new Produto("Roupão", 49.90, "345456567678"));

        Assertions.assertThrows(RuntimeException.class, () -> produtoServices.cadastrarProduto(produto));
    }

    @Test
    public void testaSeOThrowsDeCodigoDeBarrasEstaCorreto() {
        Produto produto = new Produto("Roupão", 49.90, "345456");

        Assertions.assertThrows(RuntimeException.class, () -> produtoServices.cadastrarProduto(produto));
    }

    @Test
    public void testListarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Roupão", 49.90, "345456567678"));
        produtos.add(new Produto("Camiseta", 39.90, "123234345456"));

        Mockito.when(produtoRepository.listarProdutos()).thenReturn(produtos);

        List<Produto> resultadoDalistaDeprodutos = produtoServices.listarProdutos();

        Assertions.assertEquals(produtos, resultadoDalistaDeprodutos);
    }

    @Test
    public void testandoSeEstaSendoFeitoAbuscaDoProdutoPeloCodigoDeBarras() {
        String codigoBarras = "123234345456";
        Produto produto = new Produto("Roupão", 49.90, codigoBarras);

        Mockito.when(produtoRepository.buscarProduto(codigoBarras)).thenReturn(produto);

        Produto resultadoDaBuscaDoProdutoPeloCodigoDeBarras = produtoServices.buscarProduto(codigoBarras);

        Assertions.assertEquals(produto, resultadoDaBuscaDoProdutoPeloCodigoDeBarras);
    }
}
