package br.com.fiap.fiapfood.dataprovider.persistence.implementation;

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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

class RestauranteRepositoryImplTest {

    AutoCloseable openMocks;

    @Mock
    private RestauranteRepositoryImpl restauranteRepositoryImp;

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
        when(restauranteRepositoryImp.salvar(restauranteDomain)).thenReturn(restauranteDomain);

        RestauranteDomain restaurante = restauranteRepositoryImp.salvar(restauranteDomain);
        //Assert
        assertThat(restaurante).isEqualTo(restauranteDomain);
        assertThat(restaurante.getNome()).isEqualTo(restauranteDomain.getNome());
    }

    @Test
    void deveBuscarPorIDERetornarRestaurante() {
        // Arrange
        RestauranteDomain restauranteDomain = criarRestaurante();
        when(restauranteRepositoryImp.buscarPorId(restauranteDomain.getId())).thenReturn(restauranteDomain);
        // Act
        RestauranteDomain restaurante = restauranteRepositoryImp.buscarPorId(restauranteDomain.getId());
        //Assert
        assertThat(restaurante).isEqualTo(restauranteDomain);
        assertThat(restaurante.getNome()).isEqualTo(restauranteDomain.getNome());
    }

    @Test
    void deveBuscarPorIDERetornarExcecao() {
        // Arrange
        when(restauranteRepositoryImp.buscarPorId(anyLong())).thenThrow(RuntimeException.class);
        // Act
        //Assert
        assertThatThrownBy(() -> restauranteRepositoryImp.buscarPorId(anyLong()))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void deveApagarRestaurante() {
        // Arrange
        RestauranteDomain restauranteDomain = criarRestaurante();
        doNothing()
                .when(restauranteRepositoryImp).apagar(restauranteDomain.getId());

        restauranteRepositoryImp.apagar(restauranteDomain.getId());

        verify(restauranteRepositoryImp, times(1)).apagar(anyLong());
    }

    @Test
    void deveGerarExcecaoAoApagarRestaurante() {
        // Arrange
        doThrow(RuntimeException.class)
                .when(restauranteRepositoryImp).apagar(anyLong());
        // Act
        //Assert
        assertThatThrownBy(() -> restauranteRepositoryImp.apagar(anyLong()))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void deveBuscarPorNomeERetornarRestaurante() {
        // Arrange
        RestauranteDomain restauranteDomain = criarRestaurante();
        when(restauranteRepositoryImp.buscarPorNome(restauranteDomain.getNome())).thenReturn(restauranteDomain);
        // Act
        RestauranteDomain restaurante = restauranteRepositoryImp.buscarPorNome(restauranteDomain.getNome());
        //Assert
        assertThat(restaurante).isEqualTo(restauranteDomain);
        assertThat(restaurante.getNome()).isEqualTo(restauranteDomain.getNome());
    }

    @Test
    void deveBuscarPorNomeERetornarExcecao() {
        // Arrange
        RestauranteDomain restauranteDomain = criarRestaurante();
        when(restauranteRepositoryImp.buscarPorNome(anyString())).thenThrow(RuntimeException.class);
        // Act
        //Assert
        assertThatThrownBy(() -> restauranteRepositoryImp.buscarPorNome(anyString()))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void deveBuscarPorEnderecoERetornarRestaurante() {
        // Arrange
        RestauranteDomain restauranteDomain = criarRestaurante();
        when(restauranteRepositoryImp.buscarPorEndereco(restauranteDomain.getEndereco().getLogradouro())).thenReturn(restauranteDomain);
        // Act
        RestauranteDomain restaurante = restauranteRepositoryImp.buscarPorEndereco(restauranteDomain.getEndereco().getLogradouro());
        //Assert
        assertThat(restaurante).isEqualTo(restauranteDomain);
        assertThat(restaurante.getNome()).isEqualTo(restauranteDomain.getNome());
    }

    @Test
    void deveBuscarPorEnderecoERetornarExcecao() {
        // Arrange
        when(restauranteRepositoryImp.buscarPorEndereco(anyString())).thenThrow(RuntimeException.class);
        // Act
        //Assert
        assertThatThrownBy(() -> restauranteRepositoryImp.buscarPorEndereco(anyString()))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void deveBuscarPorCozinhaERetornarRestaurante() {
        // Arrange
        RestauranteDomain restauranteDomain = criarRestaurante();
        when(restauranteRepositoryImp.buscarPorTipoCozinha(restauranteDomain.getTipoCozinha())).thenReturn(restauranteDomain);
        // Act
        RestauranteDomain restaurante = restauranteRepositoryImp.buscarPorTipoCozinha(restauranteDomain.getTipoCozinha());
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