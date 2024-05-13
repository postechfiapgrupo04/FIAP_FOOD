package br.com.fiap.fiapfood.entrypoint.api;

import br.com.fiap.fiapfood.entrypoint.api.dto.ReservaDTO;
import br.com.fiap.fiapfood.entrypoint.api.dto.ReservaRequestDTO;
import br.com.fiap.fiapfood.entrypoint.facade.ReservaFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
@RequiredArgsConstructor
public class ReservaRestController {

    private final ReservaFacade reservaFacade;
    @PostMapping
    public ResponseEntity<ReservaDTO> salvar(@RequestBody ReservaRequestDTO reservaRequestDTO) {
        return ResponseEntity.ok(reservaFacade.salvar(reservaRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<ReservaDTO>> buscarTodos() {
        return ResponseEntity.ok(reservaFacade.buscarTodos());
    }

    @GetMapping("/{id}")
    public ReservaDTO buscarPorId(@PathVariable Long id) {
        return reservaFacade.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id) {
        reservaFacade.apagar(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<ReservaDTO>> buscarPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(reservaFacade.buscarPorUsuario(usuarioId));
    }

//    @GetMapping("/data/{dataReserva}")
//    public List<ReservaDTO> buscarPorDataReserva(@PathVariable LocalDate dataReserva) {
//        return reservaFacade.buscarPorDataReserva(dataReserva)
//                .stream().map(ReservaMapper::toReservaDTO).toList();
//    }

    @GetMapping("/restaurante/{restauranteId}")
    public ResponseEntity<List<ReservaDTO>> buscarPorRestaurante(@PathVariable Long restauranteId) {
        return ResponseEntity.ok(reservaFacade.buscarPorRestaurante(restauranteId));
    }

}
