package br.com.fiap.fiapfood.entrypoint.api.dto;

public record EnderecoDTO(
        Long id,
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep
) {
}
