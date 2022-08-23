package com.demo.apptypea.service.impl;

import com.demo.apptypea.model.Patient;
import com.demo.apptypea.model.VitalSigns;
import com.demo.apptypea.repo.IGenericRepo;
import com.demo.apptypea.repo.IPatientRepo;
import com.demo.apptypea.service.IPatientService;
import com.demo.apptypea.service.IVitalSignsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PatientImpl extends CRUDImpl<Patient, Integer> implements IPatientService {

    @Autowired
    private IPatientRepo repo;
    @Override
    protected IGenericRepo<Patient, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Patient> listPage(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
