package com.example.springsecurityoauth2example.service.implement;

import com.example.springsecurityoauth2example.constant.TokenStatus;
import com.example.springsecurityoauth2example.entity.Authorization;
import com.example.springsecurityoauth2example.repository.AuthorizationRepository;
import com.example.springsecurityoauth2example.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthorizationRepository authorizationRepository;

    @Override
    public void revokeToken(String accessToken) {
        Mono<Authorization> authorization = authorizationRepository.findByAccessTokenValueAndTokenStatus(accessToken, TokenStatus.ACTIVE);
        authorization
                .switchIfEmpty(Mono.error(new IllegalArgumentException(String.format("access token %s not found", accessToken))))
                .flatMap(entry -> {
                    entry.setTokenStatus(TokenStatus.INACTIVE);
                    entry.setAccessTokenMetadata(updateMetaData(entry.getAccessTokenMetadata()));
                    return Mono.just(entry);
                })
                .flatMap(authorizationRepository::save)
                .doOnSuccess(
                        value -> log.info("revoke token {} successfully", accessToken)
                )
                .subscribe();
    }

    private String updateMetaData(String metaDataString) {
        Document bsonDocument = Document.parse(metaDataString);
        bsonDocument.put("metadata.token.invalidated", true);
        return bsonDocument.toJson();
    }
}
