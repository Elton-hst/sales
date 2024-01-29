package br.com.microservice.payment.application.presenter.formatter;

import br.com.microservice.payment.application.presenter.ProductPresenter;
import br.com.microservice.payment.domain.entity.Product;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductFormatter implements ProductPresenter {

    @Override
    public Optional<Product> successView(Product product) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> failView(String error) {
        return Optional.empty();
    }

}
