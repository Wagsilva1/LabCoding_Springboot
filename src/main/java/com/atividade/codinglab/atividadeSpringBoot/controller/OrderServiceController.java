package com.atividade.codinglab.atividadeSpringBoot.controller;

import com.atividade.codinglab.atividadeSpringBoot.dto.OrderDTO;
import com.atividade.codinglab.atividadeSpringBoot.exception.EntityNotFoundException;
import com.atividade.codinglab.atividadeSpringBoot.exception.InvalidRegistryException;
import com.atividade.codinglab.atividadeSpringBoot.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceController {

    @Autowired
    private OrderService service;

    @GetMapping("/findById/{idOrder}")
    public ResponseEntity findById(@PathVariable("idOrder") int idOrder) throws EntityNotFoundException {
        OrderDTO order = service.findById(idOrder);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody OrderDTO order) {
        service.save(order);
        return new ResponseEntity<>("http://localhost:8080/findById/" + (service.getCurrentId() - 1),
                HttpStatus.ACCEPTED);
    }

    @PostMapping("/update/{idOrder}")
    public ResponseEntity<OrderDTO> update(@PathVariable("idOrder") int idOrder, @RequestBody OrderDTO order)
            throws EntityNotFoundException, InvalidRegistryException {
        service.update(idOrder, order);
        return new ResponseEntity<>(order, HttpStatus.ACCEPTED);
    }

    @GetMapping("/delete/{idOrder}")
    public ResponseEntity delete(@PathVariable("idOrder") int idOrder) {
        OrderDTO order = service.delete(idOrder);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

}
