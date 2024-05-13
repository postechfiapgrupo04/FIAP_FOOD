package br.com.fiap.fiapfood.core.gateways;

import br.com.fiap.fiapfood.core.entity.EnderecoDomain;
import br.com.fiap.fiapfood.core.entity.RestauranteDomain;
import br.com.fiap.fiapfood.core.enums.TipoCozinha;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class RestauranteRepositoryTest {

    AutoCloseable openMocks;

    @Mock
    private RestauranteRepository restauranteRepository;

    @BeforeEach
    void setup() {
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void deveSalvar() {
        // Arrange
        RestauranteDomain restauranteDomain = criarRestaurante();
        when(restauranteRepository.salvar(restauranteDomain)).thenReturn(restauranteDomain);

        RestauranteDomain restaurante = restauranteRepository.salvar(restauranteDomain);
        //Assert
        assertThat(restaurante).isEqualTo(restauranteDomain);
        assertThat(restaurante.getNome()).isEqualTo(restauranteDomain.getNome());
    }

    @Test
    void deveBuscarPorIDERetornarRestaurante() {
        // Arrange
        RestauranteDomain restauranteDomain = criarRestaurante();
        when(restauranteRepository.buscarPorId(restauranteDomain.getId())).thenReturn(restauranteDomain);
        // Act
        RestauranteDomain restaurante = restauranteRepository.buscarPorId(restauranteDomain.getId());
        //Assert
        assertThat(restaurante).isEqualTo(restauranteDomain);
        assertThat(restaurante.getNome()).isEqualTo(restauranteDomain.getNome());
    }

    @Test
    void deveBuscarPorIDERetornarExcecao() {
        // Arrange
        when(restauranteRepository.buscarPorId(anyLong())).thenThrow(RuntimeException.class);
        // Act
        //Assert
        assertThatThrownBy(() -> restauranteRepository.buscarPorId(anyLong()))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void deveApagarRestaurante() {
        // Arrange
        RestauranteDomain restauranteDomain = criarRestaurante();
        doNothing()
                .when(restauranteRepository).apagar(restauranteDomain.getId());

        restauranteRepository.apagar(restauranteDomain.getId());

        verify(restauranteRepository, times(1)).apagar(anyLong());
    }

    @Test
    void deveGerarExcecaoAoApagarRestaurante() {
        // Arrange
        doThrow(RuntimeException.class)
                .when(restauranteRepository).apagar(anyLong());
        // Act
        //Assert
        assertThatThrownBy(() -> restauranteRepository.apagar(anyLong()))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void deveBuscarPorNomeERetornarRestaurante() {
        // Arrange
        RestauranteDomain restauranteDomain = criarRestaurante();
        when(restauranteRepository.buscarPorNome(restauranteDomain.getNome())).thenReturn(restauranteDomain);
        // Act
        RestauranteDomain restaurante = restauranteRepository.buscarPorNome(restauranteDomain.getNome());
        //Assert
        assertThat(restaurante).isEqualTo(restauranteDomain);
        assertThat(restaurante.getNome()).isEqualTo(restauranteDomain.getNome());
    }

    @Test
    void deveBuscarPorNomeERetornarExcecao() {
        // Arrange
        RestauranteDomain restauranteDomain = criarRestaurante();
        when(restauranteRepository.buscarPorNome(anyString())).thenThrow(RuntimeException.class);
        // Act
        //Assert
        assertThatThrownBy(() -> restauranteRepository.buscarPorNome(anyString()))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void deveBuscarPorEnderecoERetornarRestaurante() {
        // Arrange
        RestauranteDomain restauranteDomain = criarRestaurante();
        when(restauranteRepository.buscarPorEndereco(restauranteDomain.getEndereco().getLogradouro())).thenReturn(restauranteDomain);
        // Act
        RestauranteDomain restaurante = restauranteRepository.buscarPorEndereco(restauranteDomain.getEndereco().getLogradouro());
        //Assert
        assertThat(restaurante).isEqualTo(restauranteDomain);
        assertThat(restaurante.getNome()).isEqualTo(restauranteDomain.getNome());
    }

    @Test
    void deveBuscarPorEnderecoERetornarExcecao() {
        // Arrange
        when(restauranteRepository.buscarPorEndereco(anyString())).thenThrow(RuntimeException.class);
        // Act
        //Assert
        assertThatThrownBy(() -> restauranteRepository.buscarPorEndereco(anyString()))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void deveBuscarPorCozinhaERetornarRestaurante() {
        // Arrange
        RestauranteDomain restauranteDomain = criarRestaurante();
        when(restauranteRepository.buscarPorTipoCozinha(restauranteDomain.getTipoCozinha())).thenReturn(restauranteDomain);
        // Act
        RestauranteDomain restaurante = restauranteRepository.buscarPorTipoCozinha(restauranteDomain.getTipoCozinha());
        //Assert
        assertThat(restaurante).isEqualTo(restauranteDomain);
        assertThat(restaurante.getNome()).isEqualTo(restauranteDomain.getNome());
    }

    private RestauranteDomain criarRestaurante() {
        EnderecoDomain endereco = new EnderecoDomain();
        endereco.setId(1L);
        endereco.setLogradouro("Rua Teste");
        endereco.setNumero("12345678");
        endereco.setComplemento("Complemento Teste");
        endereco.setBairro("Bairro Teste");
        endereco.setCidade("Cidade Teste");
        endereco.setEstado("Estado Teste");
        endereco.setCep("12345678");

        RestauranteDomain restauranteDomain = new RestauranteDomain();
        restauranteDomain.setId(1L);
        restauranteDomain.setNome("Restaurante Teste");
        restauranteDomain.setTipoCozinha(TipoCozinha.BRASILEIRA);
        restauranteDomain.setHorarioFuncionamentoAbertura(LocalTime.of(10, 0));
        restauranteDomain.setHorarioFuncionamentoFechamento(LocalTime.of(22, 0));
        restauranteDomain.setCapacidade(100);

        restauranteDomain.setEndereco(endereco);
        return restauranteDomain;
    }
}