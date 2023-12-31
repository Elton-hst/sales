package br.com.microservices.sales.domain.configs.factory;

import br.com.microservices.sales.application.exception.ValidatorException;
import br.com.microservices.sales.domain.common.CommonOrder;
import br.com.microservices.sales.domain.common.CommonProduct;
import br.com.microservices.sales.domain.configs.validation.Validator;
import br.com.microservices.sales.domain.entity.Order;

import java.util.List;

import static java.util.stream.Collectors.joining;

public interface OrderFactory {

    CommonOrder create(List<CommonProduct> products);

//    static <T> void validate(OrderFactory<T> validator, T t) {
//        var errors = validator.validate(t);
//
//        if(!errors.isEmpty()) {
//            var message = errors
//                    .entrySet()
//                    .stream()
//                    .map(e-> e.getKey() + ": " + e.getValue())
//                    .collect(joining(", "));
//            throw new ValidatorException("[VALIDATION ERRORS]: " + message);
//        }
//    }

}
