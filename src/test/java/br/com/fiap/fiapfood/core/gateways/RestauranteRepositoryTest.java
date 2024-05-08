package br.com.fiap.fiapfood.core.gateways;

import br.com.fiap.fiapfood.core.entity.EnderecoDomain;
import br.com.fiap.fiapfood.core.entity.RestauranteDomain;
import br.com.fiap.fiapfood.core.enums.TipoCozinha;
import br.com.fiap.fiapfood.core.usecase.restaurante.BuscarRestaurantePorCozinha;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

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

    }

    @Test
    void buscarPorId() {
    }

    @Test
    void apagar() {
    }

    @Test
    void buscarPorNome() {
    }

    @Test
    void buscarPorEndereco() {
    }

    @Test
    void buscarPorTipoCozinha() {
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

        endereco.setRestaurante(restauranteDomain);
        restauranteDomain.setEndereco(endereco);
        return restauranteDomain;
    }
}