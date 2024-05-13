package br.com.fiap.fiapfood.dataprovider.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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
    private LocalDateTime dataReserva;

    @ManyToOne
    @JoinColumn(name = "idrestaurante")
    private Restaurante restaurante;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    @Column(name = "quantidadepessoas", nullable = false)
    private int quantidadePessoas;
}
