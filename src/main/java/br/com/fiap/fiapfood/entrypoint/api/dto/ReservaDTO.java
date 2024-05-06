package br.com.fiap.fiapfood.entrypoint.api.dto;

import br.com.fiap.fiapfood.core.entity.RestauranteDomain;
import br.com.fiap.fiapfood.core.entity.UsuarioDomain;

import java.time.LocalTime;

public record ReservaDTO(
        Long id,
        LocalTime dataReserva,
        RestauranteDomain restaurante,
        UsuarioDomain usuario
) {

}
