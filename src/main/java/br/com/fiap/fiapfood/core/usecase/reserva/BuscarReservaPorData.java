package br.com.fiap.fiapfood.core.usecase.reserva;

import br.com.fiap.fiapfood.core.entity.ReservaDomain;
import br.com.fiap.fiapfood.core.gateways.ReservaRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
@Component
public class BuscarReservaPorData {
    private final ReservaRepository reservaRepository;

    public BuscarReservaPorData(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<ReservaDomain> call(LocalDate dataReserva) {
        return reservaRepository.buscarPorDataReserva(dataReserva);
    }
}
