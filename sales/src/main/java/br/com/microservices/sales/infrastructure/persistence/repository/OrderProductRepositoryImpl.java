package br.com.microservices.sales.infrastructure.persistence.repository;

import br.com.microservices.sales.infrastructure.mapper.OrderProductMapper;
import br.com.microservices.sales.domain.orderProduct.OrderProduct;
import br.com.microservices.sales.domain.orderProduct.repository.OrderProductRepository;
import br.com.microservices.sales.infrastructure.persistence.dao.OrderProductEntityDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrderProductRepositoryImpl implements OrderProductRepository {

    private final OrderProductEntityDao dao;

    @Override
    public Optional<OrderProduct> add(OrderProduct orderProduct) {
        var inserted = dao.save(OrderProductMapper.toEntity(orderProduct));
        return Optional.of(OrderProductMapper.toOrderProduct(inserted));
    }
}
