package br.com.fiap.fiapfood.core.usecase.avaliacao;

import br.com.fiap.fiapfood.core.entity.AvaliacaoDomain;
import br.com.fiap.fiapfood.core.gateways.AvaliacaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SalvarAvaliacaoTest {

    private AvaliacaoRepository avaliacaoRepository;
    private SalvarAvaliacao salvarAvaliacao;

    @BeforeEach
    void setUp() {
        avaliacaoRepository = mock(AvaliacaoRepository.class);
        salvarAvaliacao = new SalvarAvaliacao(avaliacaoRepository);
    }

    @Test
    void testSalvarAvaliacaoSucesso() {
        // Dado
        AvaliacaoDomain avaliacao = new AvaliacaoDomain();

        // Quando
        when(avaliacaoRepository.salvar(avaliacao)).thenReturn(avaliacao);
        AvaliacaoDomain avaliacaoSalva = salvarAvaliacao.call(avaliacao);

        // Então
        assertNotNull(avaliacaoSalva);
        assertEquals(avaliacao, avaliacaoSalva);
    }
}
