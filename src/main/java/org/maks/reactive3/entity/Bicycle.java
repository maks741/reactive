package org.maks.reactive3.entity;

import java.math.BigDecimal;

public record Bicycle(
        Long id,
        String brand,
        String model,
        String type, // Тип (напр., Гірський, Шосейний)
        String frameSize,
        BigDecimal price,
        int stockQuantity
) {
}
