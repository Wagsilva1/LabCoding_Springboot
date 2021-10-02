package com.atividade.codinglab.atividadeSpringBoot.controller;

import com.atividade.codinglab.atividadeSpringBoot.entity.Payment;
import com.atividade.codinglab.atividadeSpringBoot.services.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService service;

    @GetMapping("/pay/findById/{idTransacao}")
    public ResponseEntity findById(@PathVariable("idTransacao") int idTransacao) {
        Payment payment = service.findById(idTransacao);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @PostMapping("/pay/save")
    public ResponseEntity<String> save(@RequestBody Payment payment) {
        service.save(payment);
        return new ResponseEntity<>("http://localhost:8080/pay/findById/" + payment.getIdTransacao(),
                HttpStatus.ACCEPTED);
    }

    @PostMapping("/pay/update/{idTransacao}")
    public ResponseEntity<Payment> update(@PathVariable("idTransacao") int idTransacao, @RequestBody Payment payment) {
        service.update(idTransacao, payment);
        return new ResponseEntity<>(payment, HttpStatus.ACCEPTED);
    }

    @GetMapping("/pay/delete/{idTransacao}")
    public ResponseEntity delete(@PathVariable("idTransacao") int idTransacao) {
        Payment payment = service.delete(idTransacao);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

}
