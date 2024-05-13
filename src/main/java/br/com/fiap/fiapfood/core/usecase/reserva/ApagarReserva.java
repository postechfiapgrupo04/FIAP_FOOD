package br.com.fiap.fiapfood.core.usecase.reserva;

import br.com.fiap.fiapfood.core.gateways.ReservaRepository;
import org.springframework.stereotype.Component;

@Component
public class ApagarReserva {

    private final ReservaRepository reservaRepository;

    public ApagarReserva(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public void call(Long id) {
        reservaRepository.apagar(id);
    }
}
