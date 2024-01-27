package br.com.microservices.sales.web.request;

import br.com.microservices.sales.application.common.CommonProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder @Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUpdadeOrderDto {

    private Set<CommonProduct> products;

}
