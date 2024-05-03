package br.com.fiap.fiapfood.domain.entity;

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
public class ReservaDomain {

    private Long id;
    private LocalTime dataReserva;
    private RestauranteDomain restaurante;
    private UsuarioDomain usuario;
    private int quantidadePessoas;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReservaDomain that)) return false;
        return quantidadePessoas == that.quantidadePessoas && Objects.equals(dataReserva, that.dataReserva) && Objects.equals(restaurante, that.restaurante) && Objects.equals(usuario, that.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataReserva, restaurante, usuario, quantidadePessoas);
    }
}
