package br.com.fiap.fiapfood.core.usecase.reserva;

import br.com.fiap.fiapfood.core.entity.ReservaDomain;
import br.com.fiap.fiapfood.core.gateways.ReservaRepository;
import org.springframework.stereotype.Component;

@Component
public class SalvarReserva {

    private final ReservaRepository reservaRepository;

    public SalvarReserva(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public ReservaDomain call(ReservaDomain reserva) {
        return reservaRepository.salvar(reserva);
    }
}
