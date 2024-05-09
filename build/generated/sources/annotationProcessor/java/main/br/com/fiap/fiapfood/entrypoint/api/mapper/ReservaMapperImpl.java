package br.com.fiap.fiapfood.entrypoint.api.mapper;

import br.com.fiap.fiapfood.core.entity.ReservaDomain;
import br.com.fiap.fiapfood.core.entity.RestauranteDomain;
import br.com.fiap.fiapfood.core.entity.UsuarioDomain;
import br.com.fiap.fiapfood.dataprovider.persistence.model.Reserva;
import br.com.fiap.fiapfood.entrypoint.api.dto.ReservaDTO;
import java.time.LocalTime;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-08T21:03:19-0300",
    comments = "version: 1.6.0.Beta1, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.3 (Amazon.com Inc.)"
)
public class ReservaMapperImpl implements ReservaMapper {

    @Override
    public Reserva toReservaEntity(ReservaDomain reservaDomain) {
        if ( reservaDomain == null ) {
            return null;
        }

        Reserva reserva = new Reserva();

        return reserva;
    }

    @Override
    public ReservaDomain toReservaDomain(Reserva Reserva) {
        if ( Reserva == null ) {
            return null;
        }

        ReservaDomain reservaDomain = new ReservaDomain();

        return reservaDomain;
    }

    @Override
    public ReservaDomain toReservaDomainFromDTO(ReservaDTO reservaDTO) {
        if ( reservaDTO == null ) {
            return null;
        }

        ReservaDomain reservaDomain = new ReservaDomain();

        return reservaDomain;
    }

    @Override
    public ReservaDTO toReservaDTO(ReservaDomain reservaDomain) {
        if ( reservaDomain == null ) {
            return null;
        }

        Long id = null;
        LocalTime dataReserva = null;
        RestauranteDomain restaurante = null;
        UsuarioDomain usuario = null;

        ReservaDTO reservaDTO = new ReservaDTO( id, dataReserva, restaurante, usuario );

        return reservaDTO;
    }
}
