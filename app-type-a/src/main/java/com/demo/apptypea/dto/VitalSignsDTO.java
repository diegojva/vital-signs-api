package com.demo.apptypea.dto;

import com.demo.apptypea.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VitalSignsDTO {

    private Integer idVitalSigns;

    @NotNull
    private LocalDate date;

    @NotNull
    private String temperature;

    @NotNull
    private String pulse;

    @NotNull
    private String rhythm;

    @NotNull
    private Patient patient;
}
