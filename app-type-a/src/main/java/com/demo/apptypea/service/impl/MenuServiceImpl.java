package com.demo.apptypea.service.impl;


import com.demo.apptypea.model.Menu;
import com.demo.apptypea.repo.IGenericRepo;
import com.demo.apptypea.repo.IMenuRepo;
import com.demo.apptypea.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl extends CRUDImpl<Menu, Integer> implements IMenuService {

    @Autowired
    private IMenuRepo repo;

    @Override
    public List<Menu> getMenusByUsername(String username) {
        //String username = SecurityContextHolder.getContext().getAuthentication().getName();
       // return repo.getMenusByUsername(username);
        return repo.getMenusByUsername(username);
    }

    @Override
    protected IGenericRepo<Menu, Integer> getRepo() {
        return repo;
    }
}
