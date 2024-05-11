package br.com.fiap.fiapfood.entrypoint.api;
import br.com.fiap.fiapfood.entrypoint.facade.AvaliacaoFacade;
import br.com.fiap.fiapfood.core.entity.AvaliacaoDomain;
import br.com.fiap.fiapfood.entrypoint.api.dto.AvaliacaoDTO;
import br.com.fiap.fiapfood.entrypoint.api.mapper.AvaliacaoMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
@AllArgsConstructor
public class AvaliacaoRestController {

    private final AvaliacaoFacade avaliacaoFacade;

    @PostMapping
    public AvaliacaoDTO salvar(@RequestBody AvaliacaoDTO avaliacaoDTO) {
        return avaliacaoFacade.salvar(avaliacaoDTO);
    }

    @GetMapping("/{id}")
    public AvaliacaoDTO buscarPorId(@PathVariable Long id) {
        return avaliacaoFacade.buscarPorId(id);
    }


    @GetMapping
    public List<AvaliacaoDTO> buscarTodos() {
        return avaliacaoFacade.buscarTodos()
                .stream()
                .toList();
    }

    @GetMapping("/restaurante/{nomeRestaurante}")
    public AvaliacaoDTO buscarPorNomeRestaurante(@PathVariable("nomeRestaurante") String nomeRestaurante) {
        return avaliacaoFacade.buscarPorNomeRestaurante(nomeRestaurante);
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id) {
        avaliacaoFacade.apagar(id);
    }

}
