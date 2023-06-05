package com.example.webclientservicegradle.model;

import com.example.webclientservicegradle.enums.AppointmentStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentDetailDto {

    private String appointmentDetailId;
    @NotNull
    private String appointmentId;
    private AppointmentStatus status;

    private LocalDateTime created;
}
