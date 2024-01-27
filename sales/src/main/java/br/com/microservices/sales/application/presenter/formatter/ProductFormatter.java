package br.com.microservices.sales.application.presenter.formatter;

import br.com.microservices.sales.application.common.CommonProduct;
import br.com.microservices.sales.application.presenter.ProductPresenter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductFormatter implements ProductPresenter {

    @Override
    public Optional<CommonProduct> successView(CommonProduct product) {
        return Optional.empty();
    }

    @Override
    public Optional<CommonProduct> failView(String error) {
        return Optional.empty();
    }

}
