package org.maks.reactive3.repository;

import org.maks.reactive3.entity.Bicycle;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BicycleRepository extends ReactiveCrudRepository<Bicycle, Long> {
}
