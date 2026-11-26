package org.maks.reactive3.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table("bicycles")
public record Bicycle(
        @Id Long id,
        String brand,
        String model,
        String type,
        @Column("frame_size") String frameSize,
        BigDecimal price,
        @Column("stock_quantity") int stockQuantity
) {
    public Bicycle withId(Long id) {
        return new Bicycle(id, brand, model, type, frameSize, price, stockQuantity);
    }
}
