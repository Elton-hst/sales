package br.com.microservices.inventory.domain.validator;

import br.com.microservices.inventory.domain.configs.validation.Validator;
import br.com.microservices.inventory.domain.entity.Order;

import java.util.HashMap;
import java.util.Map;

public class CreateUpdateOrderDtoValidator implements Validator<Order> {

    @Override
    public Map<String, String> validate(Order order) {
        Map<String, String> errors = new HashMap<>();

        if (order == null){
            errors.put("Order", "é nulo");
        }

        return errors;
    }
}
