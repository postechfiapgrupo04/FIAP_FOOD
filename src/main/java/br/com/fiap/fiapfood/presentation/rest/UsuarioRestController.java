package br.com.fiap.fiapfood.presentation.rest;

import br.com.fiap.fiapfood.core.controller.UsuarioController;
import br.com.fiap.fiapfood.core.domain.entity.UsuarioDomain;
import br.com.fiap.fiapfood.presentation.dto.UsuarioDTO;
import br.com.fiap.fiapfood.presentation.mapper.UsuarioMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioRestController {

    private final UsuarioController usuarioController;

    @PostMapping
    public UsuarioDTO salvar(@RequestBody UsuarioDTO usuarioDTO) {

        return UsuarioMapper.INSTANCE.toUsuarioDTO(
                usuarioController.salvar(
                        UsuarioMapper.INSTANCE.toUsuarioDomainFromDTO(usuarioDTO)));
    }

    @GetMapping("/{id}")
    public UsuarioDTO buscarPorId(@PathVariable Long id) {
        UsuarioDomain usuarioDomain = usuarioController.buscarPorId(id);
        return UsuarioMapper.INSTANCE.toUsuarioDTO(usuarioDomain);
    }


    @GetMapping
    public List<UsuarioDTO> buscarTodos() {
        return usuarioController.buscarTodos()
                .stream()
                .map(UsuarioMapper.INSTANCE::toUsuarioDTO)
                .toList();
    }

    @GetMapping("/cpf")
    public UsuarioDTO buscarPorCPF(@RequestParam("cpf") String cpf) {
        UsuarioDomain usuarioDomain = usuarioController.buscarPorCPF(cpf);
        return UsuarioMapper.INSTANCE.toUsuarioDTO(usuarioDomain);
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id) {

        usuarioController.apagar(id);
    }

}
