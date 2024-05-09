package br.com.fiap.fiapfood.entrypoint.facade.implementation;

import br.com.fiap.fiapfood.core.entity.AvaliacaoDomain;
import br.com.fiap.fiapfood.core.usecase.avaliacao.*;
import br.com.fiap.fiapfood.entrypoint.api.dto.AvaliacaoDTO;
import br.com.fiap.fiapfood.entrypoint.api.mapper.AvaliacaoMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AvaliacaoFacadeImpTest {

    private AvaliacaoFacadeImp avaliacaoFacade;

    private SalvarAvaliacao salvarAvaliacao;
    private BuscarAvaliacaoPorID buscarAvaliacaoPorID;
    private BuscarTodasAvaliacaos buscarTodasAvaliacaos;
    private BuscarAvaliacaoPorNomeRestaurante buscarAvaliacaoPorNomeRestaurante;
    private ApagarAvaliacao apagarAvaliacao;
    private AvaliacaoMapper avaliacaoMapper;

    @BeforeEach
    void setUp() {
        salvarAvaliacao = mock(SalvarAvaliacao.class);
        buscarAvaliacaoPorID = mock(BuscarAvaliacaoPorID.class);
        buscarTodasAvaliacaos = mock(BuscarTodasAvaliacaos.class);
        buscarAvaliacaoPorNomeRestaurante = mock(BuscarAvaliacaoPorNomeRestaurante.class);
        apagarAvaliacao = mock(ApagarAvaliacao.class);
        avaliacaoMapper = mock(AvaliacaoMapper.class);

        avaliacaoFacade = new AvaliacaoFacadeImp(
                salvarAvaliacao,
                buscarAvaliacaoPorID,
                buscarTodasAvaliacaos,
                buscarAvaliacaoPorNomeRestaurante,
                apagarAvaliacao,
                avaliacaoMapper
        );
    }



    @Test
    void buscarTodasAvaliacoes() {
        // Given
        when(buscarTodasAvaliacaos.call()).thenReturn(Collections.emptyList());

        // When
        List<AvaliacaoDTO> result = avaliacaoFacade.buscarTodos();

        // Then
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void apagar() {
        // Given
        Long id = 1L;

        // When / Then
        assertDoesNotThrow(() -> avaliacaoFacade.apagar(id));
    }


}
