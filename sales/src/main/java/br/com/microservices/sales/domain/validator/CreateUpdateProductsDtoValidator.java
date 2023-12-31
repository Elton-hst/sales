package br.com.microservices.sales.domain.validator;

import br.com.microservices.sales.domain.configs.validation.Validator;
import br.com.microservices.sales.domain.entity.Product;

import java.util.HashMap;
import java.util.Map;

public class CreateUpdateProductsDtoValidator implements Validator<Product> {

    @Override
    public Map<String, String> validate(Product product) {
        Map<String, String> errors = new HashMap<>();

        if(product.getCode() == null) {
            errors.put("produto", "é nulo");
        }

        return errors;
    }

}
