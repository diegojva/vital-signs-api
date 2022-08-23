package com.demo.apptypea.controller;

import com.demo.apptypea.dto.VitalSignsDTO;
import com.demo.apptypea.exception.ModelNotFoundException;
import com.demo.apptypea.model.VitalSigns;
import com.demo.apptypea.service.IVitalSignsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vitalsigns")
public class VitalSignsController {

    @Autowired
    private IVitalSignsService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<VitalSignsDTO>> findAll() {
        List<VitalSignsDTO> list = service.findAll().stream().map(p -> mapper.map(p, VitalSignsDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VitalSignsDTO> findById(@PathVariable("id") Integer id) {
        VitalSignsDTO dtoResponse;
        VitalSigns obj = service.findById(id);
        if (obj == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        } else {
            dtoResponse = mapper.map(obj, VitalSignsDTO.class);
        }
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody VitalSignsDTO dto) {
        VitalSigns vitalSigns = mapper.map(dto,VitalSigns.class);
        service.save(vitalSigns);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vitalSigns.getIdVitalSigns()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<VitalSigns> update(@Valid @RequestBody VitalSignsDTO dto) {
        VitalSigns obj = service.findById(dto.getIdVitalSigns());
        if (obj == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + dto.getIdVitalSigns());
        }

        return new ResponseEntity<>(service.update(mapper.map(dto, VitalSigns.class)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
        VitalSigns obj = service.findById(id);
        if (obj == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        } else {
            service.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
