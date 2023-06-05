package com.example.webclientservicegradle.controller;

import com.example.webclientservicegradle.client.AppointmentsRestClient;
import com.example.webclientservicegradle.model.AppointmentDto;
import com.example.webclientservicegradle.model.AppointmentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentsRestClient appointmentsRestClient;

    @GetMapping
    public Mono<Object[]> retrieveAppointments(){
        return appointmentsRestClient.retrieveAppointments();
    }

    @PostMapping
    public Mono<Object> createAppointments(@RequestBody AppointmentRequest request){
        return appointmentsRestClient.createAppointment(request);
    }

    @GetMapping("/{id}")
    public Mono<Object> retrieveAppointments(@PathVariable String id){
        return appointmentsRestClient.getAppointmentById(id);
    }

    @PutMapping("/book")
    public Mono<Object> bookAppointment(String clientId,String appointmentId,String details){
        return appointmentsRestClient.bookAppointment(clientId, appointmentId, details);
    }

    @PutMapping("/change-type")
    public Mono<Object> changeAppointmentType(String appointmentType, String appointmentId){
        return appointmentsRestClient.changeAppointmentType(appointmentType,appointmentId);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteAppointments(@PathVariable String id){
        return appointmentsRestClient.deleteAppointment(id);
    }

    @PutMapping("/cancel/{id}")
    public Mono<Object> cancelAppointment(@PathVariable String id){
        return appointmentsRestClient.cancelAppointment(id);
    }

    @GetMapping("/all/{userId}")
    public Flux<Object> getAllAppointments(@PathVariable String userId, String role){
        return appointmentsRestClient.getAllUsersAppointments(userId, role);
    }


}
