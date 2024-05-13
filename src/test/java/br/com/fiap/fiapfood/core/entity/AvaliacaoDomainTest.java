package br.com.fiap.fiapfood.core.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvaliacaoDomainTest {

    @Test
    void testConstrutorComArgumentos() {
        Long id = 1L;
        String descricao = "Ótimo restaurante";
        String estrelas = "5";
        String nomeRestaurante = "Restaurante Teste";

        AvaliacaoDomain avaliacao = new AvaliacaoDomain(id, descricao, estrelas, nomeRestaurante);

        assertEquals(id, avaliacao.getId());
        assertEquals(descricao, avaliacao.getDescricao());
        assertEquals(estrelas, avaliacao.getEstrelas());
        assertEquals(nomeRestaurante, avaliacao.getNomeRestaurante());
    }

    @Test
    void testConstrutorSemArgumentos() {
        AvaliacaoDomain avaliacao = new AvaliacaoDomain();

        assertNull(avaliacao.getId());
        assertNull(avaliacao.getDescricao());
        assertNull(avaliacao.getEstrelas());
        assertNull(avaliacao.getNomeRestaurante());
    }

}
