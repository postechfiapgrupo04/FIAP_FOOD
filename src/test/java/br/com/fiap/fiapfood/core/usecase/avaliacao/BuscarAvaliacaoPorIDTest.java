package br.com.fiap.fiapfood.core.usecase.avaliacao;

import br.com.fiap.fiapfood.core.entity.AvaliacaoDomain;
import br.com.fiap.fiapfood.core.gateways.AvaliacaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarAvaliacaoPorIDTest {

    private AvaliacaoRepository avaliacaoRepository;
    private BuscarAvaliacaoPorID buscarAvaliacaoPorID;

    @BeforeEach
    void setUp() {
        avaliacaoRepository = mock(AvaliacaoRepository.class);
        buscarAvaliacaoPorID = new BuscarAvaliacaoPorID(avaliacaoRepository);
    }

    @Test
    void testBuscarAvaliacaoPorIDSucesso() {
        // Dado
        Long id = 1L;
        AvaliacaoDomain avaliacaoEsperada = new AvaliacaoDomain();

        // Quando
        when(avaliacaoRepository.buscarPorId(id)).thenReturn(avaliacaoEsperada);
        AvaliacaoDomain avaliacaoEncontrada = buscarAvaliacaoPorID.call(id);

        // Então
        assertEquals(avaliacaoEsperada, avaliacaoEncontrada);
    }

    @Test
    void testBuscarAvaliacaoPorIDNaoEncontrado() {
        // Dado
        Long id = 1L;

        // Quando
        when(avaliacaoRepository.buscarPorId(id)).thenReturn(null);
        AvaliacaoDomain avaliacaoEncontrada = buscarAvaliacaoPorID.call(id);

        // Então
        assertNull(avaliacaoEncontrada);
    }
}
