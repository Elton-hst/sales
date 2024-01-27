package br.com.microservices.sales.persistence.repository;

import br.com.microservices.sales.application.common.CommonOrder;
import br.com.microservices.sales.application.exception.OrderException;
import br.com.microservices.sales.domain.repository.OrderRepository;
import br.com.microservices.sales.persistence.dao.OrderDao;
import br.com.microservices.sales.persistence.entity.OrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderDao dao;

    @Override
    public Optional<CommonOrder> add(CommonOrder order) {
//        var oldOrder = order.toEntity();
//        if (!oldOrder.getProducts().contains(order.getProducts())) {
//
//            return Optional.of(order);
//        }
        var newOrder = dao.save(order.toEntity());
        return Optional.of(newOrder.toOrder());
    }

    @Override
    public Optional<CommonOrder> findById(UUID id) {
        var find = dao.findById(id)
                .orElseThrow(() -> new OrderException("erro ao buscar order"));
        return Optional.of(find.toOrder());
    }

    @Override
    public List<CommonOrder> findAll() {
        return dao.findAll().stream()
                .map(OrderEntity::toOrder)
                .toList();
    }

}
