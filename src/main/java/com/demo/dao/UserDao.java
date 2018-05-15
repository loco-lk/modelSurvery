package com.demo.dao;

import com.demo.model.User;

public interface UserDao {
    public abstract User findByUsername(String username);
}
