package br.com.fiap.fiapfood.presentation.mapper;

import br.com.fiap.fiapfood.core.domain.entity.ReservaDomain;
import br.com.fiap.fiapfood.infrastructure.persistence.model.Reserva;
import br.com.fiap.fiapfood.presentation.dto.ReservaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservaMapper {

    ReservaMapper INSTANCE = Mappers.getMapper(ReservaMapper.class);

    Reserva toReservaEntity(ReservaDomain reservaDomain);

    ReservaDomain toReservaDomain(Reserva Reserva);

    ReservaDomain toReservaDomainFromDTO(ReservaDTO reservaDTO);

    ReservaDTO toReservaDTO(ReservaDomain reservaDomain);

}
