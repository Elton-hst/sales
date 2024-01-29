package br.com.microservices.orchestrator.persistence.repository;

import br.com.microservices.orchestrator.application.exception.ProductException;
import br.com.microservices.orchestrator.domain.entity.Product;
import br.com.microservices.orchestrator.domain.repository.ProductRepository;
import br.com.microservices.orchestrator.persistence.dao.ProductEntityDao;
import br.com.microservices.orchestrator.persistence.entity.ProductEntity;
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
    public Optional<Product> add(Product product) {
        var inserted = dao.save(product.toEntity());
        return Optional.of(inserted.toProduct());
    }
    public Optional<ProductEntity> newAdd(ProductEntity product) {
        var inserted = dao.save(product);
        return Optional.of(inserted);
    }

    @Override
    public Optional<Product> findById(UUID id) {
        var find = dao.findById(String.valueOf(id))
                .orElseThrow(() -> new ProductException("erro ao buscar order"));
        return Optional.of(find.toProduct());
    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}
