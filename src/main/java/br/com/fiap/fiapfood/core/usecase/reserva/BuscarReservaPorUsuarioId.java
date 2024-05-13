package br.com.fiap.fiapfood.core.usecase.reserva;

import br.com.fiap.fiapfood.core.entity.ReservaDomain;
import br.com.fiap.fiapfood.core.entity.UsuarioDomain;
import br.com.fiap.fiapfood.core.gateways.ReservaRepository;
import br.com.fiap.fiapfood.core.gateways.UsuarioRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuscarReservaPorUsuarioId {

    private final UsuarioRepository usuarioRepository;
    private final ReservaRepository reservaRepository;

    public BuscarReservaPorUsuarioId(UsuarioRepository usuarioRepository, ReservaRepository reservaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.reservaRepository = reservaRepository;
    }

    public List<ReservaDomain> call(Long usuarioId) {
        UsuarioDomain usuario = usuarioRepository.buscarPorId(usuarioId);
        return reservaRepository.buscarPorUsuario(usuario);
    }
}
