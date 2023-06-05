package com.example.webclientservicegradle.model;

import com.example.webclientservicegradle.enums.AppointmentType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentDto {

    private Long appointmentId;

    private Long clientId;
    @NotNull
    private Long providerId;
    @FutureOrPresent
    private LocalDateTime startTime;

    private AppointmentType appointmentType;
    @Size(max = 50)
    private String details;
}
