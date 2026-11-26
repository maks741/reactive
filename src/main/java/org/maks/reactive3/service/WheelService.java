package org.maks.reactive3.service;

import org.maks.reactive3.entity.Wheel;
import org.maks.reactive3.repository.WheelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WheelService {

    private final WheelRepository wheelRepository;

    @Autowired
    public WheelService(WheelRepository wheelRepository) {
        this.wheelRepository = wheelRepository;
    }

    public Flux<Wheel> findAll() {
        return wheelRepository.findAll();
    }

    public Mono<Wheel> findById(Long id) {
        return wheelRepository.findById(id);
    }

    public Mono<Wheel> create(Wheel wheel) {
        return wheelRepository.save(wheel.withId(null));
    }

    public Mono<Wheel> update(Long id, Wheel wheel) {
        return wheelRepository.findById(id)
                .flatMap(existing -> wheelRepository.save(wheel.withId(id)));
    }

    public Mono<Void> deleteById(Long id) {
        return wheelRepository.deleteById(id);
    }
}
