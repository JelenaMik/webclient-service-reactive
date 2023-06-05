package com.example.webclientservicegradle.client;

import com.example.webclientservicegradle.model.AppointmentDto;
import com.example.webclientservicegradle.model.AppointmentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class AppointmentsRestClient {

    private WebClient webClient;

    @Value("${restClient.appointmentUrl}")
    private String appointmentUrl;

    public AppointmentsRestClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Object[]> retrieveAppointments(){
        return webClient.get()
                .uri(appointmentUrl)
                .retrieve()
                .bodyToMono(Object[].class);
    }

    public Mono<Object> createAppointment(AppointmentRequest request){

        return webClient.post()
                .uri(appointmentUrl)
//                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), AppointmentRequest.class)
                .retrieve()
                .bodyToMono(Object.class);
    }

    public Mono<Object> getAppointmentById(String id){
        return webClient.get()
                .uri(appointmentUrl+"/"+id)
                .retrieve()
                .bodyToMono(Object.class);
    }

    public Mono<Object> bookAppointment(String clientId, String appointmentId, String details){
        return webClient.put()
                .uri(appointmentUrl+"/book?clientId=" + clientId + "&appointmentId=" + appointmentId+ "&details=" + details)
                .retrieve()
                .bodyToMono(Object.class);
    }

    public Mono<Object> changeAppointmentType(String appointmentType, String appointmentId){
        return webClient.put()
                .uri(appointmentUrl+"/change-type?appointmentType="+appointmentType + "&appointmentId="+appointmentId)
                .retrieve()
                .bodyToMono(Object.class);
    }

    //does not work. returns 200, but do not delete DB entry
    public Mono<Void> deleteAppointment(String id) {
        return webClient.delete()
                .uri(appointmentUrl+"/"+id)
                .retrieve()
                .bodyToMono(Void.class).then();
    }

    public Mono<Object> cancelAppointment(String id){
        return webClient.put()
                .uri(appointmentUrl+"/"+id)
                .retrieve()
                .bodyToMono(Object.class);
    }

    public Flux<Object> getAllUsersAppointments(String userId, String role) {
        return webClient.get()
                .uri(appointmentUrl+"/all/"+userId+"?role="+role)
                .retrieve()
                .bodyToFlux(Object.class);
    }
}
