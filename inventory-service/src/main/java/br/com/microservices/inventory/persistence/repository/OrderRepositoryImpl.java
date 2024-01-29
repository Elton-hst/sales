package br.com.microservices.inventory.persistence.repository;

import br.com.microservices.inventory.application.exception.OrderException;
import br.com.microservices.inventory.domain.entity.Order;
import br.com.microservices.inventory.domain.repository.OrderRepository;
import br.com.microservices.inventory.persistence.dao.OrderEntityDao;
import br.com.microservices.inventory.persistence.entity.OrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderEntityDao dao;

    @Override
    public Optional<Order> add(Order order) {
        var newOrder = dao.save(order.toEntity());
        return Optional.of(newOrder.toOrder());
    }

    @Override
    public Optional<Order> findById(UUID id) {
        var find = dao.findById(id)
                .orElseThrow(() -> new OrderException("erro ao buscar order"));
        return Optional.of(find.toOrder());
    }

    @Override
    public List<Order> findAll() {
        return dao.findAll().stream()
                .map(OrderEntity::toOrder)
                .toList();
    }

}
