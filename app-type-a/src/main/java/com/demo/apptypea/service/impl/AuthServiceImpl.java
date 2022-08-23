package com.demo.apptypea.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl {

    public boolean hasAccess(String path) {

        boolean rpta = false;

        String metodoRol = "";

        switch (path){
            case "findAll":
                metodoRol = "ADMIN";
                break;
            case "findById":
                metodoRol = "USER,DBA";
                break;
        }

        String metodoRoles[] = metodoRol.split(",");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        for (GrantedAuthority grantedAuthority : auth.getAuthorities()) {
            String rolUser = grantedAuthority.getAuthority();
            System.out.println("rolUser = " + rolUser);

            for (String rolMet : metodoRoles) {
                if(rolUser.equals(rolMet)) {
                    rpta = true;
                    break;
                }
            }
        }

        return rpta;
    }
}
