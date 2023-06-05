package com.example.webclientservicegradle.model;


import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentRequest {
    @NotNull
    private Long providerId;
    @FutureOrPresent
    private String startDate;
    @NotNull
    @NotBlank
    private String startHour;
    private String appointmentType;

}
