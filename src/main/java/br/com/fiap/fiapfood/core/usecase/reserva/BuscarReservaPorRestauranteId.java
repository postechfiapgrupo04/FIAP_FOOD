package br.com.fiap.fiapfood.core.usecase.reserva;

import br.com.fiap.fiapfood.core.entity.ReservaDomain;
import br.com.fiap.fiapfood.core.entity.RestauranteDomain;
import br.com.fiap.fiapfood.core.gateways.ReservaRepository;
import br.com.fiap.fiapfood.core.gateways.RestauranteRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BuscarReservaPorRestauranteId {

    private final ReservaRepository reservaRepository;
    private final RestauranteRepository restauranteRepository;

    public BuscarReservaPorRestauranteId(ReservaRepository reservaRepository, RestauranteRepository restauranteRepository) {
        this.reservaRepository = reservaRepository;
        this.restauranteRepository = restauranteRepository;
    }

    public List<ReservaDomain> call(Long restauranteId) {
        RestauranteDomain restaurante = restauranteRepository.buscarPorId(restauranteId);
        return reservaRepository.buscarPorRestaurante(restaurante);
    }
}
