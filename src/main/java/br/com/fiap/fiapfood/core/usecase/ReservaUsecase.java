package br.com.fiap.fiapfood.core.usecase;

import br.com.fiap.fiapfood.core.entity.ReservaDomain;

import java.time.LocalDate;
import java.util.List;

public interface ReservaUsecase {

    public ReservaDomain salvar(ReservaDomain reserva);

    public ReservaDomain buscarPorId(Long id);

    public void apagar(Long id);
    
    public List<ReservaDomain> buscarPorUsuario(Long usuarioId);

    public List<ReservaDomain> buscarPorDataReserva(LocalDate dataReserva);

    public List<ReservaDomain> buscarPorRestaurante(Long restauranteId);

}
