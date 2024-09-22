package com.example.springsecurityoauth2example.repository;

import com.example.springsecurityoauth2example.entity.Oauth2RegisteredClient;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface Oauth2RegisteredClientRepository extends ReactiveMongoRepository<Oauth2RegisteredClient, String> {

    Mono<Oauth2RegisteredClient> findByClientId(String clientId);
}
