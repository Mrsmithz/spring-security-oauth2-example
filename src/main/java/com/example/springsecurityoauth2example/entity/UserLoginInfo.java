package com.example.springsecurityoauth2example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user_login_info")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserLoginInfo {

    @Id
    @JsonIgnore
    private String id;

    @JsonIgnore
    private Instant timestamp;

    private String email;

    private String displayName;
}
