package br.com.fiap.fiapfood.domain.usecase;

import br.com.fiap.fiapfood.domain.entity.ReservaDomain;

import java.time.LocalDate;

public interface ReservaUsecase {

    public ReservaDomain salvar(ReservaDomain reserva);

    public ReservaDomain buscarPorId(Long id);

    public void apagar(Long id);
    
    public ReservaDomain buscarPorIdUsuario(String nome);

    public ReservaDomain buscarPorDataReserva(LocalDate dataReserva);

    ReservaDomain buscarPorNome(String nome);
}
