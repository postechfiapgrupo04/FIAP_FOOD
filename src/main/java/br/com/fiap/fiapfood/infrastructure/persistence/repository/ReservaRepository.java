package br.com.fiap.fiapfood.infrastructure.persistence.repository;

import br.com.fiap.fiapfood.infrastructure.persistence.dbmappers.DBMapperReserva;
import br.com.fiap.fiapfood.infrastructure.persistence.dbmappers.DBMapperRestaurante;
import br.com.fiap.fiapfood.infrastructure.persistence.dbmappers.DBMapperUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservaRepository extends JpaRepository<DBMapperReserva, Long> {

    Optional<List<DBMapperReserva>> findByUsuario(DBMapperUsuario usuario);

    Optional<List<DBMapperReserva>> findByDataReserva(LocalDate dataReserva);

    Optional<List<DBMapperReserva>> findByRestaurante(DBMapperRestaurante restaurante);

}
