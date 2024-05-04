package br.com.fiap.fiapfood.application.usecase;

import br.com.fiap.fiapfood.core.domain.entity.ReservaDomain;
import br.com.fiap.fiapfood.core.domain.entity.RestauranteDomain;
import br.com.fiap.fiapfood.core.domain.entity.UsuarioDomain;
import br.com.fiap.fiapfood.core.domain.repositories.ReservaRepository;
import br.com.fiap.fiapfood.core.domain.repositories.RestauranteRepository;
import br.com.fiap.fiapfood.core.domain.repositories.UsuarioRepository;
import br.com.fiap.fiapfood.core.domain.usecase.ReservaUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ReservaUseCaseImp implements ReservaUsecase {

    private final ReservaRepository reservaRepository;
    private final UsuarioRepository usuarioRepository;
    private final RestauranteRepository restauranteRepository;


    @Override
    public ReservaDomain salvar(ReservaDomain reserva) {
        return reservaRepository.salvar(reserva);
    }

    @Override
    public ReservaDomain buscarPorId(Long id) {
        return reservaRepository.buscarPorId(id);
    }

    @Override
    public void apagar(Long id) {
        reservaRepository.apagar(id);
    }

    @Override
    public List<ReservaDomain> buscarPorUsuario(Long usuarioId) {
        UsuarioDomain usuario = usuarioRepository.buscarPorId(usuarioId);
        return reservaRepository.buscarPorUsuario(usuario);
    }

    @Override
    public List<ReservaDomain> buscarPorDataReserva(LocalDate dataReserva) {
        return reservaRepository.buscarPorDataReserva(dataReserva);
    }

    @Override
    public List<ReservaDomain> buscarPorRestaurante(Long restauranteId) {
        RestauranteDomain restaurante = restauranteRepository.buscarPorId(restauranteId);
        return reservaRepository.buscarPorRestaurante(restaurante);
    }
}
