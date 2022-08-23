package com.demo.apptypea.service.impl;

import com.demo.apptypea.model.VitalSigns;
import com.demo.apptypea.repo.IGenericRepo;
import com.demo.apptypea.repo.IVitalSignsRepo;
import com.demo.apptypea.service.IVitalSignsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VitalSignsServiceImpl extends CRUDImpl<VitalSigns, Integer> implements IVitalSignsService {

    @Autowired
    private IVitalSignsRepo repo;
    @Override
    protected IGenericRepo<VitalSigns, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<VitalSigns> listPage(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
