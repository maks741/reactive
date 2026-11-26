package org.maks.reactive3.repository;

import org.maks.reactive3.entity.Message;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MessageRepository extends ReactiveCrudRepository<Message, Long> {
}
