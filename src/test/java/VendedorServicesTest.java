import org.example.SistemaDeVendas.model.Cliente;
import org.example.SistemaDeVendas.model.Vendedor;
import org.example.SistemaDeVendas.repository.ClienteRepository;
import org.example.SistemaDeVendas.repository.VendedorRepository;
import org.example.SistemaDeVendas.service.ClienteServices;
import org.example.SistemaDeVendas.service.VendedorServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class VendedorServicesTest {

    @Mock
    private VendedorRepository vendedorRepository;

    private VendedorServices vendedorServices;

    @BeforeEach
    public void config() {
        MockitoAnnotations.openMocks(this);
        vendedorServices = new VendedorServices(vendedorRepository);
    }

    @Test
    public void testeDeCadastroDeUmVendedor() {
        Vendedor vendedor = new Vendedor("Vendedor Numero um", "456.456.456-34", "numberum@gmail.com");

        //Passando as 2 validações do throws como null para realizar o cadastro devidamente.
        Mockito.when(vendedorRepository.buscarVendedorPorEmail(vendedor.getEmail())).thenReturn(null);

        vendedorServices.cadastrarVendedor(vendedor);

        Mockito.verify(vendedorRepository, Mockito.times(1)).cadastrarVendedor(vendedor);
    }
    @Test
    public void testaSeOThrowsDeDuplicidadeCadastroDeEmailEstaFuncionando() {

        Vendedor vendedor = new Vendedor("Vendedor Numero um", "456.456.456-34", "numberum@gmail.com");

        Mockito.when(vendedorRepository.buscarVendedorPorEmail(vendedor.getEmail())).thenReturn(new Vendedor("Cliente 2","123.123.123-23","numberum@gmail.com"));

        Assertions.assertThrows(RuntimeException.class, () -> vendedorServices.cadastrarVendedor(vendedor));
    }


    @Test
    public void testaSeListaOsVendedores() {
        List<Vendedor> vendedores = new ArrayList<>();
        vendedores.add(new Vendedor("Vendedor 1", "123.123.123-12", "vendedor1@gmail.com"));
        vendedores.add(new Vendedor("Vendedor 2", "234.234.234-23", "vendedor2@gmail.com"));

        Mockito.when(vendedorRepository.listarVendedores()).thenReturn(vendedores);

        List<Vendedor> listaDeVendedores = vendedorServices.listarVendedores();

        Assertions.assertEquals(vendedores, listaDeVendedores);
    }

    @Test
    public void testaSeABuscaDoClientePeloEmailEstaAcontecendo() {

        String email = "vendedor@gmail.com";
        Vendedor vendedor = new Vendedor("Vendedor Nome", "123.123.123-12", email);

        Mockito.when(vendedorRepository.buscarVendedorPorEmail(email)).thenReturn(vendedor);

        Vendedor resultadoBuscaVendedor = vendedorServices.buscarVendedor(email);

        Assertions.assertEquals(vendedor, resultadoBuscaVendedor);
    }
}
