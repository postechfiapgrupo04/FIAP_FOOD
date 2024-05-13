package br.com.fiap.fiapfood.dataprovider.persistence.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AvaliacaoTest {

    @Test
    void testAllArgsConstructor() {
        Long id = 1L;
        String descricao = "Descrição da avaliação";
        String estrelas = "5";
        String nomeRestaurante = "Nome do Restaurante";

        Avaliacao avaliacao = new Avaliacao(id, nomeRestaurante, estrelas, descricao);

        assertEquals(id, avaliacao.getId());
        assertEquals(descricao, avaliacao.getDescricao());
        assertEquals(estrelas, avaliacao.getEstrelas());
        assertEquals(nomeRestaurante, avaliacao.getNomeRestaurante());
    }

    @Test
    void testNoArgsConstructor() {
        Avaliacao avaliacao = new Avaliacao();

        assertNull(avaliacao.getId());
        assertNull(avaliacao.getDescricao());
        assertNull(avaliacao.getEstrelas());
        assertNull(avaliacao.getNomeRestaurante());
    }

    @Test
    void testEquals() {
        Avaliacao avaliacao1 = new Avaliacao(1L, "Descrição", "5", "Restaurante A");
        Avaliacao avaliacao2 = new Avaliacao(1L, "Descrição", "5", "Restaurante A");
        Avaliacao avaliacao3 = new Avaliacao(2L, "Outra Descrição", "4", "Restaurante B");

        assertTrue(avaliacao1.equals(avaliacao2));
        assertFalse(avaliacao1.equals(avaliacao3));
    }

    @Test
    void testHashCode() {
        Avaliacao avaliacao1 = new Avaliacao(1L, "Descrição", "5", "Restaurante A");
        Avaliacao avaliacao2 = new Avaliacao(1L, "Descrição", "5", "Restaurante A");
        Avaliacao avaliacao3 = new Avaliacao(2L, "Outra Descrição", "4", "Restaurante B");

        assertEquals(avaliacao1.hashCode(), avaliacao2.hashCode());
        assertNotEquals(avaliacao1.hashCode(), avaliacao3.hashCode());
    }
}
