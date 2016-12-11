package com.springmybatis.demo.service;

import com.springmybatis.demo.bean.User;

public interface IUserService {

  User addUser(String id, String name, String password, int age);
  
  User getUserById(String userId);
  
  boolean deleteUserById(String userId);
  
  boolean updateUser(User user);
}
