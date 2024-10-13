package com.example.springsecurityoauth2example.repository;

import com.example.springsecurityoauth2example.entity.UserLoginInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginInfoRepository extends MongoRepository<UserLoginInfo, String> {
}
