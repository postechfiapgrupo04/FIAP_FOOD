package br.com.fiap.fiapfood.core.usecase.reserva;

import br.com.fiap.fiapfood.core.entity.ReservaDomain;
import br.com.fiap.fiapfood.core.gateways.ReservaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuscarTodasReservas {
    private final ReservaRepository reservaRepository;

    public BuscarTodasReservas(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }


    public List<ReservaDomain> call() {
        return reservaRepository.buscarTodasReservas();
    }
}
