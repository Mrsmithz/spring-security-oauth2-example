package com.example.springsecurityoauth2example.repository;

import com.example.springsecurityoauth2example.constant.TokenStatus;
import com.example.springsecurityoauth2example.entity.Authorization;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AuthorizationRepository extends ReactiveMongoRepository<Authorization, String> {

    Mono<Authorization> findByAccessTokenValue(String accessToken);

    Mono<Authorization> findByRefreshTokenValue(String refreshToken);

    Mono<Authorization> findByAccessTokenValueAndTokenStatus(String accessToken, TokenStatus status);

    Mono<Authorization> findByAccessTokenValueOrRefreshTokenValue(String accessToken, String refreshToken);
}
