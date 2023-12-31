package br.com.microservices.sales.domain.presenter.formatter;

import br.com.microservices.sales.domain.common.CommonProduct;
import br.com.microservices.sales.domain.presenter.ProductPresenter;

import java.util.Optional;
import java.util.UUID;

public class ProductFormatter implements ProductPresenter {

    @Override
    public Optional<CommonProduct> successView(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<CommonProduct> failView(String error) {
        return Optional.empty();
    }

}
