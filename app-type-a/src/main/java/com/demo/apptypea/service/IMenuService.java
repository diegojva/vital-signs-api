package com.demo.apptypea.service;

import com.demo.apptypea.model.Menu;

import java.util.List;

public interface IMenuService extends ICRUD<Menu, Integer> {
    List<Menu> getMenusByUsername(String username);
}
