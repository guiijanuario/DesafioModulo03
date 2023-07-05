import org.example.SistemaDeVendas.model.Cliente;
import org.example.SistemaDeVendas.model.Produto;
import org.example.SistemaDeVendas.repository.ClienteDB;
import org.example.SistemaDeVendas.repository.ProdutoDB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProdutoDBTest {

    private ProdutoDB produtoDB;

    @BeforeEach
    public void config(){
        produtoDB = new ProdutoDB();
    }

    @Test
    public void testarSeEstaCadastrandoUmProduto() {
        //instancia o meu produto
        Produto produto = new Produto("Caderno", 4.90, "123234345456");
        //chamo o método cadastrarVendedor que fica dentro da classe ProdutoDB, e passo o produto cadastrado para cadastrar o produto.
        produtoDB.cadastrarProduto(produto);

        List<Produto> produtos = produtoDB.listarProdutos();

        //verifica se tem 1 produto cadastrado no "banco de dados"
        Assertions.assertEquals(1, produtos.size());

        Assertions.assertEquals(produto, produtos.get(0));
    }

    @Test
    public void testarSeEstaBuscandooProdutoCodigoDeBarras() {
        //instancia o meu produto
        Produto produto = new Produto("Caderno", 4.90, "123234345456");
        //chamo o método cadastrarVendedor que fica dentro da classe ProdutoDB, e passo o produto cadastrado para cadastrar o produto.
        produtoDB.cadastrarProduto(produto);

        // chama o método dentro de ProdutoDB que faz a busca do produto pelo codigo de barras.
        Produto seProdutoEncontrado = produtoDB.buscarProduto("123234345456");

        //Se o vendedor que é o que foi instanciado no começo for igual ao que foi encontrado no cadastro, a validação ocorre corretamente.
        Assertions.assertEquals(produto, seProdutoEncontrado);
    }
}
