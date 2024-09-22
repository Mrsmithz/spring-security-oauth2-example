package com.example.springsecurityoauth2example.cache;

import com.example.springsecurityoauth2example.constant.CacheConstant;
import com.example.springsecurityoauth2example.entity.Oauth2RegisteredClient;
import com.example.springsecurityoauth2example.repository.Oauth2RegisteredClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class RedisCacheHelper {

    private final Oauth2RegisteredClientRepository oauth2RegisteredClientRepository;

    @CachePut(value = CacheConstant.REGISTERED_CLIENT_CACHE_NAME, key = "#entity.clientId", cacheManager = CacheConstant.REDIS_CACHE_MANAGER_NAME)
    public RegisteredClient putRegisteredClientCache(RegisteredClient entity) {
        log.info("put clientId : {} in cache", entity.getClientId());
        return entity;
    }

    @Cacheable(value = CacheConstant.REGISTERED_CLIENT_CACHE_NAME, key = "#clientId", cacheManager = CacheConstant.REDIS_CACHE_MANAGER_NAME, unless = "#result==null")
    public Mono<Oauth2RegisteredClient> findOauth2RegisteredClientByClientId(String clientId) {
        return oauth2RegisteredClientRepository.findByClientId(clientId);
    }
}
