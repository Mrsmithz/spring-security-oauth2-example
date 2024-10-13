package com.example.springsecurityoauth2example.authentication;

import lombok.Getter;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AuthorizationGrantAuthenticationToken;

import java.util.Map;
import java.util.Set;

@Getter
public class GoogleAuthenticationToken extends OAuth2AuthorizationGrantAuthenticationToken {

    public static final AuthorizationGrantType AUTHORIZATION_GRANT_TYPE = AuthorizationGrantType.AUTHORIZATION_CODE;
    private final Set<String> scopes;

    protected GoogleAuthenticationToken(Set<String> scopes, Authentication clientPrincipal, Map<String, Object> additionalParameters) {
        super(AUTHORIZATION_GRANT_TYPE, clientPrincipal, additionalParameters);
        this.scopes = Set.copyOf(scopes);
    }
}
