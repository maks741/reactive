package org.maks.reactive3.controller;

import org.maks.reactive3.entity.Bicycle;
import org.maks.reactive3.service.BicycleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bicycle")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class BicycleController {

    private final BicycleService bicycleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Bicycle> create(@RequestBody Bicycle bicycle) {
        return bicycleService.create(bicycle);
    }

    @PutMapping("/{id}")
    public Mono<Bicycle> update(@PathVariable Long id, @RequestBody Bicycle bicycle) {
        return bicycleService.update(id, bicycle);
    }

    @GetMapping("/{id}")
    public Mono<Bicycle> getById(@PathVariable Long id) {
        return bicycleService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable Long id) {
        return bicycleService.deleteById(id);
    }
}
