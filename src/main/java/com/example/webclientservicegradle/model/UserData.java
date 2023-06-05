package com.example.webclientservicegradle.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserData implements Serializable {

    private Long id;
    @NotNull
    private Long userId;
    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String lastName;

    private LocalDateTime registrationDate;
}
