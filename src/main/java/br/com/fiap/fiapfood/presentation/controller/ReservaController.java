package br.com.fiap.fiapfood.presentation.controller;

import br.com.fiap.fiapfood.domain.usecase.ReservaUsecase;
import br.com.fiap.fiapfood.presentation.dto.ReservaDTO;
import br.com.fiap.fiapfood.presentation.mapper.ReservaMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/nome/{nome}")
    public ReservaDTO buscarPorNome(@PathVariable String nome) {
        return ReservaMapper.INSTANCE.toReservaDTO(reservaUseCase.buscarPorNome(nome));
    }

}
