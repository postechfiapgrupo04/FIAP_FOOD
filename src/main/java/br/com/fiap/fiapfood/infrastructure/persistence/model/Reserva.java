package br.com.fiap.fiapfood.infrastructure.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "reserva")
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "datareserva", nullable = false)
    private LocalTime dataReserva;

    @Column(name = "quantidadepessoas", nullable = false)
    private int quantidadePessoas;

    @ManyToOne
    @JoinColumn(name = "idrestaurante")
    private Restaurante restaurante;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva that = (Reserva) o;
        return Objects.equals(id, that.id) && Objects.equals(dataReserva, that.dataReserva) && Objects.equals(restaurante, that.restaurante) && Objects.equals(usuario, that.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataReserva, restaurante, usuario);
    }
}
