package br.com.microservices.sales.domain.validator;

import br.com.microservices.sales.domain.common.CommonOrder;
import br.com.microservices.sales.domain.configs.validation.Validator;
import br.com.microservices.sales.domain.entity.Order;

import java.util.HashMap;
import java.util.Map;

public class CreateUpdateOrderDtoValidator implements Validator<CommonOrder> {

    @Override
    public Map<String, String> validate(CommonOrder order) {
        Map<String, String> errors = new HashMap<>();

        if (order == null){
            errors.put("Order", "é nulo");
        }
        if (order.getProducts().isEmpty()) {
            errors.put("Order de Produtos", "estão nulos");
        }

        return errors;
    }
}
