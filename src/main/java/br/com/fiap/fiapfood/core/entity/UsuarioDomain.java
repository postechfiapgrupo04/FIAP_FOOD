package br.com.fiap.fiapfood.core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDomain {

    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private List<ReservaDomain> reservas;

}
