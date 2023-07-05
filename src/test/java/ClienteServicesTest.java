import org.example.SistemaDeVendas.model.Cliente;
import org.example.SistemaDeVendas.repository.ClienteRepository;
import org.example.SistemaDeVendas.service.ClienteServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class ClienteServicesTest {

    @Mock
    private ClienteRepository clienteRepository;

    private ClienteServices clienteServices;

    @BeforeEach
    public void config() {
        MockitoAnnotations.openMocks(this);
        clienteServices = new ClienteServices(clienteRepository);
    }

    @Test
    public void testeDeCadastroDeUmCliente() {
        Cliente cliente = new Cliente("Cliente Numero um", "456.456.456-34", "numberum@gmail.com");

        //Passando as 2 validações do throws como null para realizar o cadastro devidamente.
        Mockito.when(clienteRepository.buscarCliente(cliente.getCpf())).thenReturn(null);
        Mockito.when(clienteRepository.buscarCliente(cliente.getEmail())).thenReturn(null);

        clienteServices.cadastrarCliente(cliente);

        Mockito.verify(clienteRepository, Mockito.times(1)).cadastrarCliente(cliente);
    }
    @Test
    public void testaSeOThrowsDeDuplicidadeCadastroDeEmailEstaFuncionando() {

        Cliente cliente = new Cliente("Cliente Um", "123.123.123-23", "clienteone@gmail.com");


        Mockito.when(clienteRepository.buscarCliente(cliente.getCpf())).thenReturn(null);
        Mockito.when(clienteRepository.buscarCliente(cliente.getEmail())).thenReturn(new Cliente("Cliente 2","123.123.123-23","clienteone@gmail.com"));

        Assertions.assertThrows(RuntimeException.class, () -> clienteServices.cadastrarCliente(cliente));
    }

    @Test
    public void testaSeOThrowsDeDuplicidadeCadastroDeCpfEstaFuncionando() {

        Cliente cliente = new Cliente("Cliente Um", "123.123.123-23", "clienteone@gmail.com");

        Mockito.when(clienteRepository.buscarCliente(cliente.getEmail())).thenReturn(null);
        Mockito.when(clienteRepository.buscarCliente(cliente.getCpf())).thenReturn(new Cliente("Cliente 2","123.123.123-23","clienteone@gmail.com"));

        Assertions.assertThrows(RuntimeException.class, () -> clienteServices.cadastrarCliente(cliente));
    }


    @Test
    public void testaSeListaOsClientes() {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Cliente 1", "123.123.123-12", "cliente1@gmail.com"));
        clientes.add(new Cliente("Cliente 2", "234.234.234-23", "cliente2@gmail.com"));

        Mockito.when(clienteRepository.listarClientes()).thenReturn(clientes);

        List<Cliente> listaDeClientes = clienteServices.listarClientes();

        Assertions.assertEquals(clientes, listaDeClientes);
    }

    @Test
    public void testaSeABuscaDoClientePeloCpfEstaAcontecendo() {

        String cpf = "123.123.123-12";
        Cliente cliente = new Cliente("Cliente Teste", "cpf", "cliente@gmail.com");

        Mockito.when(clienteRepository.buscarCliente(cpf)).thenReturn(cliente);

        Cliente resultadoBuscaCliente = clienteServices.buscarCliente(cpf);

        Assertions.assertEquals(cliente, resultadoBuscaCliente);
    }
}
