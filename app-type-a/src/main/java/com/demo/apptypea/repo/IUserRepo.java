package com.demo.apptypea.repo;

import com.demo.apptypea.model.User;

public interface IUserRepo extends IGenericRepo<User, Integer> {

    User findOneByUsername(String username);
}
