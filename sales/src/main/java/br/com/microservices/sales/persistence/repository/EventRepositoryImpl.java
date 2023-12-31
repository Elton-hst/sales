package br.com.microservices.sales.persistence.repository;

import br.com.microservices.sales.domain.common.CommonEvent;
import br.com.microservices.sales.domain.common.CommonHistory;
import br.com.microservices.sales.domain.repository.EventRepository;
import br.com.microservices.sales.domain.repository.HistoryRepository;
import br.com.microservices.sales.persistence.dao.EventEntityDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class EventRepositoryImpl implements EventRepository {

    private final EventEntityDao dao;

    @Override
    public Optional<CommonEvent> add(CommonEvent commonEvent) {
        var create = dao.save(commonEvent.toEntity());
        return Optional.of(create.toEvent());
    }

    @Override
    public Optional<CommonEvent> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<CommonEvent> findAll() {
        return null;
    }
}
