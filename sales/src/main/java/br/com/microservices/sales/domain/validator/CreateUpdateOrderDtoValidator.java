package br.com.microservices.sales.domain.validator;

import br.com.microservices.sales.domain.common.CommonOrder;
import br.com.microservices.sales.domain.configs.validation.Validator;

import java.util.HashMap;
import java.util.Map;

public class CreateUpdateOrderDtoValidator implements Validator<CommonOrder> {

    @Override
    public Map<String, String> validate(CommonOrder order) {
        Map<String, String> errors = new HashMap<>();

        if (order == null){
            errors.put("objeto ", "é nulo");
            return errors;
        }
        if (order.products().isEmpty()) {
            errors.put("Produtos ", "estão nulos");
        }

        return errors;
    }
}
