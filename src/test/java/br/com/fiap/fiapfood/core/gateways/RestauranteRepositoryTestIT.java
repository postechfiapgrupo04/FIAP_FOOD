package br.com.fiap.fiapfood.core.gateways;

import br.com.fiap.fiapfood.core.entity.EnderecoDomain;
import br.com.fiap.fiapfood.core.entity.RestauranteDomain;
import br.com.fiap.fiapfood.core.enums.TipoCozinha;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
class RestauranteRepositoryTestIT {

    @Autowired
    private RestauranteRepository restauranteRepository;

    void apagar(Long id) {
        restauranteRepository.apagar(id);
    }

    @Test
    void deveSalvar() {
        // Arrange
        RestauranteDomain restauranteDomain = criarRestaurante();
        RestauranteDomain restaurante = restauranteRepository.salvar(restauranteDomain);
        //Assert
        assertThat(restaurante).isEqualTo(restauranteDomain);
        assertThat(restaurante.getNome()).isEqualTo(restauranteDomain.getNome());
        apagar(restaurante.getId());
    }

    @Test
    void deveBuscarPorIDERetornarRestaurante() {
        // Arrange
        RestauranteDomain restauranteDomain = criarRestaurante();
        restauranteDomain = restauranteRepository.salvar(restauranteDomain);
        // Act
        RestauranteDomain restaurante = restauranteRepository.buscarPorId(restauranteDomain.getId());
        //Assert
        assertThat(restaurante).isEqualTo(restauranteDomain);
        assertThat(restaurante.getNome()).isEqualTo(restauranteDomain.getNome());
        apagar(restaurante.getId());
    }

    @Test
    void deveBuscarPorIDERetornarExcecao() {
        // Arrange
        // Act
        //Assert
        assertThatThrownBy(() -> restauranteRepository.buscarPorId(anyLong()))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void deveGerarExcecaoAoApagarRestaurante() {
        // Arrange
        // Act
        //Assert
        assertThatThrownBy(() -> restauranteRepository.apagar(anyLong()))
                .isInstanceOf(RuntimeException.class);
    }


    @Test
    void deveBuscarPorEnderecoERetornarRestaurante() {
        // Arrange
        RestauranteDomain restauranteDomain = criarRestaurante();
        restauranteDomain = restauranteRepository.salvar(restauranteDomain);
        // Act
        RestauranteDomain restaurante = restauranteRepository.buscarPorEndereco(restauranteDomain.getEndereco().getLogradouro());
        //Assert
        assertThat(restaurante).isEqualTo(restauranteDomain);
        assertThat(restaurante.getNome()).isEqualTo(restauranteDomain.getNome());
        apagar(restauranteDomain.getId());
    }

    @Test
    void deveBuscarPorEnderecoERetornarExcecao() {
        // Arrange
        // Act
        //Assert
        assertThatThrownBy(() -> restauranteRepository.buscarPorEndereco(anyString()))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void deveBuscarPorCozinhaERetornarRestaurante() {
        // Arrange
        RestauranteDomain restauranteDomain = criarRestaurante();
        restauranteDomain = restauranteRepository.salvar(restauranteDomain);
        // Act
        RestauranteDomain restaurante = restauranteRepository.buscarPorTipoCozinha(restauranteDomain.getTipoCozinha());
        //Assert
        assertThat(restaurante).isEqualTo(restauranteDomain);
        assertThat(restaurante.getNome()).isEqualTo(restauranteDomain.getNome());
        apagar(restauranteDomain.getId());
    }

    @Test
    void deveBuscarPorCozinhaERetornarExcecao() {
        // Arrange
        // Act
        //Assert
        assertThatThrownBy(() -> restauranteRepository.buscarPorTipoCozinha(any(TipoCozinha.class)))
                .isInstanceOf(RuntimeException.class);
    }

    private RestauranteDomain criarRestaurante() {
        EnderecoDomain endereco = new EnderecoDomain();
        endereco.setLogradouro("Rua Teste");
        endereco.setNumero("12345678");
        endereco.setComplemento("Complemento Teste");
        endereco.setBairro("Bairro Teste");
        endereco.setCidade("Cidade Teste");
        endereco.setEstado("Estado Teste");
        endereco.setCep("12345678");

        RestauranteDomain restauranteDomain = new RestauranteDomain();
        restauranteDomain.setNome("Restaurante Teste");
        restauranteDomain.setTipoCozinha(TipoCozinha.BRASILEIRA);
        restauranteDomain.setHorarioFuncionamentoAbertura(LocalTime.of(10, 0));
        restauranteDomain.setHorarioFuncionamentoFechamento(LocalTime.of(22, 0));
        restauranteDomain.setCapacidade(100);

        restauranteDomain.setEndereco(endereco);
        return restauranteDomain;
    }
}