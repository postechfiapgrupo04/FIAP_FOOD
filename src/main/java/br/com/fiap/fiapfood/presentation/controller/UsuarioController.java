package br.com.fiap.fiapfood.presentation.controller;

import br.com.fiap.fiapfood.domain.entity.UsuarioDomain;
import br.com.fiap.fiapfood.domain.usecase.UsuarioUsecase;
import br.com.fiap.fiapfood.presentation.dto.UsuarioDTO;
import br.com.fiap.fiapfood.presentation.mapper.UsuarioMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioUsecase usuarioUseCase;

    @PostMapping
    public UsuarioDTO salvar(@RequestBody UsuarioDTO usuarioDTO) {

        return UsuarioMapper.INSTANCE.toUsuarioDTO(
                usuarioUseCase.salvar(
                        UsuarioMapper.INSTANCE.toUsuarioEntity(usuarioDTO)));
    }

    @GetMapping("/{id}")
    public UsuarioDTO buscarPorId(@PathVariable Long id) {
        UsuarioDomain usuarioDomain = usuarioUseCase.buscarPorId(id);
        return UsuarioMapper.INSTANCE.toUsuarioDTO(usuarioDomain);
    }


    @GetMapping
    public List<UsuarioDTO> buscarTodos() {
        return usuarioUseCase.buscarTodos()
                .stream()
                .map(UsuarioMapper.INSTANCE::toUsuarioDTO)
                .toList();
    }

    @GetMapping("/cpf")
    public UsuarioDTO buscarPorCPF(@RequestParam("cpf") String cpf) {
        UsuarioDomain usuarioDomain = usuarioUseCase.buscarPorCPF(cpf);
        return UsuarioMapper.INSTANCE.toUsuarioDTO(usuarioDomain);
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id) {

        usuarioUseCase.apagar(id);
    }

}
