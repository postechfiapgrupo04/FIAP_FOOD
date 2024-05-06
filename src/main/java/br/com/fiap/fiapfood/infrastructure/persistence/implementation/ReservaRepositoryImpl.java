package br.com.fiap.fiapfood.infrastructure.persistence.implementation;

import br.com.fiap.fiapfood.core.domain.entity.ReservaDomain;
import br.com.fiap.fiapfood.core.domain.entity.RestauranteDomain;
import br.com.fiap.fiapfood.core.domain.entity.UsuarioDomain;
import br.com.fiap.fiapfood.core.domain.repositories.ReservaRepository;
import br.com.fiap.fiapfood.infrastructure.persistence.model.Reserva;
import br.com.fiap.fiapfood.infrastructure.persistence.repository.ReservaJPARepository;
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
public class ReservaRepositoryImpl implements ReservaRepository {

    private final ReservaJPARepository reservaJPARepository;


    @Override
    public ReservaDomain salvar(ReservaDomain reserva) {
        return ReservaMapper.INSTANCE.toReservaDomain(
                reservaJPARepository.save(ReservaMapper.INSTANCE.toReservaEntity(reserva)));
    }

    @Override
    public ReservaDomain buscarPorId(Long id) {
        Optional<Reserva> reservaEntity = reservaJPARepository.findById(id);
        if (reservaEntity.isPresent()) {
            return ReservaMapper.INSTANCE.toReservaDomain(reservaEntity.get());
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
        Optional<List<Reserva>> reservaEntities = reservaJPARepository.findByUsuario(UsuarioMapper.INSTANCE.toUsuarioModelFromDomain(usuario));
        if (reservaEntities.isPresent()) {
            return reservaEntities.get().stream().map(ReservaMapper.INSTANCE::toReservaDomain).toList();
        }
        throw new RuntimeException("Reservas não encontradas");
    }

    @Override
    public List<ReservaDomain> buscarPorDataReserva(LocalDate dataReserva) {
        Optional<List<Reserva>> reservaEntities = reservaJPARepository.findByDataReserva(dataReserva);
        if (reservaEntities.isPresent()) {
            return reservaEntities.get().stream().map(ReservaMapper.INSTANCE::toReservaDomain).toList();
        }
        throw new RuntimeException("Reservas não encontradas");
    }

    @Override
    public List<ReservaDomain> buscarPorRestaurante(RestauranteDomain restaurante) {
        Optional<List<Reserva>> reservaEntities = reservaJPARepository.findByRestaurante(RestauranteMapper.INSTANCE.toRestauranteEntity(restaurante));
        if (reservaEntities.isPresent()) {
            return reservaEntities.get().stream().map(ReservaMapper.INSTANCE::toReservaDomain).toList();
        }
        throw new RuntimeException("Reservas não encontradas");
    }
}
