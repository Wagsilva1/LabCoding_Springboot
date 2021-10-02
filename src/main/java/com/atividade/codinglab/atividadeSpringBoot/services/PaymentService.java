package com.atividade.codinglab.atividadeSpringBoot.services;

import com.atividade.codinglab.atividadeSpringBoot.entity.Payment;
import com.atividade.codinglab.atividadeSpringBoot.repository.PaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentRepository repository;

    @Autowired
    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }

    public Payment findById(int id) {
        Payment payment = repository.findById(id);
        return payment;
    }

    public void save(Payment payment) {
        this.repository.save(payment);
    }

    public void update(int idTransacao, Payment payment) {
        repository.update(idTransacao, payment);
    }

    public Payment delete(int idTransacao) {
        return repository.delete(idTransacao);
    }

}
