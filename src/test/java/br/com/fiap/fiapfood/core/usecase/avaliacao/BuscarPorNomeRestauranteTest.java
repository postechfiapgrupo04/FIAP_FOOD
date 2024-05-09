package br.com.fiap.fiapfood.core.usecase.avaliacao;

import br.com.fiap.fiapfood.core.entity.AvaliacaoDomain;
import br.com.fiap.fiapfood.core.gateways.AvaliacaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarPorNomeRestauranteTest {

    private AvaliacaoRepository avaliacaoRepository;
    private BuscarAvaliacaoPorNomeRestaurante buscarPorNomeRestaurante;

    @BeforeEach
    void setUp() {
        avaliacaoRepository = mock(AvaliacaoRepository.class);
        buscarPorNomeRestaurante = new BuscarAvaliacaoPorNomeRestaurante(avaliacaoRepository);
    }

    @Test
    void testBuscarPorNomeRestauranteSucesso() {
        // Dado
        String nomeRestaurante = "Restaurante Teste";
        AvaliacaoDomain avaliacaoEsperada = new AvaliacaoDomain();

        // Quando
        when(avaliacaoRepository.buscarPorNomeRestaurante(nomeRestaurante)).thenReturn(avaliacaoEsperada);
        AvaliacaoDomain avaliacaoEncontrada = buscarPorNomeRestaurante.call(nomeRestaurante);

        // Então
        assertEquals(avaliacaoEsperada, avaliacaoEncontrada);
    }

    @Test
    void testBuscarPorNomeRestauranteNaoEncontrado() {
        // Dado
        String nomeRestaurante = "Restaurante Teste";

        // Quando
        when(avaliacaoRepository.buscarPorNomeRestaurante(nomeRestaurante)).thenReturn(null);
        AvaliacaoDomain avaliacaoEncontrada = buscarPorNomeRestaurante.call(nomeRestaurante);

        // Então
        assertNull(avaliacaoEncontrada);
    }
}
