package br.com.fiap.fiapfood.application.usecase;

import br.com.fiap.fiapfood.core.entity.ReservaDomain;
import br.com.fiap.fiapfood.core.entity.RestauranteDomain;
import br.com.fiap.fiapfood.core.entity.UsuarioDomain;
import br.com.fiap.fiapfood.core.repositories.ReservaRepository;
import br.com.fiap.fiapfood.core.repositories.RestauranteRepository;
import br.com.fiap.fiapfood.core.repositories.UsuarioRepository;
import br.com.fiap.fiapfood.core.usecase.ReservaUsecase;
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
