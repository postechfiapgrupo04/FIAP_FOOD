package br.com.fiap.fiapfood.presentation.dto;

import br.com.fiap.fiapfood.core.domain.entity.EnderecoDomain;
import br.com.fiap.fiapfood.core.domain.enums.TipoCozinha;

import java.time.LocalTime;

public record RestauranteDTO(
        Long id,
        String nome,
        EnderecoDomain endereco,
        TipoCozinha tipoCozinha,
        LocalTime horarioFuncionamentoAbertura,
        LocalTime horarioFuncionamentoFechamento,
        int capacidade
) {
}
