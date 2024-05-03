package br.com.fiap.fiapfood.domain.usecase;

import br.com.fiap.fiapfood.domain.entity.ReservaDomain;
import br.com.fiap.fiapfood.domain.entity.RestauranteDomain;
import br.com.fiap.fiapfood.domain.entity.UsuarioDomain;

import java.time.LocalDate;
import java.util.List;

public interface ReservaUsecase {

    public ReservaDomain salvar(ReservaDomain reserva);

    public ReservaDomain buscarPorId(Long id);

    public void apagar(Long id);
    
    public List<ReservaDomain> buscarPorUsuario(UsuarioDomain usuario);

    public List<ReservaDomain> buscarPorDataReserva(LocalDate dataReserva);

    public List<ReservaDomain> buscarPorRestaurante(RestauranteDomain restaurante);

}
