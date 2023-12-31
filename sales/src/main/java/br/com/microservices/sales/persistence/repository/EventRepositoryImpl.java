package br.com.microservices.sales.persistence.repository;

import br.com.microservices.sales.domain.common.CommonHistory;
import br.com.microservices.sales.domain.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class EventRepositoryImpl implements HistoryRepository {


    @Override
    public Optional<CommonHistory> add(CommonHistory commonHistory) {
        return Optional.empty();
    }

    @Override
    public Optional<CommonHistory> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<CommonHistory> findAll() {
        return null;
    }

}
