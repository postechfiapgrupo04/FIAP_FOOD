package br.com.fiap.fiapfood.entrypoint.api.dto;

import br.com.fiap.fiapfood.core.entity.EnderecoDomain;
import br.com.fiap.fiapfood.core.enums.TipoCozinha;

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
