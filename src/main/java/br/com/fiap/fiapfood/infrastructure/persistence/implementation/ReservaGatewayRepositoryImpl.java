package br.com.fiap.fiapfood.infrastructure.persistence.implementation;

import br.com.fiap.fiapfood.domain.entity.ReservaDomain;
import br.com.fiap.fiapfood.domain.entity.RestauranteDomain;
import br.com.fiap.fiapfood.domain.entity.UsuarioDomain;
import br.com.fiap.fiapfood.domain.gatewayrepository.ReservaGatewayRepository;
import br.com.fiap.fiapfood.infrastructure.persistence.dbmappers.DBMapperReserva;
import br.com.fiap.fiapfood.infrastructure.persistence.repository.ReservaRepository;
import br.com.fiap.fiapfood.presentation.mapper.ReservaMapper;
import br.com.fiap.fiapfood.presentation.mapper.RestauranteMapper;
import br.com.fiap.fiapfood.presentation.mapper.UsuarioMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class ReservaGatewayRepositoryImpl implements ReservaGatewayRepository {

    private final ReservaRepository reservaRepository;


    @Override
    public ReservaDomain salvar(ReservaDomain reserva) {
        return ReservaMapper.INSTANCE.toReservaDomain(
                reservaRepository.save(ReservaMapper.INSTANCE.toReservaEntity(reserva)));
    }

    @Override
    public ReservaDomain buscarPorId(Long id) {
        Optional<DBMapperReserva> reservaEntity = reservaRepository.findById(id);
        if (reservaEntity.isPresent()) {
            return ReservaMapper.INSTANCE.toReservaDomain(reservaEntity.get());
        }
        throw new RuntimeException("Reserva não encontrada");
    }

    @Override
    public void apagar(Long id) {
        Optional<DBMapperReserva> reservaEntity = reservaRepository.findById(id);
        if (reservaEntity.isPresent()) {
            reservaRepository.delete(reservaEntity.get());
        }
        throw new RuntimeException("Reserva não encontrada");
    }

    @Override
    public List<ReservaDomain> buscarPorUsuario(UsuarioDomain usuario) {
        Optional<List<DBMapperReserva>> reservaEntities = reservaRepository.findByUsuario(UsuarioMapper.INSTANCE.toUsuarioEntity(usuario));
        if (reservaEntities.isPresent()) {
            return reservaEntities.get().stream().map(ReservaMapper.INSTANCE::toReservaDomain).toList();
        }
        throw new RuntimeException("Reservas não encontradas");
    }

    @Override
    public List<ReservaDomain> buscarPorDataReserva(LocalDate dataReserva) {
        Optional<List<DBMapperReserva>> reservaEntities = reservaRepository.findByDataReserva(dataReserva);
        if (reservaEntities.isPresent()) {
            return reservaEntities.get().stream().map(ReservaMapper.INSTANCE::toReservaDomain).toList();
        }
        throw new RuntimeException("Reservas não encontradas");
    }

    @Override
    public List<ReservaDomain> buscarPorRestaurante(RestauranteDomain restaurante) {
        Optional<List<DBMapperReserva>> reservaEntities = reservaRepository.findByRestaurante(RestauranteMapper.INSTANCE.toRestauranteEntity(restaurante));
        if (reservaEntities.isPresent()) {
            return reservaEntities.get().stream().map(ReservaMapper.INSTANCE::toReservaDomain).toList();
        }
        throw new RuntimeException("Reservas não encontradas");
    }
}
