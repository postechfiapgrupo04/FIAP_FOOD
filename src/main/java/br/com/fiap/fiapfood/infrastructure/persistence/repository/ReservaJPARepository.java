package br.com.fiap.fiapfood.infrastructure.persistence.repository;

import br.com.fiap.fiapfood.infrastructure.persistence.model.Reserva;
import br.com.fiap.fiapfood.infrastructure.persistence.model.Restaurante;
import br.com.fiap.fiapfood.infrastructure.persistence.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservaJPARepository extends JpaRepository<Reserva, Long> {

    Optional<List<Reserva>> findByUsuario(Usuario usuario);

    Optional<List<Reserva>> findByDataReserva(LocalDate dataReserva);

    Optional<List<Reserva>> findByRestaurante(Restaurante restaurante);

}
