package com.demo.apptypea.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPatient;

    @Column(length = 70, nullable = false)
    private String firstName;

    @Column(length = 70, nullable = false)
    private String lastName;

    @Column(length = 70, nullable = false)
    private String email;

    @Column(length = 9, nullable = false)
    private String phone;

    @Column(length = 8, nullable = false)
    private String dni;
}
