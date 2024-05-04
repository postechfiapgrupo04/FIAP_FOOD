package br.com.fiap.fiapfood.presentation.dto;

import br.com.fiap.fiapfood.core.domain.entity.RestauranteDomain;
import br.com.fiap.fiapfood.core.domain.entity.UsuarioDomain;

import java.time.LocalTime;

public record ReservaDTO(
        Long id,
        LocalTime dataReserva,
        RestauranteDomain restaurante,
        UsuarioDomain usuario
) {

}
