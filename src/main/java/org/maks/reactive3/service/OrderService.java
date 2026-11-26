package org.maks.reactive3.service;

import org.maks.reactive3.entity.Order;
import org.maks.reactive3.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Flux<Order> findAll() {
        return orderRepository.findAll();
    }

    public Mono<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    public Mono<Order> create(Order order) {
        return orderRepository.save(order.withId(null));
    }

    public Mono<Order> update(Long id, Order order) {
        return orderRepository.findById(id)
                .flatMap(existing -> orderRepository.save(order.withId(id)));
    }

    public Mono<Void> deleteById(Long id) {
        return orderRepository.deleteById(id);
    }
}
