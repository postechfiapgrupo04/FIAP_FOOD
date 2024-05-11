package br.com.fiap.fiapfood.entrypoint.api.mapper;

import br.com.fiap.fiapfood.core.entity.EnderecoDomain;
import br.com.fiap.fiapfood.dataprovider.persistence.model.Endereco;
import br.com.fiap.fiapfood.entrypoint.api.dto.EnderecoDTO;
import org.springframework.stereotype.Service;

@Service
public class EnderecoMapper {

    public static EnderecoDTO toEnderecoDTOFromDomain(EnderecoDomain enderecoDomain) {
        if (enderecoDomain == null) {
            return null;
        }

        return new EnderecoDTO(
                enderecoDomain.getId(),
                enderecoDomain.getLogradouro(),
                enderecoDomain.getNumero(),
                enderecoDomain.getComplemento(),
                enderecoDomain.getBairro(),
                enderecoDomain.getCidade(),
                enderecoDomain.getEstado(),
                enderecoDomain.getCep()
        );

    }

    public static EnderecoDomain toEnderecoDomainFromDTO(EnderecoDTO enderecoDTO) {
        if (enderecoDTO == null) {
            return null;
        }

        return new EnderecoDomain(
                enderecoDTO.id(),
                enderecoDTO.logradouro(),
                enderecoDTO.numero(),
                enderecoDTO.complemento(),
                enderecoDTO.bairro(),
                enderecoDTO.cidade(),
                enderecoDTO.estado(),
                enderecoDTO.cep()
        );
    }

    public static EnderecoDomain toEnderecoDomainFromModel(Endereco endereco) {
        if (endereco == null) {
            return null;
        }

        return new EnderecoDomain(
                endereco.getId(),
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getCep()
        );
    }

    public static Endereco toEnderecoModelFromDomain(EnderecoDomain enderecoDomain) {
        if (enderecoDomain == null) {
            return null;
        }

        return new Endereco(
                enderecoDomain.getId(),
                enderecoDomain.getLogradouro(),
                enderecoDomain.getNumero(),
                enderecoDomain.getComplemento(),
                enderecoDomain.getBairro(),
                enderecoDomain.getCidade(),
                enderecoDomain.getEstado(),
                enderecoDomain.getCep()
        );
    }
}
