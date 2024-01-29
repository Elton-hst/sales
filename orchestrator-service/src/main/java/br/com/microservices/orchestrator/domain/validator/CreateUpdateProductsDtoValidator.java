package br.com.microservices.orchestrator.domain.validator;

import br.com.microservices.orchestrator.domain.configs.validation.Validator;
import br.com.microservices.orchestrator.domain.entity.Product;

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
