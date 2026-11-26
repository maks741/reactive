package org.maks.reactive3.controller;

import org.maks.reactive3.entity.Order;
import org.maks.reactive3.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Order> create(@RequestBody Order order) {
        return orderService.create(order);
    }

    @PutMapping("/{id}")
    public Mono<Order> update(@PathVariable Long id, @RequestBody Order order) {
        return orderService.update(id, order);
    }

    @GetMapping("/{id}")
    public Mono<Order> getById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable Long id) {
        return orderService.deleteById(id);
    }
}
