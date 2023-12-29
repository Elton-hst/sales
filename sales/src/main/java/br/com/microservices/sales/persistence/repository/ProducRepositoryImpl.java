package br.com.microservices.sales.persistence.repository;

import br.com.microservices.sales.domain.common.CommonProduct;
import br.com.microservices.sales.domain.repository.ProductRepository;
import br.com.microservices.sales.application.exception.ProductException;
import br.com.microservices.sales.persistence.dao.ProductEntityDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ProducRepositoryImpl implements ProductRepository {

    private final ProductEntityDao dao;

    @Override
    public Optional<CommonProduct> add(CommonProduct product) {
        var inserted = dao.save(product.toEntity());
        return Optional.of(inserted.toProduct());
    }

    @Override
    public Optional<CommonProduct> findById(UUID id) {
        var find = dao.findById(String.valueOf(id))
                .orElseThrow(() -> new ProductException("erro ao buscar order"));
        return Optional.of(find.toProduct());
    }

    @Override
    public List<CommonProduct> findAll() {
        return null;
    }
}
