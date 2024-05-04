package br.com.fiap.fiapfood.presentation.rest;

import br.com.fiap.fiapfood.core.domain.usecase.ReservaUsecase;
import br.com.fiap.fiapfood.presentation.dto.ReservaDTO;
import br.com.fiap.fiapfood.presentation.mapper.ReservaMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reserva")
@AllArgsConstructor
public class ReservaRestController {

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

    @GetMapping("/usuario/{usuarioId}")
    public List<ReservaDTO> buscarPorUsuario(@PathVariable Long usuarioId) {
        return reservaUseCase.buscarPorUsuario(usuarioId)
                .stream().map(ReservaMapper.INSTANCE::toReservaDTO).toList();
    }

    @GetMapping("/data/{dataReserva}")
    public List<ReservaDTO> buscarPorDataReserva(@PathVariable LocalDate dataReserva) {
        return reservaUseCase.buscarPorDataReserva(dataReserva)
                .stream().map(ReservaMapper.INSTANCE::toReservaDTO).toList();
    }

    @GetMapping("/restaurante/{restauranteId}")
    public List<ReservaDTO> buscarPorRestaurante(@PathVariable Long restauranteId) {
        return reservaUseCase.buscarPorRestaurante(restauranteId)
                .stream().map(ReservaMapper.INSTANCE::toReservaDTO).toList();
    }

}
