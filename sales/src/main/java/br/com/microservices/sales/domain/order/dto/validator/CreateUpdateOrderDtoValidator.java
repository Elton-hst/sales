package br.com.microservices.sales.domain.order.dto.validator;

import br.com.microservices.sales.domain.configs.validation.Validator;
import br.com.microservices.sales.domain.order.dto.CreateUpdadeOrderDto;

import java.util.HashMap;
import java.util.Map;

public class CreateUpdateOrderDtoValidator implements Validator<CreateUpdadeOrderDto> {
    @Override
    public Map<String, String> validate(CreateUpdadeOrderDto dto) {
        Map<String, String> errors = new HashMap<>();

        if (dto == null){
            errors.put("objeto ", "é nulo");
            return errors;
        }
        return errors;
    }
}
