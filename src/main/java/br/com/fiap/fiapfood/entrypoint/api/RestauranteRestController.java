package br.com.fiap.fiapfood.entrypoint.api;

import br.com.fiap.fiapfood.core.enums.TipoCozinha;
import br.com.fiap.fiapfood.entrypoint.api.dto.RestauranteDTO;
import br.com.fiap.fiapfood.entrypoint.facade.RestauranteFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurante")
@AllArgsConstructor
public class RestauranteRestController {

    private final RestauranteFacade restauranteFacade;

    @PostMapping
    public RestauranteDTO salvar(@RequestBody RestauranteDTO restauranteDTO) {
        return restauranteFacade.salvar(restauranteDTO);
    }

    @GetMapping("/{id}")
    public RestauranteDTO buscarPorId(@PathVariable Long id) {
        return restauranteFacade.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id) {

        restauranteFacade.apagar(id);
    }

    @GetMapping("/nome/{nome}")
    public RestauranteDTO buscarPorNome(@PathVariable String nome) {
        return restauranteFacade.buscarPorNome(nome);
    }

    @GetMapping("/endereco/{endereco}")
    public RestauranteDTO buscarPorEndereco(@PathVariable String endereco) {
        return restauranteFacade.buscarPorEndereco(endereco);
    }

    @GetMapping("/cozinha/{cozinha}")
    public RestauranteDTO buscarPorCozinha(@PathVariable TipoCozinha cozinha) {
        return restauranteFacade.buscarPorTipoCozinha(cozinha);
    }

}
