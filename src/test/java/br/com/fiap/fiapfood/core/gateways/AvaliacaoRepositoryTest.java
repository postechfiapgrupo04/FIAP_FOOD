package br.com.fiap.fiapfood.core.gateways;

import br.com.fiap.fiapfood.core.entity.AvaliacaoDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AvaliacaoRepositoryTest {

    private AvaliacaoRepository avaliacaoRepository;

    @BeforeEach
    void setUp() {
        avaliacaoRepository = new DummyAvaliacaoRepository();
    }

    @Test
    void testSalvar() {
        AvaliacaoDomain avaliacao = new AvaliacaoDomain();
        avaliacao.setNomeRestaurante("Restaurante Teste");

        AvaliacaoDomain avaliacaoSalva = avaliacaoRepository.salvar(avaliacao);

        assertNotNull(avaliacaoSalva);
        assertNotNull(avaliacaoSalva.getId());
        assertEquals(avaliacao.getNomeRestaurante(), avaliacaoSalva.getNomeRestaurante());
    }

    @Test
    void testBuscarPorId() {
        AvaliacaoDomain avaliacao = new AvaliacaoDomain();
        avaliacao.setNomeRestaurante("Restaurante Teste");
        AvaliacaoDomain avaliacaoSalva = avaliacaoRepository.salvar(avaliacao);

        AvaliacaoDomain avaliacaoEncontrada = avaliacaoRepository.buscarPorId(avaliacaoSalva.getId());

        assertNotNull(avaliacaoEncontrada);
        assertEquals(avaliacaoSalva.getId(), avaliacaoEncontrada.getId());
        assertEquals(avaliacao.getNomeRestaurante(), avaliacaoEncontrada.getNomeRestaurante());
    }

    @Test
    void testBuscarTodos() {
        List<AvaliacaoDomain> avaliacoes = avaliacaoRepository.buscarTodos();

        assertNotNull(avaliacoes);
        assertEquals(0, avaliacoes.size());
    }

    @Test
    void testApagar() {
        AvaliacaoDomain avaliacao = new AvaliacaoDomain();
        avaliacao.setNomeRestaurante("Restaurante Teste");
        AvaliacaoDomain avaliacaoSalva = avaliacaoRepository.salvar(avaliacao);

        avaliacaoRepository.apagar(avaliacaoSalva.getId());
        AvaliacaoDomain avaliacaoEncontrada = avaliacaoRepository.buscarPorId(avaliacaoSalva.getId());

        assertNull(avaliacaoEncontrada);
    }

    private static class DummyAvaliacaoRepository implements AvaliacaoRepository {
        private final List<AvaliacaoDomain> avaliacoes = new ArrayList<>();
        private long idCounter = 1;

        @Override
        public AvaliacaoDomain salvar(AvaliacaoDomain avaliacao) {
            avaliacao.setId(idCounter++);
            avaliacoes.add(avaliacao);
            return avaliacao;
        }

        @Override
        public AvaliacaoDomain buscarPorId(Long id) {
            for (AvaliacaoDomain avaliacao : avaliacoes) {
                if (avaliacao.getId().equals(id)) {
                    return avaliacao;
                }
            }
            return null;
        }

        @Override
        public List<AvaliacaoDomain> buscarTodos() {
            return avaliacoes;
        }

        @Override
        public void apagar(Long id) {
            avaliacoes.removeIf(avaliacao -> avaliacao.getId().equals(id));
        }

        @Override
        public AvaliacaoDomain buscarPorNomeRestaurante(String nomeRestaurante) {
            for (AvaliacaoDomain avaliacao : avaliacoes) {
                if (avaliacao.getNomeRestaurante().equals(nomeRestaurante)) {
                    return avaliacao;
                }
            }
            return null;
        }
    }
}
