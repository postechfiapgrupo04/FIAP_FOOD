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
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class SalvarRestauranteTest {

    AutoCloseable openMocks;

    @Mock
    private SalvarRestaurante salvarRestaurante;

    @BeforeEach
    void setup() {
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void deveSalvarERetornarRestaurante() {
        // Arrange
        RestauranteDomain restauranteDomain = criarRestaurante();
        when(salvarRestaurante.call(restauranteDomain)).thenReturn(restauranteDomain);

        RestauranteDomain restaurante = salvarRestaurante.call(restauranteDomain);
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