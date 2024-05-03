package br.com.fiap.fiapfood.presentation.mapper;

import br.com.fiap.fiapfood.domain.entity.ReservaDomain;
import br.com.fiap.fiapfood.infrastructure.persistence.dbmappers.DBMapperReserva;
import br.com.fiap.fiapfood.presentation.dto.ReservaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservaMapper {

    ReservaMapper INSTANCE = Mappers.getMapper(ReservaMapper.class);

    DBMapperReserva toReservaEntity(ReservaDomain reservaDomain);

    ReservaDomain toReservaDomain(DBMapperReserva DBMapperReserva);

    ReservaDomain toReservaDomainFromDTO(ReservaDTO reservaDTO);

    ReservaDTO toReservaDTO(ReservaDomain reservaDomain);

}
