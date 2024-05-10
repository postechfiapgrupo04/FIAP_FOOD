package br.com.fiap.fiapfood.entrypoint.dto;

import br.com.fiap.fiapfood.entrypoint.api.dto.AvaliacaoDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AvaliacaoDTOTest {

    @Test
    void testAllArgsConstructor() {
        Long id = 1L;
        String descricao = "Descrição da avaliação";
        String estrelas = "5";
        String nomeRestaurante = "Nome do Restaurante";

        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO(id, descricao, estrelas, nomeRestaurante);

        assertEquals(id, avaliacaoDTO.getId());
        assertEquals(descricao, avaliacaoDTO.getDescricao());
        assertEquals(estrelas, avaliacaoDTO.getEstrelas());
        assertEquals(nomeRestaurante, avaliacaoDTO.getNomeRestaurante());
    }

    @Test
    void testNoArgsConstructor() {
        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO();

        assertEquals(null, avaliacaoDTO.getId());
        assertEquals(null, avaliacaoDTO.getDescricao());
        assertEquals(null, avaliacaoDTO.getEstrelas());
        assertEquals(null, avaliacaoDTO.getNomeRestaurante());
    }

    @Test
    void testGetterAndSetter() {
        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO();

        Long id = 1L;
        String descricao = "Descrição da avaliação";
        String estrelas = "5";
        String nomeRestaurante = "Nome do Restaurante";

        avaliacaoDTO.setId(id);
        avaliacaoDTO.setDescricao(descricao);
        avaliacaoDTO.setEstrelas(estrelas);
        avaliacaoDTO.setNomeRestaurante(nomeRestaurante);

        assertEquals(id, avaliacaoDTO.getId());
        assertEquals(descricao, avaliacaoDTO.getDescricao());
        assertEquals(estrelas, avaliacaoDTO.getEstrelas());
        assertEquals(nomeRestaurante, avaliacaoDTO.getNomeRestaurante());
    }
}
