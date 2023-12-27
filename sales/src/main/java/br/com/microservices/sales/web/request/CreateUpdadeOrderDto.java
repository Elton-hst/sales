package br.com.microservices.sales.web.request;

import br.com.microservices.sales.domain.common.CommonProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder @Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUpdadeOrderDto {

    private List<CommonProduct> products;

}
