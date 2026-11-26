package org.maks.reactive3.repository;

import org.maks.reactive3.entity.Order;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface OrderRepository extends ReactiveCrudRepository<Order, Long> {
}
