package br.com.fiap.fiapfood.core.domain.entity;

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

    /*
    public UsuarioDomain(String nome, String email, String cpf) {

        if (nome.isBlank() || nome.isEmpty()) {
            throw new RuntimeException("Nome inválido");
        }
        if (email.isBlank() || email.isEmpty()) {
            throw new RuntimeException("Email inválido");
        }
        if (cpf.isBlank() || cpf.isEmpty()) {
            throw new RuntimeException("CPF inválido");
        }

        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioDomain usuario)) return false;
        return Objects.equals(nome, usuario.nome) && Objects.equals(email, usuario.email) && Objects.equals(cpf, usuario.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, cpf);
    }
}
