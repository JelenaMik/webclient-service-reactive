package com.example.webclientservicegradle.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@Slf4j
public class UserRestClient {
    private WebClient webClient;

    @Value("${restClient.appointmentUrl}")
    private String appointmentUrl;

    public UserRestClient(WebClient webClient) {
        this.webClient = webClient;
    }
}
