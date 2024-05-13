package br.com.fiap.fiapfood.core.entity;

import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservaDomain {

    private Long id;
    private LocalDateTime dataReserva;
    private RestauranteDomain restaurante;
    private UsuarioDomain usuario;
    private int quantidadePessoas;

}
