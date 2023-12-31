package br.com.microservices.sales.persistence.repository;

import br.com.microservices.sales.domain.common.CommonHistory;
import br.com.microservices.sales.domain.repository.HistoryRepository;
import br.com.microservices.sales.persistence.dao.HistoryEntityDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class HistoryRepositoryImpl implements HistoryRepository {

    private final HistoryEntityDao dao;

    @Override
    public Optional<CommonHistory> add(CommonHistory commonHistory) {
        var create = dao.save(commonHistory.toEntity());
        return Optional.of(create.toHistory());
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
