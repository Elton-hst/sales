package br.com.microservices.sales.infrastructure.docs;

import br.com.microservices.sales.domain.order.dto.CreateUpdadeOrderDto;
import br.com.microservices.sales.domain.order.dto.GetOrderDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "sales order")
public interface OrderControllerDocs {

    @Operation(summary = "cria um novo order", method ="POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "order criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao criar um novo order"),
    })
    public ResponseEntity<GetOrderDto> criarOrder(CreateUpdadeOrderDto dto);

}
