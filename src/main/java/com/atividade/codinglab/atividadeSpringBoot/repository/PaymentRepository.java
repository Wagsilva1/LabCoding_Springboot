package com.atividade.codinglab.atividadeSpringBoot.repository;

import java.util.ArrayList;
import java.util.List;

import com.atividade.codinglab.atividadeSpringBoot.entity.Payment;

import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository {

    private List<Payment> payments = new ArrayList<Payment>();

    public Payment findById(int id) {
        for (Payment payment : payments) {
            if (payment.getIdTransacao() == id) {
                return payment;
            }
        }
        return null;
    }

    public void save(Payment payment) {
        this.payments.add(payment);
    }

    public void update(int idTransacao, Payment payment) {
        Payment newPayment = this.findById(idTransacao);
        newPayment.setIdTransacao(payment.getIdTransacao());
        newPayment.setNumeroCartao(payment.getNumeroCartao());
        newPayment.setBandeira(payment.getBandeira());
        newPayment.setValidadeCartao(payment.getValidadeCartao());
    }

    public Payment delete(int idTransacao) {
        Payment payment = this.findById(idTransacao);
        Payment oldPayment = new Payment(payment.getIdTransacao(), payment.getNumeroCartao(),
                payment.getValidadeCartao(), payment.getBandeira());
        payments.remove(payment);
        return oldPayment;
    }

}
