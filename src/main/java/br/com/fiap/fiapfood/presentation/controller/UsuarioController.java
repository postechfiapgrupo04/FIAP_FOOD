package br.com.fiap.fiapfood.presentation.controller;

import br.com.fiap.fiapfood.domain.usecase.UsuarioUsecase;
import br.com.fiap.fiapfood.domain.model.UsuarioDomain;
import br.com.fiap.fiapfood.presentation.dto.UsuarioDTO;
import br.com.fiap.fiapfood.presentation.mapper.UsuarioMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioUsecase usuarioUseCase;

    public UsuarioController(UsuarioUsecase usuarioUseCase) {
        this.usuarioUseCase = usuarioUseCase;
    }

    @PostMapping
    public UsuarioDTO salvar(@RequestBody UsuarioDTO usuarioDTO) {

        UsuarioDomain usuarioDomain1 = UsuarioMapper.INSTANCE.toUsuarioEntity(usuarioDTO);

        UsuarioDomain usuarioDomain = usuarioUseCase.salvar(UsuarioMapper.INSTANCE.toUsuarioEntity(usuarioDTO));
        UsuarioDTO usuarioDTO1 = UsuarioMapper.INSTANCE.toUsuarioDTO(usuarioDomain);
        return UsuarioMapper.INSTANCE.toUsuarioDTO(usuarioDomain);
    }

    @GetMapping("/{id}")
    public UsuarioDTO buscarPorId(@PathVariable String id) {
        UsuarioDomain usuarioDomain = usuarioUseCase.buscarPorId(id);
        return UsuarioMapper.INSTANCE.toUsuarioDTO(usuarioDomain);
    }


    @GetMapping
    public List<UsuarioDTO> findAll() {
        return usuarioUseCase.findAll()
                .stream()
                .map(UsuarioMapper.INSTANCE::toUsuarioDTO)
                .toList();
    }

    @GetMapping("/cpf")
    public UsuarioDTO findByCpf(@RequestParam("cpf") String cpf){
        UsuarioDomain usuarioDomain = usuarioUseCase.findByCpf(cpf);
        return UsuarioMapper.INSTANCE.toUsuarioDTO(usuarioDomain);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        usuarioUseCase.deletar(id);
    }

}
