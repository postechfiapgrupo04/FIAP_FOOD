package br.com.fiap.fiapfood.dataprovider.persistence.implementation;

import br.com.fiap.fiapfood.core.entity.AvaliacaoDomain;
import br.com.fiap.fiapfood.core.gateways.AvaliacaoRepository;
import br.com.fiap.fiapfood.dataprovider.persistence.model.Avaliacao;
import br.com.fiap.fiapfood.dataprovider.persistence.repository.AvaliacaoJPARepository;
import br.com.fiap.fiapfood.entrypoint.api.mapper.AvaliacaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AvaliacaoRepositoryImp implements AvaliacaoRepository{
    private final AvaliacaoJPARepository avaliacaoJPARepository;

    private final AvaliacaoMapper avaliacaoMapper;

    @Override
    public AvaliacaoDomain salvar(AvaliacaoDomain avaliacao) {
        return AvaliacaoMapper.toAvaliacaoDomainFromModel(
                avaliacaoJPARepository.save(AvaliacaoMapper.toAvaliacaoModelFromDomain(avaliacao)));
    }

    @Override
    public AvaliacaoDomain buscarPorId(Long id) {
        Optional<Avaliacao> avaliacaoEntity = avaliacaoJPARepository.findById(id);
        if (avaliacaoEntity.isPresent()) {
            return AvaliacaoMapper.toAvaliacaoDomainFromModel(avaliacaoEntity.get());
        }
        throw new RuntimeException("Avaliação não encontrada");
    }

    @Override
    public List<AvaliacaoDomain> buscarTodos() {
        List<Avaliacao> avaliacao = avaliacaoJPARepository.findAll();
        List<AvaliacaoDomain> avaliacaoDomains = avaliacao
                .stream()
                .map(AvaliacaoMapper::toAvaliacaoDomainFromModel)
                .toList();
        return avaliacaoDomains;
    }

    @Override
    public void apagar(Long id) {
        Optional<Avaliacao> avaliacaoEntity = avaliacaoJPARepository.findById(id);
        if (avaliacaoEntity.isPresent()) {
            avaliacaoJPARepository.delete(avaliacaoEntity.get());
        }
        throw new RuntimeException("Avaliação não encontrada");
    }

    @Override
    public AvaliacaoDomain buscarPorNomeRestaurante(String nomeRestaurante) {
        Optional<Avaliacao> avaliacaoEntity = avaliacaoJPARepository.findByNomeRestaurante(nomeRestaurante);
        if (avaliacaoEntity.isPresent()) {
            return AvaliacaoMapper.toAvaliacaoDomainFromModel(avaliacaoEntity.get());
        }
        throw new RuntimeException("Avaliação não encontrada");
    }
}
