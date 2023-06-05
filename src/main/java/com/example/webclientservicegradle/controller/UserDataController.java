package com.example.webclientservicegradle.controller;

import com.example.webclientservicegradle.client.UserDataRestClient;
import com.example.webclientservicegradle.model.UserData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user-data")
@RequiredArgsConstructor
public class UserDataController {

    private final UserDataRestClient userDataRestClient;

    @PostMapping
    public Mono<Object> saveUserData(@RequestBody UserData userData){
        return userDataRestClient.saveUserData(userData);
    }

    @GetMapping("/all-user-data")
    public Flux<Object> getAllUserData(){
        return userDataRestClient.getAllUserData();
    }

    @GetMapping("/get-data/{id}")
    public Mono<Object> getUserData(@PathVariable String id){
        return userDataRestClient.getUserData(id);
    }

    @PutMapping
    public Mono<Object> updateUserData(@RequestBody  UserData userData){
        return userDataRestClient.updateUserData(userData);
    }

    @GetMapping("/search-users")
    public Flux<Object> searchUserDataByName(String firstname){
        return userDataRestClient.searchByName(firstname);
    }
}
