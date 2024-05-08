package br.com.fiap.fiapfood.core.usecase.avaliacao;

import br.com.fiap.fiapfood.core.entity.AvaliacaoDomain;
import br.com.fiap.fiapfood.core.gateways.AvaliacaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarAvaliacaoPorCPFTest {

    private AvaliacaoRepository avaliacaoRepository;
    private BuscarAvaliacaoPorCPF buscarAvaliacaoPorCPF;

    @BeforeEach
    void setUp() {
        avaliacaoRepository = mock(AvaliacaoRepository.class);
        buscarAvaliacaoPorCPF = new BuscarAvaliacaoPorCPF(avaliacaoRepository);
    }

    @Test
    void testBuscarAvaliacaoPorCPFSucesso() {
        String cpf = "12345678900";
        AvaliacaoDomain avaliacaoEsperada = new AvaliacaoDomain();

        when(avaliacaoRepository.buscarPorCPF(cpf)).thenReturn(avaliacaoEsperada);
        AvaliacaoDomain avaliacaoEncontrada = buscarAvaliacaoPorCPF.call(cpf);

        assertEquals(avaliacaoEsperada, avaliacaoEncontrada);
    }

    @Test
    void testBuscarAvaliacaoPorCPFNaoEncontrado() {
        String cpf = "12345678900";

        when(avaliacaoRepository.buscarPorCPF(cpf)).thenReturn(null);
        AvaliacaoDomain avaliacaoEncontrada = buscarAvaliacaoPorCPF.call(cpf);

        assertNull(avaliacaoEncontrada);
    }

    @Test
    void testBuscarAvaliacaoPorCPFFuncionamento() {
        // Dado
        String cpf = "12345678900";
        AvaliacaoDomain avaliacaoEsperada = new AvaliacaoDomain();

        // Quando
        when(avaliacaoRepository.buscarPorCPF(cpf)).thenReturn(avaliacaoEsperada);
        AvaliacaoDomain avaliacaoEncontrada = buscarAvaliacaoPorCPF.call(cpf);

        // Então
        assertNotNull(avaliacaoEncontrada);
        assertEquals(avaliacaoEsperada, avaliacaoEncontrada);
        verify(avaliacaoRepository, times(1)).buscarPorCPF(cpf); // Verifica se o método foi chamado exatamente uma vez
    }

}
