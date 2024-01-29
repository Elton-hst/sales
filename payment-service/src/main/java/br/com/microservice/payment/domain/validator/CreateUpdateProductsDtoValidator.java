package br.com.microservice.payment.domain.validator;

import br.com.microservice.payment.domain.configs.validation.Validator;
import br.com.microservice.payment.domain.entity.Product;

import java.util.HashMap;
import java.util.Map;

public class CreateUpdateProductsDtoValidator implements Validator<Product> {

    @Override
    public Map<String, String> validate(Product product) {
        Map<String, String> errors = new HashMap<>();

        if(product.code() == null) {
            errors.put("produto", "é nulo");
        }

        return errors;
    }

}
