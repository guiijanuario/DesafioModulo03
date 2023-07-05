import org.example.SistemaDeVendas.model.Vendedor;
import org.example.SistemaDeVendas.repository.VendedorDB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class VendedorDBTest {
    private VendedorDB vendedorDB;

    @BeforeEach
    public void config() {
        vendedorDB = new VendedorDB();
    }

    @Test
    public void testarSeEstaCadastrandoUmVendedor() {
        //instancia o meu vendedor
        Vendedor vendedor = new Vendedor("Guilherme Januário", "123.123.123-12", "guilherme@gmail.com");
        //chamo o método cadastrarVendedor que fica dentro da classe vendedorDB, e passo o vendedor cadastrado para cadastrar o vendedor.
        vendedorDB.cadastrarVendedor(vendedor);

        List<Vendedor> vendedores = vendedorDB.listarVendedores();

        //verifica se tem 1 vendedor cadastrado no "banco de dados"
        Assertions.assertEquals(1, vendedores.size());

        Assertions.assertEquals(vendedor, vendedores.get(0));
    }

    @Test
    public void testarSeEstaBuscandooVendedorPeloEmail() {
        //instancia o meu vendedor
        Vendedor vendedor = new Vendedor("Guilherme Januário", "123.123.123-12", "guilherme@gmail.com");
        //chamo o método cadastrarVendedor que fica dentro da classe vendedorDB, e passo o vendedor cadastrado para cadastrar o vendedor.
        vendedorDB.cadastrarVendedor(vendedor);

        // chama o método dentro de vendedorDB que faz a busca do vendedor pelo e-mail.
        Vendedor seVendedorEncontrado = vendedorDB.buscarVendedorPorEmail("guilherme@gmail.com");

        //Se o vendedor que é o que foi instanciado no começo for igual ao que foi encontrado no cadastro, a validação ocorre corretamente.
        Assertions.assertEquals(vendedor, seVendedorEncontrado);
    }

}
