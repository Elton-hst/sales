package br.com.microservices.sales.web.controller.docs;

import br.com.microservices.sales.web.request.CreateUpdadeOrderDto;
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
    ResponseEntity<?> createOrder(CreateUpdadeOrderDto products);

}
