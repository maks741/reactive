package org.maks.reactive3.controller;

import org.maks.reactive3.entity.Wheel;
import org.maks.reactive3.service.WheelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/wheel")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class WheelController {

    private final WheelService wheelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Wheel> create(@RequestBody Wheel wheel) {
        return wheelService.create(wheel);
    }

    @PutMapping("/{id}")
    public Mono<Wheel> update(@PathVariable Long id, @RequestBody Wheel wheel) {
        return wheelService.update(id, wheel);
    }

    @GetMapping("/{id}")
    public Mono<Wheel> getById(@PathVariable Long id) {
        return wheelService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable Long id) {
        return wheelService.deleteById(id);
    }
}
