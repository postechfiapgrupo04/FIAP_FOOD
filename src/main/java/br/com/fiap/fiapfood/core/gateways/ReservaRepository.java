package br.com.fiap.fiapfood.core.gateways;

import br.com.fiap.fiapfood.core.entity.ReservaDomain;
import br.com.fiap.fiapfood.core.entity.RestauranteDomain;
import br.com.fiap.fiapfood.core.entity.UsuarioDomain;

import java.time.LocalDate;
import java.util.List;

public interface ReservaRepository {

    public ReservaDomain salvar(ReservaDomain reserva);

    public ReservaDomain buscarPorId(Long id);

    public void apagar(Long id);

    public List<ReservaDomain> buscarPorUsuario(UsuarioDomain usuario);

    public List<ReservaDomain> buscarPorDataReserva(LocalDate dataReserva);

    public List<ReservaDomain> buscarPorRestaurante(RestauranteDomain restaurante);

    List<ReservaDomain> buscarTodasReservas();
}
