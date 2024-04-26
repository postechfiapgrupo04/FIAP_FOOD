package br.com.fiap.fiapfood.presentation.controller;

import br.com.fiap.fiapfood.application.usecase.UsuarioUsecase;
import br.com.fiap.fiapfood.domain.model.UsuarioEntity;
import br.com.fiap.fiapfood.presentation.dto.UsuarioDTO;
import br.com.fiap.fiapfood.presentation.mapper.UsuarioMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioUsecase usuarioUseCase;

    public UsuarioController(UsuarioUsecase usuarioUseCase) {
        this.usuarioUseCase = usuarioUseCase;
    }

    @PostMapping
    public UsuarioDTO salvar(@RequestBody UsuarioDTO usuarioDTO) {

        UsuarioEntity usuarioEntity1 = UsuarioMapper.INSTANCE.toUsuarioEntity(usuarioDTO);

        UsuarioEntity usuarioEntity = usuarioUseCase.salvar(UsuarioMapper.INSTANCE.toUsuarioEntity(usuarioDTO));
        UsuarioDTO usuarioDTO1 = UsuarioMapper.INSTANCE.toUsuarioDTO(usuarioEntity);
        return UsuarioMapper.INSTANCE.toUsuarioDTO(usuarioEntity);
    }

    @GetMapping("/{id}")
    public UsuarioDTO buscarPorId(@PathVariable String id) {
        UsuarioEntity usuarioEntity = usuarioUseCase.buscarPorId(id);
        return UsuarioMapper.INSTANCE.toUsuarioDTO(usuarioEntity);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        usuarioUseCase.deletar(id);
    }

}
