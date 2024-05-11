package br.com.fiap.fiapfood.entrypoint.api;

import br.com.fiap.fiapfood.entrypoint.facade.UsuarioFacade;
import br.com.fiap.fiapfood.entrypoint.api.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioRestController {

    private final UsuarioFacade usuarioFacade;

    @PostMapping
    public UsuarioDTO salvar(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioFacade.salvar(usuarioDTO);
    }

    @GetMapping("/{id}")
    public UsuarioDTO buscarPorId(@PathVariable Long id) {
        return usuarioFacade.buscarPorId(id);
    }


    @GetMapping
    public List<UsuarioDTO> buscarTodos() {
        return usuarioFacade.buscarTodos()
                .stream()
                .toList();
    }

    @GetMapping("/cpf/{cpf}")
       public UsuarioDTO buscarPorCPF(@PathVariable String cpf) {
       return usuarioFacade.buscarPorCPF(cpf);
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id) {
        usuarioFacade.apagar(id);
    }

}
