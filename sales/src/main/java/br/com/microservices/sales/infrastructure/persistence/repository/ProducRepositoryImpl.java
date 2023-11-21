package br.com.microservices.sales.infrastructure.persistence.repository;

import br.com.microservices.sales.infrastructure.mapper.ProductMapper;
import br.com.microservices.sales.domain.product.Product;
import br.com.microservices.sales.domain.product.repository.ProductRepository;
import br.com.microservices.sales.infrastructure.persistence.dao.ProductEntityDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProducRepositoryImpl implements ProductRepository {

    private final ProductEntityDao dao;

    @Override
    public Optional<Product> add(Product product) {
        var inserted = dao.save(ProductMapper.toEntity(product));
        return Optional.of(ProductMapper.toProduct(inserted));
    }
}
