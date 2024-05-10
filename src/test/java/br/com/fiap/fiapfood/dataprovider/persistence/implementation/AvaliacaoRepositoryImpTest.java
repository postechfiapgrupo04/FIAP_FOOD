import br.com.fiap.fiapfood.core.entity.AvaliacaoDomain;
import br.com.fiap.fiapfood.dataprovider.persistence.implementation.AvaliacaoRepositoryImp;
import br.com.fiap.fiapfood.dataprovider.persistence.model.Avaliacao;
import br.com.fiap.fiapfood.dataprovider.persistence.repository.AvaliacaoJPARepository;
import br.com.fiap.fiapfood.entrypoint.api.mapper.AvaliacaoMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AvaliacaoRepositoryImpTest {

    @Mock
    private AvaliacaoJPARepository avaliacaoJPARepository;

    @Mock
    private AvaliacaoMapper avaliacaoMapper;

    @InjectMocks
    private AvaliacaoRepositoryImp avaliacaoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testBuscarPorId_NaoExistente() {
        Long id = 1L;

        when(avaliacaoJPARepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> avaliacaoRepository.buscarPorId(id));
    }



    @Test
    void testApagar_NaoExistente() {
        Long id = 1L;

        when(avaliacaoJPARepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> avaliacaoRepository.apagar(id));
    }


    @Test
    void testBuscarPorNomeRestaurante_NaoExistente() {
        String nomeRestaurante = "Restaurante A";

        when(avaliacaoJPARepository.findByNomeRestaurante(nomeRestaurante)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> avaliacaoRepository.buscarPorNomeRestaurante(nomeRestaurante));
    }
}
