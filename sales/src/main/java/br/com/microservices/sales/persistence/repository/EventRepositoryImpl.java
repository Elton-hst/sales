package br.com.microservices.sales.persistence.repository;

import br.com.microservices.sales.domain.entity.Event;
import br.com.microservices.sales.domain.repository.EventRepository;
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
    public Optional<Event> add(Event commonEvent) {
        var create = dao.save(commonEvent.toEntity());
        return Optional.of(create.toEvent());
    }

    @Override
    public Optional<Event> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Event> findAll() {
        return null;
    }
}
