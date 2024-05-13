package br.com.fiap.fiapfood.core.usecase.reserva;

import br.com.fiap.fiapfood.core.entity.ReservaDomain;
import br.com.fiap.fiapfood.core.gateways.ReservaRepository;
import org.springframework.stereotype.Component;

@Component
public class BuscarReservaPorId {
    private final ReservaRepository reservaRepository;

    public BuscarReservaPorId(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public ReservaDomain call(Long id) {
        return reservaRepository.buscarPorId(id);
    }
}
