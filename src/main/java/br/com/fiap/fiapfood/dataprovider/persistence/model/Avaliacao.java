package br.com.fiap.fiapfood.dataprovider.persistence.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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
@NoArgsConstructor
@AllArgsConstructor
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name= "nomerestaurante")
    private String nomeRestaurante;

    /*
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;
     */

    @Min(1)
    @Min(5)
    @Column(name = "estrelas", nullable = false)
    private String estrelas;

    @Column(name = "descricao", nullable = false)
    private String descricao;

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
