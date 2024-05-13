package br.com.fiap.fiapfood.entrypoint.facade.implementation;

import br.com.fiap.fiapfood.core.entity.ReservaDomain;
import br.com.fiap.fiapfood.core.entity.RestauranteDomain;
import br.com.fiap.fiapfood.core.entity.UsuarioDomain;
import br.com.fiap.fiapfood.core.usecase.reserva.*;
import br.com.fiap.fiapfood.core.usecase.restaurante.BuscarRestaurantePorID;
import br.com.fiap.fiapfood.core.usecase.usuario.BuscarUsuarioPorID;
import br.com.fiap.fiapfood.entrypoint.api.dto.ReservaDTO;
import br.com.fiap.fiapfood.entrypoint.api.dto.ReservaRequestDTO;
import br.com.fiap.fiapfood.entrypoint.api.mapper.ReservaMapper;
import br.com.fiap.fiapfood.entrypoint.facade.ReservaFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ReservaFacadeImpl implements ReservaFacade {

    private final SalvarReserva salvarReserva;
    private final BuscarTodasReservas buscarTodasReservas;
    private final BuscarReservaPorId buscarReservaPorId;
    private final BuscarReservaPorUsuarioId buscarReservaPorUsuarioId;
    private final BuscarReservaPorRestauranteId buscarReservaPorRestauranteId;
    private final BuscarUsuarioPorID buscarUsuarioPorID;
    private final BuscarRestaurantePorID buscarRestaurantePorID;
    private final ReservaMapper reservaMapper;

    @Override
    public ReservaDTO salvar(ReservaRequestDTO reservaRequestDTO) {
        UsuarioDomain usuarioDomain = buscarUsuarioPorID.call(reservaRequestDTO.usuarioId());
        RestauranteDomain restauranteDomain = buscarRestaurantePorID.call(reservaRequestDTO.restauranteId());

        ReservaDomain reservaDomain = reservaMapper.toReservaDomainFromRequestDTO(reservaRequestDTO);
        reservaDomain.setUsuario(usuarioDomain);
        reservaDomain.setRestaurante(restauranteDomain);

        reservaDomain = salvarReserva.call(reservaDomain);

        return reservaMapper.toReservaDTOFromReservaDomain(reservaDomain);
    }

    @Override
    public ReservaDTO buscarPorId(Long id) {
        ReservaDomain reservaDomain = buscarReservaPorId.call(id);
        return reservaMapper.toReservaDTOFromReservaDomain(reservaDomain);
    }

    @Override
    public void apagar(Long id) {

    }

    @Override
    public List<ReservaDTO> buscarPorUsuario(Long usuarioId) {
        List<ReservaDomain> reservaDomains = buscarReservaPorUsuarioId.call(usuarioId);
        return reservaDomains.stream()
                .map(reservaMapper::toReservaDTOFromReservaDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReservaDTO> buscarPorRestaurante(Long restauranteId) {
        return buscarReservaPorRestauranteId.call(restauranteId).stream()
                .map(reservaMapper::toReservaDTOFromReservaDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReservaDTO> buscarTodos() {
        return buscarTodasReservas.call().stream()
                .map(reservaMapper::toReservaDTOFromReservaDomain)
                .collect(Collectors.toList());
    }
}
