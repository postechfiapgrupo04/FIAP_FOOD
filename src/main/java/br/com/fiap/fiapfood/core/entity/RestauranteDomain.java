package br.com.fiap.fiapfood.core.entity;

import br.com.fiap.fiapfood.core.enums.TipoCozinha;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestauranteDomain {

    private Long id;
    private String nome;
    private EnderecoDomain endereco;
    private TipoCozinha tipoCozinha;
    private LocalTime horarioFuncionamentoAbertura;
    private LocalTime horarioFuncionamentoFechamento;
    private int capacidade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RestauranteDomain that)) return false;
        return capacidade == that.capacidade && Objects.equals(nome, that.nome) && Objects.equals(endereco, that.endereco) && tipoCozinha == that.tipoCozinha && Objects.equals(horarioFuncionamentoAbertura, that.horarioFuncionamentoAbertura) && Objects.equals(horarioFuncionamentoFechamento, that.horarioFuncionamentoFechamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, endereco, tipoCozinha, horarioFuncionamentoAbertura, horarioFuncionamentoFechamento, capacidade);
    }
}
