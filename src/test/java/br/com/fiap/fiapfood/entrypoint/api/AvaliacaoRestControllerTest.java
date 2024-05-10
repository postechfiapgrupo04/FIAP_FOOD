package br.com.fiap.fiapfood.entrypoint.api;

import br.com.fiap.fiapfood.entrypoint.api.AvaliacaoRestController;
import br.com.fiap.fiapfood.entrypoint.facade.AvaliacaoFacade;
import br.com.fiap.fiapfood.entrypoint.api.dto.AvaliacaoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AvaliacaoRestControllerTest {

    @Mock
    private AvaliacaoFacade avaliacaoFacade;

    @InjectMocks
    private AvaliacaoRestController avaliacaoRestController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSalvarAvaliacao() {
        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO();
        avaliacaoDTO.setId(1L);
        when(avaliacaoFacade.salvar(avaliacaoDTO)).thenReturn(avaliacaoDTO);

        AvaliacaoDTO savedAvaliacaoDTO = avaliacaoRestController.salvar(avaliacaoDTO);

        assertEquals(avaliacaoDTO.getId(), savedAvaliacaoDTO.getId());
        verify(avaliacaoFacade, times(1)).salvar(avaliacaoDTO);
    }

    @Test
    void testBuscarPorId() {
        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO();
        avaliacaoDTO.setId(1L);
        when(avaliacaoFacade.buscarPorId(1L)).thenReturn(avaliacaoDTO);

        AvaliacaoDTO foundAvaliacaoDTO = avaliacaoRestController.buscarPorId(1L);

        assertEquals(avaliacaoDTO.getId(), foundAvaliacaoDTO.getId());
        verify(avaliacaoFacade, times(1)).buscarPorId(1L);
    }

    @Test
    void testBuscarTodos() {
        List<AvaliacaoDTO> avaliacoes = new ArrayList<>();
        when(avaliacaoFacade.buscarTodos()).thenReturn(avaliacoes);

        List<AvaliacaoDTO> foundAvaliacoes = avaliacaoRestController.buscarTodos();

        assertEquals(avaliacoes.size(), foundAvaliacoes.size());
        verify(avaliacaoFacade, times(1)).buscarTodos();
    }

    @Test
    void testBuscarPorNomeRestaurante() {
        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO();
        avaliacaoDTO.setId(1L);
        String nomeRestaurante = "Nome do Restaurante";
        when(avaliacaoFacade.buscarPorNomeRestaurante(nomeRestaurante)).thenReturn(avaliacaoDTO);

        AvaliacaoDTO foundAvaliacaoDTO = avaliacaoRestController.buscarPorNomeRestaurante(nomeRestaurante);

        assertEquals(avaliacaoDTO.getId(), foundAvaliacaoDTO.getId());
        verify(avaliacaoFacade, times(1)).buscarPorNomeRestaurante(nomeRestaurante);
    }

    @Test
    void testApagarAvaliacao() {
        Long id = 1L;

        avaliacaoRestController.apagar(id);

        verify(avaliacaoFacade, times(1)).apagar(id);
    }
}
