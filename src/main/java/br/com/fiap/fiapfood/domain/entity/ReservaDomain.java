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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservaDomain that = (ReservaDomain) o;
        return Objects.equals(id, that.id) && Objects.equals(dataReserva, that.dataReserva) && Objects.equals(restaurante, that.restaurante) && Objects.equals(usuario, that.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataReserva, restaurante, usuario);
    }
}
