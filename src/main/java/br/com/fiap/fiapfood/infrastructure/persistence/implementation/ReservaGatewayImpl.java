package br.com.fiap.fiapfood.infrastructure.persistence.implementation;

import br.com.fiap.fiapfood.domain.entity.ReservaDomain;
import br.com.fiap.fiapfood.domain.gateway.ReservaGateway;
import br.com.fiap.fiapfood.infrastructure.persistence.entity.ReservaEntity;
import br.com.fiap.fiapfood.infrastructure.persistence.repository.ReservaRepository;
import br.com.fiap.fiapfood.presentation.mapper.ReservaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ReservaGatewayImpl implements ReservaGateway {

    private final ReservaRepository reservaRepository;

    @Override
    public ReservaDomain salvar(ReservaDomain reserva) {
        return ReservaMapper.INSTANCE.toReservaDomain(
                reservaRepository.save(
                        ReservaMapper.INSTANCE.toReservaEntity(reserva)));
    }

    @Override
    public ReservaDomain buscarPorId(Long id) {
        Optional<ReservaEntity> reservaEntity = reservaRepository.findById(id);
        if (reservaEntity.isPresent()) {
            return ReservaMapper.INSTANCE.toReservaDomain(reservaEntity.get());
        }
        throw new RuntimeException("Reserva não encontrado");
    }

    @Override
    public void apagar(Long id) {
        Optional<ReservaEntity> reservaEntity = reservaRepository.findById(id);
        if (reservaEntity.isPresent()) {
            reservaRepository.delete(reservaEntity.get());
        }
        throw new RuntimeException("Reserva não encontrado");
    }

    @Override
    public ReservaDomain buscarPorNome(String nome) {
        Optional<ReservaEntity> reservaEntity = reservaRepository.findByNomeIsLike(nome);
        if (reservaEntity.isPresent()) {
            return ReservaMapper.INSTANCE.toReservaDomain(reservaEntity.get());
        }
        throw new RuntimeException("Reserva não encontrado");
    }
}
