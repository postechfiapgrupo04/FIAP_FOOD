package br.com.fiap.fiapfood.dataprovider.persistence.implementation;

import br.com.fiap.fiapfood.core.entity.AvaliacaoDomain;
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

    /*TESTE*/

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
    void testSalvar() {
        AvaliacaoDomain avaliacaoDomain = new AvaliacaoDomain(1L, "Descrição", "5", "Restaurante A");
        Avaliacao avaliacaoEntity = new Avaliacao(1L, "Descrição", "5", "Restaurante A");

        when(avaliacaoMapper.toAvaliacaoModelFromDomain(avaliacaoDomain)).thenReturn(avaliacaoEntity);
        when(avaliacaoMapper.toAvaliacaoDomainFromModel(avaliacaoEntity)).thenReturn(avaliacaoDomain);
        when(avaliacaoJPARepository.save(avaliacaoEntity)).thenReturn(avaliacaoEntity);

        AvaliacaoDomain result = avaliacaoRepository.salvar(avaliacaoDomain);

        assertEquals(avaliacaoDomain, result);
        verify(avaliacaoJPARepository, times(1)).save(avaliacaoEntity);
    }

    @Test
    void testBuscarPorId_Existente() {
        Long id = 1L;
        Avaliacao avaliacaoEntity = new Avaliacao(id, "Descrição", "5", "Restaurante A");
        AvaliacaoDomain avaliacaoDomain = new AvaliacaoDomain(id, "Descrição", "5", "Restaurante A");

        when(avaliacaoJPARepository.findById(id)).thenReturn(Optional.of(avaliacaoEntity));
        when(avaliacaoMapper.toAvaliacaoDomainFromModel(avaliacaoEntity)).thenReturn(avaliacaoDomain);

        AvaliacaoDomain result = avaliacaoRepository.buscarPorId(id);

        assertEquals(avaliacaoDomain, result);
    }

    @Test
    void testBuscarPorId_NaoExistente() {
        Long id = 1L;

        when(avaliacaoJPARepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> avaliacaoRepository.buscarPorId(id));
    }

    @Test
    void testBuscarTodos() {
        List<Avaliacao> avaliacoes = new ArrayList<>();
        avaliacoes.add(new Avaliacao(1L, "Descrição 1", "5", "Restaurante A"));
        avaliacoes.add(new Avaliacao(2L, "Descrição 2", "4", "Restaurante B"));

        List<AvaliacaoDomain> avaliacoesDomain = new ArrayList<>();
        avaliacoesDomain.add(new AvaliacaoDomain(1L, "Descrição 1", "5", "Restaurante A"));
        avaliacoesDomain.add(new AvaliacaoDomain(2L, "Descrição 2", "4", "Restaurante B"));

        when(avaliacaoJPARepository.findAll()).thenReturn(avaliacoes);
        when(avaliacaoMapper.toAvaliacaoDomainFromModel(any())).thenAnswer(invocation -> {
            Avaliacao avaliacao = invocation.getArgument(0);
            return new AvaliacaoDomain(avaliacao.getId(), avaliacao.getDescricao(), avaliacao.getEstrelas(), avaliacao.getNomeRestaurante());
        });

        List<AvaliacaoDomain> result = avaliacaoRepository.buscarTodos();

        assertEquals(avaliacoesDomain, result);
    }

    @Test
    void testApagar_Existente() {
        Long id = 1L;
        Avaliacao avaliacaoEntity = new Avaliacao(id, "Descrição", "5", "Restaurante A");

        when(avaliacaoJPARepository.findById(id)).thenReturn(Optional.of(avaliacaoEntity));

        avaliacaoRepository.apagar(id);

        verify(avaliacaoJPARepository, times(1)).delete(avaliacaoEntity);
    }

    @Test
    void testApagar_NaoExistente() {
        Long id = 1L;

        when(avaliacaoJPARepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> avaliacaoRepository.apagar(id));
    }

    @Test
    void testBuscarPorNomeRestaurante_Existente() {
        String nomeRestaurante = "Restaurante A";
        Avaliacao avaliacaoEntity = new Avaliacao(1L, "Descrição", "5", nomeRestaurante);
        AvaliacaoDomain avaliacaoDomain = new AvaliacaoDomain(1L, "Descrição", "5", nomeRestaurante);

        when(avaliacaoJPARepository.findByNomeRestaurante(nomeRestaurante)).thenReturn(Optional.of(avaliacaoEntity));
        when(avaliacaoMapper.toAvaliacaoDomainFromModel(avaliacaoEntity)).thenReturn(avaliacaoDomain);

        AvaliacaoDomain result = avaliacaoRepository.buscarPorNomeRestaurante(nomeRestaurante);

        assertEquals(avaliacaoDomain, result);
    }

    @Test
    void testBuscarPorNomeRestaurante_NaoExistente() {
        String nomeRestaurante = "Restaurante A";

        when(avaliacaoJPARepository.findByNomeRestaurante(nomeRestaurante)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> avaliacaoRepository.buscarPorNomeRestaurante(nomeRestaurante));
    }
}
