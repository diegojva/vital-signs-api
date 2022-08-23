package com.demo.apptypea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {

    private Integer idPatient;

    @NotEmpty
    @Size(min = 2, message = "{firstName.size}")
    private String firstName;

    @NotNull
    @Size(min = 2, message = "{lastName.size}")
    private String lastName;

    @Size(min = 8,  message = "{dni.size}")
    private String dni;

    @NotNull
    @Size(min = 9, max = 9, message = "{phone.size}")
    private String phone;

    @NotNull
    @Email
    private String email;

}
