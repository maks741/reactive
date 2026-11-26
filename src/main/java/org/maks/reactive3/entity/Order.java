package org.maks.reactive3.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table("orders")
public record Order(
        @Id Long id,
        @Column("order_date") LocalDateTime orderDate,
        @Column("total_price") BigDecimal totalPrice,
        String status
) {
    public Order withId(Long id) {
        return new Order(id, orderDate, totalPrice, status);
    }
}
