package org.maks.reactive3.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table("wheels")
public record Wheel(
        @Id Long id,
        String brand,
        String diameter,
        String position,
        @Column("tubeless_ready") boolean tubelessReady,
        BigDecimal price,
        @Column("stock_quantity") int stockQuantity
) {
    public Wheel withId(Long id) {
        return new Wheel(id, brand, diameter, position, tubelessReady, price, stockQuantity);
    }
}
