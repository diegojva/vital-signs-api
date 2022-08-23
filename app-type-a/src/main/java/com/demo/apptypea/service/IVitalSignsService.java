package com.demo.apptypea.service;

import com.demo.apptypea.model.VitalSigns;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IVitalSignsService extends ICRUD<VitalSigns, Integer>{

    Page<VitalSigns> listPage(Pageable pageable);
}
