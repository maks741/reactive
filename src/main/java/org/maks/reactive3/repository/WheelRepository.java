package org.maks.reactive3.repository;

import org.maks.reactive3.entity.Wheel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface WheelRepository extends ReactiveCrudRepository<Wheel, Long> {
}
