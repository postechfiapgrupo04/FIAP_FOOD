package br.com.fiap.fiapfood.presentation.dto;

import java.util.List;

public record UsuarioDTO(
        Long id,
        String nome,
        String email,
        String cpf,
        List<ReservaDTO> reservas
) {
}
