package br.com.fiap.fiapfood.dataprovider.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(
        name = "usuario"
        , uniqueConstraints = {@UniqueConstraint(name = "UK_USER", columnNames = {"nome", "email", "cpf"})}
)
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    /*@OneToMany(mappedBy = "usuario")
    private List<Avaliacao> avaliacoes;*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(nome, usuario.nome) && Objects.equals(email, usuario.email) && Objects.equals(cpf, usuario.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, cpf);
    }
}
