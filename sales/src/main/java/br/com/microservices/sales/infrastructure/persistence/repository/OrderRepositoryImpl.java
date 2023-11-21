package br.com.microservices.sales.infrastructure.persistence.repository;

import br.com.microservices.sales.domain.order.Order;
import br.com.microservices.sales.domain.order.repository.OrderRepository;
import br.com.microservices.sales.infrastructure.mapper.OrderMapper;
import br.com.microservices.sales.infrastructure.persistence.dao.OrderEntityDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderEntityDao dao;

    @Override
    public Optional<Order> add(Order order) {
        var inserted = dao.save(OrderMapper.toEntity(order));
        return Optional.of(OrderMapper.toOrder(inserted));
    }

}
