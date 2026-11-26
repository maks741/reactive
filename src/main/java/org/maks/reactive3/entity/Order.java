package org.maks.reactive3.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record Order(
        Long id,
        List<Bicycle> bicycles,
        List<Wheel> wheels,
        LocalDateTime orderDate,
        BigDecimal totalPrice,
        String status
) {
}
