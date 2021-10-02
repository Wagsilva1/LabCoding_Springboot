package com.atividade.codinglab.atividadeSpringBoot.services;

import com.atividade.codinglab.atividadeSpringBoot.dto.OrderDTO;
import com.atividade.codinglab.atividadeSpringBoot.entity.Order;
import com.atividade.codinglab.atividadeSpringBoot.exception.EntityNotFoundException;
import com.atividade.codinglab.atividadeSpringBoot.exception.InvalidRegistryException;
import com.atividade.codinglab.atividadeSpringBoot.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private OrderRepository repository;
    private int idAtual;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
        this.idAtual = 0;
    }

    public OrderDTO findById(int id) throws EntityNotFoundException {
        Order order = repository.findById(id);

        if (order == null)
            throw new EntityNotFoundException("Pedido com ID " + id + " não encontrado.");

        OrderDTO orderDTO = new OrderDTO(order.getEmail(), order.getNomeCompleto(), order.getAddress(),
                order.getIdPedido(), order.getDescricao(), order.getQntdPedidos(), order.getPrecoUnitario(),
                order.getPrecoTotal(), order.getFormaPagamento(), order.getDataPedido(), order.getStatus(),
                order.getIdTransacao(), order.getNumeroCartao(), order.getValidadeCartao(), order.getBandeira());
        return orderDTO;
    }

    public void save(OrderDTO order) {
        Order ord = new Order(idAtual, order.getEmail(), order.getNomeCompleto(), order.getAddress(),
                order.getIdPedido(), order.getDescricao(), order.getQntdPedidos(), order.getPrecoUnitario(),
                order.getPrecoTotal(), order.getFormaPagamento(), order.getDataPedido(), order.getStatus(),
                order.getIdTransacao(), order.getNumeroCartao(), order.getValidadeCartao(), order.getBandeira());
        this.repository.save(ord);
        idAtual++;
    }

    public void update(int idOrder, OrderDTO order) throws EntityNotFoundException, InvalidRegistryException {
        if (repository.findById(idOrder) == null)
            throw new EntityNotFoundException("Pedido com ID " + idOrder + " não encontrado.");
        repository.update(idOrder, order);
    }

    public OrderDTO delete(int idOrder) {
        Order order = repository.delete(idOrder);
        OrderDTO orderDTO = new OrderDTO(order.getEmail(), order.getNomeCompleto(), order.getAddress(),
                order.getIdPedido(), order.getDescricao(), order.getQntdPedidos(), order.getPrecoUnitario(),
                order.getPrecoTotal(), order.getFormaPagamento(), order.getDataPedido(), order.getStatus(),
                order.getIdTransacao(), order.getNumeroCartao(), order.getValidadeCartao(), order.getBandeira());
        return orderDTO;
    }

    public int getCurrentId() {
        return this.idAtual;
    }

}
