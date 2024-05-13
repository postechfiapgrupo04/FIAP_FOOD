package br.com.fiap.fiapfood.entrypoint.facade.implementation;

import br.com.fiap.fiapfood.core.usecase.avaliacao.*;
import br.com.fiap.fiapfood.entrypoint.api.dto.AvaliacaoDTO;
import br.com.fiap.fiapfood.entrypoint.api.mapper.AvaliacaoMapper;
import br.com.fiap.fiapfood.entrypoint.facade.AvaliacaoFacade;
import br.com.fiap.fiapfood.core.entity.AvaliacaoDomain;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AvaliacaoFacadeImp implements AvaliacaoFacade {

    private final SalvarAvaliacao salvarAvaliacao;
    private final BuscarAvaliacaoPorID buscarAvaliacaoPorID;
    private final BuscarTodasAvaliacaos buscarTodasAvaliacaos;
    private final BuscarAvaliacaoPorNomeRestaurante buscarAvaliacaoPorNomeRestaurante;
    private final ApagarAvaliacao apagarAvaliacao;

    private final AvaliacaoMapper avaliacaoMapper;

    public AvaliacaoFacadeImp(
            SalvarAvaliacao salvarAvaliacao,
            BuscarAvaliacaoPorID buscarAvaliacaoPorID,
            BuscarTodasAvaliacaos buscarTodasAvaliacaos,
            BuscarAvaliacaoPorNomeRestaurante buscarAvaliacaoPorNomeRestaurante,
            ApagarAvaliacao apagarAvaliacao,
            AvaliacaoMapper avaliacaoMapper
    ) {
        this.salvarAvaliacao = salvarAvaliacao;
        this.buscarAvaliacaoPorID = buscarAvaliacaoPorID;
        this.buscarTodasAvaliacaos = buscarTodasAvaliacaos;
        this.buscarAvaliacaoPorNomeRestaurante = buscarAvaliacaoPorNomeRestaurante;
        this.apagarAvaliacao = apagarAvaliacao;
        this.avaliacaoMapper = avaliacaoMapper;
    }

    @Override
    public AvaliacaoDTO salvar(AvaliacaoDTO avaliacaoDTO) {
        AvaliacaoDomain avaliacaoDomain = avaliacaoMapper.toAvaliacaoDomainFromDTO(avaliacaoDTO);
        avaliacaoDomain = salvarAvaliacao.call(avaliacaoDomain);
        return avaliacaoMapper.toAvaliacaoDTOFromDomain(avaliacaoDomain);
    }

    @Override
    public AvaliacaoDTO buscarPorId(Long id) {
        AvaliacaoDomain AvaliacaoDomain = buscarAvaliacaoPorID.call(id);
        return avaliacaoMapper.toAvaliacaoDTOFromDomain(AvaliacaoDomain);
    }

    @Override
    public List<AvaliacaoDTO> buscarTodos() {
        return buscarTodasAvaliacaos.call().stream()
                .map(AvaliacaoDomain -> avaliacaoMapper.toAvaliacaoDTOFromDomain(AvaliacaoDomain))
                .collect(Collectors.toList());
    }

    @Override
    public void apagar(Long id) {
        apagarAvaliacao.call(id);
    }

    @Override
    public AvaliacaoDTO buscarPorNomeRestaurante(String nomeRestaurante) {
        AvaliacaoDomain AvaliacaoDomain = buscarAvaliacaoPorNomeRestaurante.call(nomeRestaurante);
        return avaliacaoMapper.toAvaliacaoDTOFromDomain(AvaliacaoDomain);
    }
}
