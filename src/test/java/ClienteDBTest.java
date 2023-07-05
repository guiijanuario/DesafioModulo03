import org.example.SistemaDeVendas.model.Cliente;
import org.example.SistemaDeVendas.model.Vendedor;
import org.example.SistemaDeVendas.repository.ClienteDB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ClienteDBTest {

    private ClienteDB clienteDB;

    @BeforeEach
    public void config(){
        clienteDB = new ClienteDB();
    }

    @Test
    public void testarSeEstaCadastrandoUmCliente() {
        //instancia o meu cliente
        Cliente cliente = new Cliente("Guilherme Januário", "123.123.123-12", "guilherme@gmail.com");
        //chamo o método cadastrarVendedor que fica dentro da classe clienteDB, e passo o cliente cadastrado para cadastrar o cliente.
        clienteDB.cadastrarCliente(cliente);

        List<Cliente> clientes = clienteDB.listarClientes();

        //verifica se tem 1 cliente cadastrado no "banco de dados"
        Assertions.assertEquals(1, clientes.size());

        Assertions.assertEquals(cliente, clientes.get(0));
    }

    @Test
    public void testarSeEstaBuscandooClientePeloCPF() {
        //instancia o meu cliente
        Cliente cliente = new Cliente("Guilherme Januário", "123.123.123-12", "guilherme@gmail.com");
        //chamo o método cadastrarVendedor que fica dentro da classe clienteDB, e passo o cliente cadastrado para cadastrar o cliente.
        clienteDB.cadastrarCliente(cliente);

        // chama o método dentro de ClienteDB que faz a busca do cliente pelo cpf.
        Cliente seClienteEncontrado = clienteDB.buscarCliente("123.123.123-12");

        //Se o vendedor que é o que foi instanciado no começo for igual ao que foi encontrado no cadastro, a validação ocorre corretamente.
        Assertions.assertEquals(cliente, seClienteEncontrado);
    }
}
