package br.com.fiap.fiapfood.presentation.controller;

import br.com.fiap.fiapfood.domain.entity.ReservaDomain;
import br.com.fiap.fiapfood.domain.entity.RestauranteDomain;
import br.com.fiap.fiapfood.domain.entity.UsuarioDomain;
import br.com.fiap.fiapfood.domain.usecase.ReservaUsecase;
import br.com.fiap.fiapfood.presentation.dto.ReservaDTO;
import br.com.fiap.fiapfood.presentation.mapper.ReservaMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reserva")
@AllArgsConstructor
public class ReservaController {

    private final ReservaUsecase reservaUseCase;

    @PostMapping
    public ReservaDTO salvar(@RequestBody ReservaDTO reservaDTO) {
        return ReservaMapper.INSTANCE.toReservaDTO(
                reservaUseCase.salvar(
                        ReservaMapper.INSTANCE.toReservaDomainFromDTO(reservaDTO)));
    }

    @GetMapping("/{id}")
    public ReservaDTO buscarPorId(@PathVariable Long id) {
        return ReservaMapper.INSTANCE.toReservaDTO(reservaUseCase.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id) {
        reservaUseCase.apagar(id);
    }

    @GetMapping("/usuario/{id}")
    public List<ReservaDomain> buscarPorUsuario(@PathVariable Long usuarioId) {
        return ReservaMapper.INSTANCE.toReservaDTO(reservaUseCase.buscarPorUsuario(usuarioId));
    }

    @Override
    public List<ReservaDomain> buscarPorDataReserva(LocalDate dataReserva) {
        return reservaUseCase.buscarPorDataReserva(dataReserva).stream().map(ReservaMapper.INSTANCE::toReservaDTO).toList());
    }

    @Override
    public List<ReservaDomain> buscarPorRestaurante(RestauranteDomain restaurante) {
        return reservaGateway.buscarPorRestaurante(restaurante);
    }

}
