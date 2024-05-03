package br.com.fiap.fiapfood.application.usecase;

import br.com.fiap.fiapfood.domain.entity.ReservaDomain;
import br.com.fiap.fiapfood.domain.entity.RestauranteDomain;
import br.com.fiap.fiapfood.domain.entity.UsuarioDomain;
import br.com.fiap.fiapfood.domain.gatewayrepository.ReservaGatewayRepository;
import br.com.fiap.fiapfood.domain.usecase.ReservaUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ReservaUseCaseImp implements ReservaUsecase {

    private final ReservaGatewayRepository reservaGatewayRepository;


    @Override
    public ReservaDomain salvar(ReservaDomain reserva) {
        return reservaGatewayRepository.salvar(reserva);
    }

    @Override
    public ReservaDomain buscarPorId(Long id) {
        return reservaGatewayRepository.buscarPorId(id);
    }

    @Override
    public void apagar(Long id) {
        reservaGatewayRepository.apagar(id);
    }

    @Override
    public List<ReservaDomain> buscarPorUsuario(UsuarioDomain usuario) {
        return reservaGatewayRepository.buscarPorUsuario(usuario);
    }

    @Override
    public List<ReservaDomain> buscarPorDataReserva(LocalDate dataReserva) {
        return reservaGatewayRepository.buscarPorDataReserva(dataReserva);
    }

    @Override
    public List<ReservaDomain> buscarPorRestaurante(RestauranteDomain restaurante) {
        return reservaGatewayRepository.buscarPorRestaurante(restaurante);
    }
}
