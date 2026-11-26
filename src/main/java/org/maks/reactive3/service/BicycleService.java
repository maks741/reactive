package org.maks.reactive3.service;

import org.maks.reactive3.entity.Bicycle;
import org.maks.reactive3.repository.BicycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BicycleService {

    private final BicycleRepository bicycleRepository;

    @Autowired
    public BicycleService(BicycleRepository bicycleRepository) {
        this.bicycleRepository = bicycleRepository;
    }

    public Flux<Bicycle> findAll() {
        return bicycleRepository.findAll();
    }

    public Mono<Bicycle> findById(Long id) {
        return bicycleRepository.findById(id);
    }

    public Mono<Bicycle> create(Bicycle bicycle) {
        return bicycleRepository.save(bicycle.withId(null));
    }

    public Mono<Bicycle> update(Long id, Bicycle bicycle) {
        return bicycleRepository.findById(id)
                .flatMap(existing -> bicycleRepository.save(bicycle.withId(id)));
    }

    public Mono<Void> deleteById(Long id) {
        return bicycleRepository.deleteById(id);
    }
}
