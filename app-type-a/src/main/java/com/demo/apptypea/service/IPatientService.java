package com.demo.apptypea.service;

import com.demo.apptypea.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPatientService extends ICRUD<Patient, Integer>{
    Page<Patient> listPage(Pageable pageable);
}
