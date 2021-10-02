# Exemplos de utilização OrderService e PaymentService

    A seguir alguns exemplos de chamadas para se utilizar a API

# OrderService

## Endpoint findById

    Possibilita ao usuario encontrar um pedido (Order) a partir do ID do mesmo

### Exemplo de utilização

    http://localhost:8080/findById/0

    OBS.: O mesmo irá retornar o pedido no formato JSON

## Endpoint save

    Possibilita ao usuario salvar um pedido (Order)

    OBS.: O mesmo irá retornar o URL para acessar o pedido salvo

### Exemplo de utilização

    http://localhost:8080/save

    Corpo da requisição:

    {
        "email" : "wagsilva1@gmail.com", 
        "nomeCompleto" : "Wagner Soares", 
        "address" : "Um endereço qualquer", 
        "idPedido" : 1, 
        "descricao" : ["desc A","desc B"],
        "qntdPedidos" : 1, 
        "precoUnitario" : [10.00, 10.00], 
        "precoTotal" : 20.00, 
        "formaPagamento" : "cartao", 
        "dataPedido" : "28/09/2021",
        "status" : "ativo", 
        "idTransacao" : 2, 
        "numeroCartao" : "123", 
        "validadeCartao" : "08/2026", 
        "bandeira" : "Visa"
    }

## Endpoint update

    Possibilita ao usuario atualizar os dados de um pedido (Order), utilizando seu ID para encontra-lo

### Exemplo de utilização

    http://localhost:8080/update/0

    Corpo da requisição:

    {
        "email" : "wagsilva1@gmail.com", 
        "nomeCompleto" : "Wagner Soares", 
        "address" : "Um endereço qualquer 2", 
        "idPedido" : 1, 
        "descricao" : ["desc A","desc B", "desc C"],
        "qntdPedidos" : 1, 
        "precoUnitario" : [10.00, 10.00, 10.00], 
        "precoTotal" : 30.00, 
        "formaPagamento" : "cartao", 
        "dataPedido" : "28/09/2021",
        "status" : "ativo", 
        "idTransacao" : 2, 
        "numeroCartao" : "123", 
        "validadeCartao" : "08/2026", 
        "bandeira" : "Visa"
    }

## Endpoint delete

    Possibilita ao usuario deletar um pedido (Order), utilizando seu ID para encontra-lo

### Exemplo de utilização

    http://localhost:8080/delete/0

    OBS.: O mesmo irá retornar o pedido no formato JSON, após exclui-lo

# PaymentService

## Endpoint findById

    Possibilita ao usuario encontrar uma transacão a partir da ID do mesmo

### Exemplo de utilização

    http://localhost:8080/pay/findById/0

    OBS.: O mesmo irá retornar a transação no formato JSON

## Endpoint save

    Possibilita ao usuario salvar uma transação

    OBS.: O mesmo irá retornar o URL para acessar a transação salva

### Exemplo de utilização

    http://localhost:8080/pay/save

    Corpo da requisição:

    { 
        "idTransacao" : 2, 
        "numeroCartao" : "123", 
        "validadeCartao" : "08/2026", 
        "bandeira" : "Visa"
    }

## Endpoint update

    Possibilita ao usuario atualizar os dados de uma transação, utilizando seu ID para encontra-la

### Exemplo de utilização

    http://localhost:8080/pay/update/0

    Corpo da requisição:

    {
        "idTransacao" : 2, 
        "numeroCartao" : "1234", 
        "validadeCartao" : "08/2026", 
        "bandeira" : "Mastercard"
    }

## Endpoint delete

    Possibilita ao usuario deletar uma transação, utilizando seu ID para encontra-lo

### Exemplo de utilização

    http://localhost:8080/pay/delete/0

    OBS.: O mesmo irá retornar uma transação no formato JSON, após exclui-la