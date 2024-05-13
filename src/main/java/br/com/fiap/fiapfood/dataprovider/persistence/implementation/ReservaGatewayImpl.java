package br.com.fiap.fiapfood.dataprovider.persistence.implementation;

import br.com.fiap.fiapfood.core.entity.ReservaDomain;
import br.com.fiap.fiapfood.core.entity.RestauranteDomain;
import br.com.fiap.fiapfood.core.entity.UsuarioDomain;
import br.com.fiap.fiapfood.core.gateways.ReservaRepository;
import br.com.fiap.fiapfood.dataprovider.persistence.model.Reserva;
import br.com.fiap.fiapfood.dataprovider.persistence.repository.ReservaJPARepository;
import br.com.fiap.fiapfood.entrypoint.api.mapper.ReservaMapper;
import br.com.fiap.fiapfood.entrypoint.api.mapper.RestauranteMapper;
import br.com.fiap.fiapfood.entrypoint.api.mapper.UsuarioMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ReservaGatewayImpl implements ReservaRepository {

    private final ReservaJPARepository reservaJPARepository;

    private final UsuarioMapper usuarioMapper;

    private final ReservaMapper reservaMapper;

    private final ModelMapper modelMapper;


    @Override
    public ReservaDomain salvar(ReservaDomain reserva) {
        Reserva reservaEntity = modelMapper.map(reserva, Reserva.class);
        Reserva reservaEntitySaved = reservaJPARepository.save(reservaEntity);
        return modelMapper.map(reservaEntitySaved, ReservaDomain.class);
    }

    @Override
    public ReservaDomain buscarPorId(Long id) {
        Optional<Reserva> reservaEntity = reservaJPARepository.findById(id);
        if (reservaEntity.isPresent()) {
            return reservaMapper.toReservaDomain(reservaEntity.get());
        }
        throw new RuntimeException("Reserva não encontrada");
    }

    @Override
    public void apagar(Long id) {
        Optional<Reserva> reservaEntity = reservaJPARepository.findById(id);
        if (reservaEntity.isPresent()) {
            reservaJPARepository.delete(reservaEntity.get());
        }
        throw new RuntimeException("Reserva não encontrada");
    }

    @Override
    public List<ReservaDomain> buscarPorUsuario(UsuarioDomain usuario) {
        Optional<List<Reserva>> reservaEntities = reservaJPARepository.findByUsuario(UsuarioMapper.toUsuarioModelFromDomain(usuario));
        if (reservaEntities.isPresent()) {
            return reservaEntities.get().stream().map(reservaMapper::toReservaDomain).toList();
        }
        throw new RuntimeException("Reservas não encontradas");
    }

    @Override
    public List<ReservaDomain> buscarPorDataReserva(LocalDate dataReserva) {
        Optional<List<Reserva>> reservaEntities = reservaJPARepository.findByDataReserva(dataReserva);
        if (reservaEntities.isPresent()) {
            return reservaEntities.get().stream().map(reservaMapper::toReservaDomain).toList();
        }
        throw new RuntimeException("Reservas não encontradas");
    }

    @Override
    public List<ReservaDomain> buscarPorRestaurante(RestauranteDomain restaurante) {
        Optional<List<Reserva>> reservaEntities = reservaJPARepository.findByRestaurante(RestauranteMapper.toRestauranteModelFromDomain(restaurante));
        if (reservaEntities.isPresent()) {
            return reservaEntities.get().stream().map(reservaMapper::toReservaDomain).toList();
        }
        throw new RuntimeException("Reservas não encontradas");
    }

    @Override
    public List<ReservaDomain> buscarTodasReservas() {
        return reservaJPARepository.findAll()
                .stream()
                .map(reserva -> modelMapper.map(reserva, ReservaDomain.class))
                .collect(Collectors.toList());
    }
}
