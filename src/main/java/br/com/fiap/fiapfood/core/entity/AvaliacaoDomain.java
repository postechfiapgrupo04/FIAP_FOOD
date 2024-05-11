package br.com.fiap.fiapfood.core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoDomain {
    private Long id;
    private RestauranteDomain idRestaurante;
    private UsuarioDomain idUsuario;
    private int estrelas;
    private String descricao;
}
