package br.com.microservices.sales.domain.presenter;

import br.com.microservices.sales.domain.common.CommonProduct;
import br.com.microservices.sales.domain.configs.presenter.Presenter;

import java.util.Optional;
import java.util.UUID;

public class ProductPresenter implements Presenter<CommonProduct> {

    @Override
    public Optional<CommonProduct> successView(UUID id) {
        return null;
    }

    @Override
    public Optional<CommonProduct> failView(String error) {
        return null;
    }

}
