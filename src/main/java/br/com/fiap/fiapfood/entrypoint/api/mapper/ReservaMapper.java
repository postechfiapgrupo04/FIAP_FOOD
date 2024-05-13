package br.com.fiap.fiapfood.entrypoint.api.mapper;

import br.com.fiap.fiapfood.core.entity.EnderecoDomain;
import br.com.fiap.fiapfood.core.entity.ReservaDomain;
import br.com.fiap.fiapfood.core.entity.RestauranteDomain;
import br.com.fiap.fiapfood.core.entity.UsuarioDomain;
import br.com.fiap.fiapfood.dataprovider.persistence.model.Endereco;
import br.com.fiap.fiapfood.dataprovider.persistence.model.Reserva;
import br.com.fiap.fiapfood.dataprovider.persistence.model.Restaurante;
import br.com.fiap.fiapfood.dataprovider.persistence.model.Usuario;
import br.com.fiap.fiapfood.entrypoint.api.dto.ReservaDTO;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fiapfood.entrypoint.api.dto.ReservaRequestDTO;
import br.com.fiap.fiapfood.entrypoint.api.dto.RestauranteDTO;
import org.springframework.stereotype.Component;

@Component
public class ReservaMapper {

    public Reserva toReserva(ReservaDomain reservaDomain) {
        if (reservaDomain == null) {
            return null;
        }

        Reserva reserva = new Reserva();

        reserva.setId(reservaDomain.getId());
        reserva.setDataReserva(reservaDomain.getDataReserva());
        reserva.setRestaurante(restauranteDomainToRestaurante(reservaDomain.getRestaurante()));
        reserva.setUsuario(usuarioDomainToUsuario(reservaDomain.getUsuario()));
        reserva.setQuantidadePessoas(reservaDomain.getQuantidadePessoas());

        return reserva;
    }

    public ReservaDomain toReservaDomain(Reserva Reserva) {
        if (Reserva == null) {
            return null;
        }

        ReservaDomain.ReservaDomainBuilder reservaDomain = ReservaDomain.builder();

        reservaDomain.id(Reserva.getId());
        reservaDomain.dataReserva(Reserva.getDataReserva());
        reservaDomain.restaurante(restauranteToRestauranteDomain(Reserva.getRestaurante()));
        reservaDomain.usuario(usuarioToUsuarioDomain(Reserva.getUsuario()));
        reservaDomain.quantidadePessoas(Reserva.getQuantidadePessoas());

        return reservaDomain.build();
    }

    public ReservaDomain toReservaDomainFromDTO(ReservaDTO reservaDTO) {
        if (reservaDTO == null) {
            return null;
        }

        ReservaDomain.ReservaDomainBuilder reservaDomain = ReservaDomain.builder();

        return reservaDomain.build();
    }

    protected Endereco enderecoDomainToEndereco(EnderecoDomain enderecoDomain) {
        if (enderecoDomain == null) {
            return null;
        }

        Endereco endereco = new Endereco();

        endereco.setId(enderecoDomain.getId());
        endereco.setLogradouro(enderecoDomain.getLogradouro());
        endereco.setNumero(enderecoDomain.getNumero());
        endereco.setComplemento(enderecoDomain.getComplemento());
        endereco.setBairro(enderecoDomain.getBairro());
        endereco.setCidade(enderecoDomain.getCidade());
        endereco.setEstado(enderecoDomain.getEstado());
        endereco.setCep(enderecoDomain.getCep());

        return endereco;
    }

    protected Restaurante restauranteDomainToRestaurante(RestauranteDomain restauranteDomain) {
        if (restauranteDomain == null) {
            return null;
        }

        Restaurante restaurante = new Restaurante();

        restaurante.setId(restauranteDomain.getId());
        restaurante.setNome(restauranteDomain.getNome());
        restaurante.setEndereco(enderecoDomainToEndereco(restauranteDomain.getEndereco()));
        restaurante.setTipoCozinha(restauranteDomain.getTipoCozinha());
        restaurante.setHorarioFuncionamentoAbertura(restauranteDomain.getHorarioFuncionamentoAbertura());
        restaurante.setHorarioFuncionamentoFechamento(restauranteDomain.getHorarioFuncionamentoFechamento());
        restaurante.setCapacidade(restauranteDomain.getCapacidade());

        return restaurante;
    }

    protected List<Reserva> reservaDomainListToReservaList(List<ReservaDomain> list) {
        if (list == null) {
            return null;
        }

        List<Reserva> list1 = new ArrayList<Reserva>(list.size());
        for (ReservaDomain reservaDomain : list) {
            list1.add(toReserva(reservaDomain));
        }

        return list1;
    }

    protected Usuario usuarioDomainToUsuario(UsuarioDomain usuarioDomain) {
        if (usuarioDomain == null) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId(usuarioDomain.getId());
        usuario.setNome(usuarioDomain.getNome());
        usuario.setEmail(usuarioDomain.getEmail());
        usuario.setCpf(usuarioDomain.getCpf());

        return usuario;
    }

    protected EnderecoDomain enderecoToEnderecoDomain(Endereco endereco) {
        if (endereco == null) {
            return null;
        }

        EnderecoDomain enderecoDomain = new EnderecoDomain();

        enderecoDomain.setId(endereco.getId());
        enderecoDomain.setLogradouro(endereco.getLogradouro());
        enderecoDomain.setNumero(endereco.getNumero());
        enderecoDomain.setComplemento(endereco.getComplemento());
        enderecoDomain.setBairro(endereco.getBairro());
        enderecoDomain.setCidade(endereco.getCidade());
        enderecoDomain.setEstado(endereco.getEstado());
        enderecoDomain.setCep(endereco.getCep());

        return enderecoDomain;
    }

    protected RestauranteDomain restauranteToRestauranteDomain(Restaurante restaurante) {
        if (restaurante == null) {
            return null;
        }

        RestauranteDomain restauranteDomain = new RestauranteDomain();

        restauranteDomain.setId(restaurante.getId());
        restauranteDomain.setNome(restaurante.getNome());
        restauranteDomain.setEndereco(enderecoToEnderecoDomain(restaurante.getEndereco()));
        restauranteDomain.setTipoCozinha(restaurante.getTipoCozinha());
        restauranteDomain.setHorarioFuncionamentoAbertura(restaurante.getHorarioFuncionamentoAbertura());
        restauranteDomain.setHorarioFuncionamentoFechamento(restaurante.getHorarioFuncionamentoFechamento());
        restauranteDomain.setCapacidade(restaurante.getCapacidade());

        return restauranteDomain;
    }

    protected List<ReservaDomain> reservaListToReservaDomainList(List<Reserva> list) {
        if (list == null) {
            return null;
        }

        List<ReservaDomain> list1 = new ArrayList<ReservaDomain>(list.size());
        for (Reserva reserva : list) {
            list1.add(toReservaDomain(reserva));
        }

        return list1;
    }

    protected UsuarioDomain usuarioToUsuarioDomain(Usuario usuario) {
        if (usuario == null) {
            return null;
        }

        UsuarioDomain usuarioDomain = new UsuarioDomain();

        usuarioDomain.setId(usuario.getId());
        usuarioDomain.setNome(usuario.getNome());
        usuarioDomain.setEmail(usuario.getEmail());
        usuarioDomain.setCpf(usuario.getCpf());

        return usuarioDomain;
    }
    public ReservaDomain toReservaDomainFromRequestDTO(ReservaRequestDTO reservaRequestDTO) {
        ReservaDomain reserva = new ReservaDomain();
        RestauranteDomain restauranteDomain = new RestauranteDomain();
        restauranteDomain.setId(reservaRequestDTO.restauranteId());

        UsuarioDomain usuarioDomain = new UsuarioDomain();
        usuarioDomain.setId(reservaRequestDTO.usuarioId());

        reserva.setDataReserva(reservaRequestDTO.dataReserva());
        reserva.setRestaurante(restauranteDomain);
        reserva.setUsuario(usuarioDomain);
        reserva.setQuantidadePessoas(reservaRequestDTO.quantidadePessoas());

        return reserva;
    }

    public ReservaDTO toReservaDTOFromReservaDomain(ReservaDomain reservaDomain) {
        ReservaDTO reservaDTO = new ReservaDTO();

        reservaDTO.setId(reservaDomain.getId());
        reservaDTO.setDataReserva(reservaDomain.getDataReserva());
        reservaDTO.setRestaurante(RestauranteMapper.toRestauranteDTOFromDomain(reservaDomain.getRestaurante()));
        reservaDTO.setUsuario(UsuarioMapper.toUsuarioDTOFromDomain(reservaDomain.getUsuario()));
        reservaDTO.setQuantidadePessoas(reservaDomain.getQuantidadePessoas());

        return reservaDTO;
    }
}
