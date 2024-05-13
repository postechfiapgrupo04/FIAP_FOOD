package br.com.fiap.fiapfood.entrypoint.api.mapper;

import br.com.fiap.fiapfood.core.entity.AvaliacaoDomain;
import br.com.fiap.fiapfood.dataprovider.persistence.model.Avaliacao;
import br.com.fiap.fiapfood.entrypoint.api.dto.AvaliacaoDTO;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoMapper {
    public static AvaliacaoDTO toAvaliacaoDTOFromDomain(AvaliacaoDomain avaliacaoDomain) {
        if (avaliacaoDomain == null) {
            return null;
        }

        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO(
                avaliacaoDomain.getId(),
                RestauranteMapper.toRestauranteDTOFromDomain(avaliacaoDomain.getIdRestaurante()),
                UsuarioMapper.toUsuarioDTOFromDomain(avaliacaoDomain.getIdUsuario()),
                avaliacaoDomain.getEstrelas(),
                avaliacaoDomain.getDescricao()
        );

        return avaliacaoDTO;
    }

    public static AvaliacaoDomain toAvaliacaoDomainFromDTO(AvaliacaoDTO avaliacaoDTO) {
        if (avaliacaoDTO == null) {
            return null;
        }

        AvaliacaoDomain avaliacaoDomain = new AvaliacaoDomain(
                avaliacaoDTO.getId(),
                RestauranteMapper.toRestauranteDomainFromDTO(avaliacaoDTO.getRestaurante()),
                UsuarioMapper.toUsuarioDomainFromDTO(avaliacaoDTO.getUsuario()),
                avaliacaoDTO.getEstrelas(),
                avaliacaoDTO.getDescricao()
        );

        return avaliacaoDomain;
    }

    public static AvaliacaoDomain toAvaliacaoDomainFromModel(Avaliacao avaliacao) {
        if (avaliacao == null) {
            return null;
        }

        AvaliacaoDomain avaliacaoDomain = new AvaliacaoDomain(
                avaliacao.getId(),
                RestauranteMapper.toRestauranteDomainFromModel(avaliacao.getRestaurante()),
                UsuarioMapper.toUsuarioDomainFromModel(avaliacao.getUsuario()),
                avaliacao.getEstrelas(),
                avaliacao.getDescricao()
        );

        return avaliacaoDomain;
    }

    public static Avaliacao toAvaliacaoModelFromDomain(AvaliacaoDomain avaliacaoDomain) {
        if (avaliacaoDomain == null) {
            return null;
        }

        Avaliacao avaliacao = new Avaliacao(
                avaliacaoDomain.getId(),
                RestauranteMapper.toRestauranteModelFromDomain(avaliacaoDomain.getIdRestaurante()),
                UsuarioMapper.toUsuarioModelFromDomain(avaliacaoDomain.getIdUsuario()),
                avaliacaoDomain.getEstrelas(),
                avaliacaoDomain.getDescricao()
        );

        return avaliacao;
    }
}
