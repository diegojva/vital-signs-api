package com.demo.apptypea.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VitalSigns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVitalSigns;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String temperature;

    @Column(nullable = false)
    private String pulse;

    @Column(nullable = false)
    private String rhythm;

    @ManyToOne
    @JoinColumn(name = "id_patient", nullable = false,
            foreignKey = @ForeignKey (name="FK_PATIENT_VITAL_SIGNS"))
    private Patient patient;
}
