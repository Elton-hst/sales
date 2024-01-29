
# projeto Sales

O objetivo desse projeto é colocar em pratica tudo que venho estudando no momento.


* **Sales**: microsserviço responsável apenas por gerar um pedido inicial, e receber uma notificação. Aqui que teremos endpoints REST para inciar o processo e recuperar os dados dos eventos. O banco de dados utilizado será o PostgreSQL.
* **Orchestrator-Service**: microsserviço responsável por orquestrar todo o fluxo de execução da Saga, ele que saberá qual microsserviço foi executado e em qual estado, e para qual será o próximo microsserviço a ser enviado, este microsserviço também irá salvar o processo dos eventos. Este serviço não possui banco de dados.
* **Auth-service**: microsserviço responsável por validar se usuário informado existe e está válido. Este microsserviço emite uma autorização permitir o processamento do pagamento. O banco de dados utilizado será o PostgreSQL.
* **Payment-Service**: microsserviço responsável por realizar um pagamento com base nos valores unitários e quantidades informadas no pedido. Este microsserviço guardará a informação de pagamento de um pedido. O banco de dados utilizado será o PostgreSQL.
* **Inventory-Service**: microsserviço responsável por realizar a baixa do estoque dos produtos de um pedido. Este microsserviço guardará a informação da baixa de um produto para o ID de um pedido. O banco de dados utilizado será o PostgreSQL.
## Documentação da API

#### Retorna todos os itens

```http
  POST /order-service/criar
```

Payload:

```json
{
  "products": [
    {
      "code": "COMIC_BOOKS",
      "unitValue": 15.50
    },
    {
      "code": "BOOKS",
      "unitValue": 9.50
    }
  ]
}
```
Resposta:

```json
{
  "id": "64429e987a8b646915b3735f",
  "products": [
    {
      "id": "64429e987a8b646915b3735f",
      "code": "COMIC_BOOKS",
      "unitValue": 15.50
    },
    {
      "id": "64429e987a8b646915b3735f",
      "code": "BOOKS",
      "unitValue": 9.50
    }
  ],
  "createdAt": "2023-04-21",
  "transactionId": "1706392160435_3f9108c8-3ae2-423f-8dd7-a7a502ad59b3",
  "totalAmount": 25,
  "totalItems": 2
}
```