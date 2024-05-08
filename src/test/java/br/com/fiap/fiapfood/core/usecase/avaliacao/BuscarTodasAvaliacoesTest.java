package br.com.fiap.fiapfood.core.usecase.avaliacao;

import br.com.fiap.fiapfood.core.entity.AvaliacaoDomain;
import br.com.fiap.fiapfood.core.gateways.AvaliacaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarTodasAvaliacoesTest {

    private AvaliacaoRepository avaliacaoRepository;
    private BuscarTodasAvaliacaos buscarTodasAvaliacoes;

    @BeforeEach
    void setUp() {
        avaliacaoRepository = mock(AvaliacaoRepository.class);
        buscarTodasAvaliacoes = new BuscarTodasAvaliacaos(avaliacaoRepository);
    }

    @Test
    void testBuscarTodasAvaliacoesSucesso() {
        List<AvaliacaoDomain> avaliacoesEsperadas = new ArrayList<>();
        avaliacoesEsperadas.add(new AvaliacaoDomain());
        avaliacoesEsperadas.add(new AvaliacaoDomain());

        when(avaliacaoRepository.buscarTodos()).thenReturn(avaliacoesEsperadas);
        List<AvaliacaoDomain> avaliacoesEncontradas = buscarTodasAvaliacoes.call();

        assertEquals(avaliacoesEsperadas.size(), avaliacoesEncontradas.size());
        assertTrue(avaliacoesEncontradas.containsAll(avaliacoesEsperadas));
    }

    @Test
    void testBuscarTodasAvaliacoesVazias() {
        List<AvaliacaoDomain> avaliacoesEsperadas = new ArrayList<>();

        when(avaliacaoRepository.buscarTodos()).thenReturn(avaliacoesEsperadas);
        List<AvaliacaoDomain> avaliacoesEncontradas = buscarTodasAvaliacoes.call();

        assertTrue(avaliacoesEncontradas.isEmpty());
    }
}
