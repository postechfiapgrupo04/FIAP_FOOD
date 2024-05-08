package br.com.fiap.fiapfood.core.usecase.restaurante;

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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class BuscarRestaurantePorEnderecoTest {

    AutoCloseable openMocks;

    @Mock
    private BuscarRestaurantePorEndereco buscarRestaurantePorEndereco;

    @BeforeEach
    void setup() {
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void deveBuscarPorEnderecoERetornarRestaurante() {
        // Arrange
        RestauranteDomain restauranteDomain = criarRestaurante();
        when(buscarRestaurantePorEndereco.call(restauranteDomain.getEndereco().getLogradouro())).thenReturn(restauranteDomain);
        // Act
        RestauranteDomain restaurante = buscarRestaurantePorEndereco.call(restauranteDomain.getEndereco().getLogradouro());
        //Assert
        assertThat(restaurante).isEqualTo(restauranteDomain);
        assertThat(restaurante.getNome()).isEqualTo(restauranteDomain.getNome());
    }

    @Test
    void deveBuscarPorEnderecoERetornarExcecao() {
        // Arrange
        when(buscarRestaurantePorEndereco.call(anyString())).thenThrow(RuntimeException.class);
        // Act
        //Assert
        assertThatThrownBy(() -> buscarRestaurantePorEndereco.call(anyString()))
                .isInstanceOf(RuntimeException.class);
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