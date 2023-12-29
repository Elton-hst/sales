package br.com.microservices.sales.persistence.repository;

import br.com.microservices.sales.domain.common.CommonOrder;
import br.com.microservices.sales.domain.repository.OrderRepository;
import br.com.microservices.sales.application.exception.OrderException;
import br.com.microservices.sales.persistence.dao.OrderEntityDao;
import br.com.microservices.sales.persistence.entity.OrderEntity;
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
    public Optional<CommonOrder> add(CommonOrder order) {
        var inserted = dao.save(order.toEntity());
        return Optional.of(inserted.toOrder());
    }

    @Override
    public Optional<CommonOrder> findById(UUID id) {
        var find = dao.findById(String.valueOf(id))
                .orElseThrow(() -> new OrderException("erro ao buscar order"));
        return Optional.of(find.toOrder());
    }

    @Override
    public List<CommonOrder> findAll() {
        return dao.findAll()
                .stream()
                .map(OrderEntity::toOrder)
                .toList();
    }

}
