package br.com.fiap.fiapfood.core.usecase.avaliacao;

import br.com.fiap.fiapfood.core.gateways.AvaliacaoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;

class ApagarAvaliacaoTest {

    @Test
    void testApagarAvaliacao() {
        // Arrange
        AvaliacaoRepository mockRepository = Mockito.mock(AvaliacaoRepository.class);
        ApagarAvaliacao apagarAvaliacao = new ApagarAvaliacao(mockRepository);
        Long avaliacaoId = 1L;

        // Act
        apagarAvaliacao.call(avaliacaoId);

        // Assert
        Mockito.verify(mockRepository, times(1)).apagar(avaliacaoId);
    }
}
