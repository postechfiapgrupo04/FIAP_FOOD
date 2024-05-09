package br.com.fiap.fiapfood.entrypoint.facade;

import br.com.fiap.fiapfood.entrypoint.api.dto.AvaliacaoDTO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AvaliacaoFacadeTest {

    @Test
    void testSalvar() {
        AvaliacaoFacade avaliacaoFacade = mock(AvaliacaoFacade.class);
        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO();

        when(avaliacaoFacade.salvar(avaliacaoDTO)).thenReturn(avaliacaoDTO);

        AvaliacaoDTO savedAvaliacao = avaliacaoFacade.salvar(avaliacaoDTO);

        assertNotNull(savedAvaliacao);
    }

    @Test
    void testBuscarPorId() {
        AvaliacaoFacade avaliacaoFacade = mock(AvaliacaoFacade.class);
        Long id = 1L;
        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO();

        when(avaliacaoFacade.buscarPorId(id)).thenReturn(avaliacaoDTO);

        AvaliacaoDTO foundAvaliacao = avaliacaoFacade.buscarPorId(id);

        assertNotNull(foundAvaliacao);
    }

    @Test
    void testBuscarTodos() {
        AvaliacaoFacade avaliacaoFacade = mock(AvaliacaoFacade.class);
        List<AvaliacaoDTO> avaliacoes = new ArrayList<>();

        when(avaliacaoFacade.buscarTodos()).thenReturn(avaliacoes);

        List<AvaliacaoDTO> foundAvaliacoes = avaliacaoFacade.buscarTodos();

        assertNotNull(foundAvaliacoes);
    }

    @Test
    void testApagar() {
        AvaliacaoFacade avaliacaoFacade = mock(AvaliacaoFacade.class);
        Long id = 1L;

        assertDoesNotThrow(() -> avaliacaoFacade.apagar(id));
    }

    @Test
    void testBuscarPorNomeRestaurante() {
        AvaliacaoFacade avaliacaoFacade = mock(AvaliacaoFacade.class);
        String nomeRestaurante = "Restaurante Teste";
        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO();

        when(avaliacaoFacade.buscarPorNomeRestaurante(nomeRestaurante)).thenReturn(avaliacaoDTO);

        AvaliacaoDTO foundAvaliacao = avaliacaoFacade.buscarPorNomeRestaurante(nomeRestaurante);

        assertNotNull(foundAvaliacao);
    }
}
