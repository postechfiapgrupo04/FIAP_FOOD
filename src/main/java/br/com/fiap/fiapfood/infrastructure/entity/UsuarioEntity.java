package br.com.fiap.fiapfood.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(
        name = "usuario"
        , uniqueConstraints = {@UniqueConstraint(name = "UK_USER", columnNames = {"name", "email", "cpf"})}
)
@NoArgsConstructor
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    public UsuarioEntity(String nome, String email, String cpf) {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioEntity usuario)) return false;
        return Objects.equals(nome, usuario.nome) && Objects.equals(email, usuario.email) && Objects.equals(cpf, usuario.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, cpf);
    }
}
