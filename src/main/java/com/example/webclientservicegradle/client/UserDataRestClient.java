package com.example.webclientservicegradle.client;

import com.example.webclientservicegradle.model.UserData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class UserDataRestClient {
    private WebClient webClient;

    @Value("${restClient.userDataUrl}")
    private String userDataUrl;

    public UserDataRestClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Object> saveUserData(UserData userData){
        return webClient.post()
                .uri(userDataUrl)
                .body(Mono.just(userData), UserData.class)
                .retrieve()
                .bodyToMono(Object.class);
    }

    public Flux<Object> getAllUserData (){
        return webClient.get()
                .uri(userDataUrl+"/all-user-data")
                .retrieve()
                .bodyToFlux(Object.class);
    }

    public Mono<Object> getUserData(String id){
        return webClient.get()
                .uri(userDataUrl+"/get-data/"+id)
                .retrieve()
                .bodyToMono(Object.class);
    }

    public Mono<Object> updateUserData(UserData userData){
        return webClient.put()
                .uri(userDataUrl)
                .body(Mono.just(userData), UserData.class)
                .retrieve()
                .bodyToMono(Object.class);
    }

    public Flux<Object> searchByName(String firstName){
        return webClient.get()
                .uri(userDataUrl+"/search-users?firstName="+firstName)
                .retrieve()
                .bodyToFlux(Object.class);
    }
}
