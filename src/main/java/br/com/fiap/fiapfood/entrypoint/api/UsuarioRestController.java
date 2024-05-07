package br.com.fiap.fiapfood.entrypoint.api;

import br.com.fiap.fiapfood.entrypoint.facade.UsuarioFacade;
import br.com.fiap.fiapfood.core.entity.UsuarioDomain;
import br.com.fiap.fiapfood.entrypoint.api.dto.UsuarioDTO;
import br.com.fiap.fiapfood.entrypoint.api.mapper.UsuarioMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioRestController {

    private final UsuarioFacade usuarioFacade;

    @PostMapping
    public UsuarioDTO salvar(@RequestBody UsuarioDTO usuarioDTO) {

        return UsuarioMapper.INSTANCE.toUsuarioDTOFromDomain(
                usuarioFacade.salvar(
                        UsuarioMapper.INSTANCE.toUsuarioDomainFromDTO(usuarioDTO)));
    }

    @GetMapping("/{id}")
    public UsuarioDTO buscarPorId(@PathVariable Long id) {
        UsuarioDomain usuarioDomain = usuarioFacade.buscarPorId(id);
        return UsuarioMapper.INSTANCE.toUsuarioDTOFromDomain(usuarioDomain);
    }


    @GetMapping
    public List<UsuarioDTO> buscarTodos() {
        return usuarioFacade.buscarTodos()
                .stream()
                .map(UsuarioMapper.INSTANCE::toUsuarioDTOFromDomain)
                .toList();
    }

    @GetMapping("/cpf")
    public UsuarioDTO buscarPorCPF(@RequestParam("cpf") String cpf) {
        UsuarioDomain usuarioDomain = usuarioFacade.buscarPorCPF(cpf);
        return UsuarioMapper.INSTANCE.toUsuarioDTOFromDomain(usuarioDomain);
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id) {

        usuarioFacade.apagar(id);
    }

}
