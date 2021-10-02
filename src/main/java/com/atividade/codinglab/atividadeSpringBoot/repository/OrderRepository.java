package com.atividade.codinglab.atividadeSpringBoot.repository;

import java.util.ArrayList;
import java.util.List;

import com.atividade.codinglab.atividadeSpringBoot.dto.OrderDTO;
import com.atividade.codinglab.atividadeSpringBoot.entity.Order;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    private List<Order> orders = new ArrayList<Order>();

    public Order findById(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    public void save(Order ord) {
        orders.add(ord);
    }

    public void update(int idOrder, OrderDTO order) {
        Order newOrder = this.findById(idOrder);
        newOrder.setAddress(order.getAddress());
        newOrder.setDescricao(order.getDescricao());
        newOrder.setQntdPedidos(order.getQntdPedidos());
        newOrder.setPrecoUnitario(order.getPrecoUnitario());
        newOrder.setPrecoTotal(order.getPrecoTotal());
        newOrder.setFormaPagamento(order.getFormaPagamento());
        newOrder.setIdTransacao(order.getIdTransacao());
        newOrder.setNumeroCartao(order.getNumeroCartao());
        newOrder.setValidadeCartao(order.getValidadeCartao());
        newOrder.setBandeira(order.getBandeira());
    }

    public Order delete(int idOrder) {
        Order order = this.findById(idOrder);
        Order oldOrder = new Order();
        oldOrder.setId(order.getId());
        oldOrder.setEmail(order.getEmail());
        oldOrder.setNomeCompleto(order.getNomeCompleto());
        oldOrder.setAddress(order.getAddress());
        oldOrder.setIdPedido(order.getIdPedido());
        oldOrder.setDescricao(order.getDescricao());
        oldOrder.setQntdPedidos(order.getQntdPedidos());
        oldOrder.setPrecoUnitario(order.getPrecoUnitario());
        oldOrder.setPrecoTotal(order.getPrecoTotal());
        oldOrder.setFormaPagamento(order.getFormaPagamento());
        oldOrder.setDataPedido(order.getDataPedido());
        oldOrder.setStatus(order.getStatus());
        oldOrder.setIdTransacao(order.getIdTransacao());
        oldOrder.setNumeroCartao(order.getNumeroCartao());
        oldOrder.setValidadeCartao(order.getValidadeCartao());
        oldOrder.setBandeira(order.getBandeira());
        orders.remove(order);
        return oldOrder;
    }

}
