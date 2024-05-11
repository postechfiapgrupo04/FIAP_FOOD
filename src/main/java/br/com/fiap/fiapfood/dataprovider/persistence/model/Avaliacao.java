package br.com.fiap.fiapfood.dataprovider.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(
        name = "avaliacao"
        , uniqueConstraints = {@UniqueConstraint(name = "UK_AVALIACAO", columnNames = {"descricao", "estrelas", "nomeRestaurante"})}
)
@AllArgsConstructor
@NoArgsConstructor
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "estrelas", nullable = false)
    private String estrelas;

    @Column(name = "nomeRestaurante", nullable = false)
    private String nomeRestaurante;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Avaliacao avaliacao)) return false;
        return Objects.equals(descricao, avaliacao.descricao) && Objects.equals(estrelas, avaliacao.estrelas) && Objects.equals(nomeRestaurante, avaliacao.nomeRestaurante);
    }

    @Override
    public int hashCode() {

        return Objects.hash(descricao, estrelas, nomeRestaurante);
    }
}
