package org.maks.reactive3.entity;

import java.math.BigDecimal;

public record Wheel(
        Long id,
        String brand,
        String diameter,
        String position, // Переднє чи заднє
        boolean tubelessReady, // Підтримка безкамерного використання
        BigDecimal price,
        int stockQuantity
) {
}
