package br.com.fiap.fiapfood.dataprovider.persistence.model;

import br.com.fiap.fiapfood.core.enums.TipoCozinha;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(
        name = "restaurante"
        , uniqueConstraints = {@UniqueConstraint(name = "UK_RESTAURANT", columnNames = {"nome", "localizacao"})}
)
@NoArgsConstructor
@AllArgsConstructor
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToOne
    private Endereco endereco;

//    @OneToMany(mappedBy = "restaurante")
//    private List<Reserva> reserva;

    /*@OneToMany(mappedBy = "restaurante")
    private List<Avaliacao> avaliacoes;*/

    @Column(name = "tipocozinha", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoCozinha tipoCozinha;

    @Column(name = "horaabertura", nullable = false)
    private LocalTime horarioFuncionamentoAbertura;

    @Column(name = "horafechamento", nullable = false)
    private LocalTime horarioFuncionamentoFechamento;

    @Column(name = "capacidade", nullable = false)
    private int capacidade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurante that)) return false;
        return capacidade == that.capacidade && Objects.equals(nome, that.nome) && Objects.equals(endereco, that.endereco) && tipoCozinha == that.tipoCozinha && Objects.equals(horarioFuncionamentoAbertura, that.horarioFuncionamentoAbertura) && Objects.equals(horarioFuncionamentoFechamento, that.horarioFuncionamentoFechamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, endereco, tipoCozinha, horarioFuncionamentoAbertura, horarioFuncionamentoFechamento, capacidade);
    }
}
