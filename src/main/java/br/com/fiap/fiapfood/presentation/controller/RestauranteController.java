package br.com.fiap.fiapfood.presentation.controller;

import br.com.fiap.fiapfood.domain.usecase.RestauranteUsecase;
import br.com.fiap.fiapfood.presentation.dto.RestauranteDTO;
import br.com.fiap.fiapfood.presentation.mapper.RestauranteMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurante")
@AllArgsConstructor
public class RestauranteController {

    private final RestauranteUsecase restauranteUseCase;

    @PostMapping
    public RestauranteDTO salvar(@RequestBody RestauranteDTO restauranteDTO) {
        return RestauranteMapper.INSTANCE.toRestauranteDTO(
                restauranteUseCase.salvar(
                        RestauranteMapper.INSTANCE.toRestauranteDomainFromDTO(restauranteDTO)));
    }

    @GetMapping("/{id}")
    public RestauranteDTO buscarPorId(@PathVariable Long id) {
        return RestauranteMapper.INSTANCE.toRestauranteDTO(restauranteUseCase.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id) {
        restauranteUseCase.apagar(id);
    }

    @GetMapping("/nome/{nome}")
    public RestauranteDTO buscarPorNome(@PathVariable String nome) {
        return RestauranteMapper.INSTANCE.toRestauranteDTO(restauranteUseCase.buscarPorNome(nome));
    }

    @GetMapping("/endereco/{endereco}")
    public RestauranteDTO buscarPorEndereco(@PathVariable String endereco) {
        return RestauranteMapper.INSTANCE.toRestauranteDTO(restauranteUseCase.buscarPorEndereco(endereco));
    }

    @GetMapping("/cozinha/{cozinha}")
    public RestauranteDTO buscarPorCozinha(@PathVariable String cozinha) {
        return RestauranteMapper.INSTANCE.toRestauranteDTO(restauranteUseCase.buscarPorTipoCozinha(cozinha));
    }

}
