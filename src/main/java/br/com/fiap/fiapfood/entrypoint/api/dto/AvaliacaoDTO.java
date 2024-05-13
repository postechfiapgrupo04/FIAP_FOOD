package br.com.fiap.fiapfood.entrypoint.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoDTO {
    private Long id;
    private String descricao;
    private String estrelas;
    private String nomeRestaurante;
}
