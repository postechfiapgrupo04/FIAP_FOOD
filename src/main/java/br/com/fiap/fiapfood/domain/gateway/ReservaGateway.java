package br.com.fiap.fiapfood.domain.gateway;

import br.com.fiap.fiapfood.domain.entity.ReservaDomain;

public interface ReservaGateway {

    public ReservaDomain salvar(ReservaDomain reserva);

    public ReservaDomain buscarPorId(Long id);

    public void apagar(Long id);

    public ReservaDomain buscarPorNome(String nome);
}
