package br.com.fiap.fiapfood.domain.model;

import br.com.fiap.fiapfood.domain.enums.TipoCozinha;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(
        name = "restaurante"
        , uniqueConstraints = {@UniqueConstraint(name = "UK_RESTAURANT", columnNames = {"nome", "localizacao"})}
)
@NoArgsConstructor
public class RestauranteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToOne
    private EnderecoEntity endereco;

    @Column(name = "tipocozinha", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoCozinha tipoCozinha;

    @Column(name = "horaabertura", nullable = false)
    private LocalTime horarioFuncionamentoAbertura;

    @Column(name = "horafechamento", nullable = false)
    private LocalTime horarioFuncionamentoFechamento;

    @Column(name = "capacidade", nullable = false)
    private int capacidade;

    public RestauranteEntity(String nome, EnderecoEntity endereco, TipoCozinha tipoCozinha, LocalTime horarioFuncionamentoAbertura, LocalTime horarioFuncionamentoFechamento, int capacidade) {
        this.nome = nome;
        this.endereco = endereco;
        this.tipoCozinha = tipoCozinha;
        this.horarioFuncionamentoAbertura = horarioFuncionamentoAbertura;
        this.horarioFuncionamentoFechamento = horarioFuncionamentoFechamento;
        this.capacidade = capacidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RestauranteEntity that)) return false;
        return capacidade == that.capacidade && Objects.equals(nome, that.nome) && Objects.equals(endereco, that.endereco) && tipoCozinha == that.tipoCozinha && Objects.equals(horarioFuncionamentoAbertura, that.horarioFuncionamentoAbertura) && Objects.equals(horarioFuncionamentoFechamento, that.horarioFuncionamentoFechamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, endereco, tipoCozinha, horarioFuncionamentoAbertura, horarioFuncionamentoFechamento, capacidade);
    }
}
