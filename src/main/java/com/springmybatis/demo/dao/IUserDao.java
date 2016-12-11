package com.springmybatis.demo.dao;

import org.springframework.stereotype.Component;

import com.springmybatis.demo.bean.User;

@Component
public interface IUserDao {
  int deleteByPrimaryKey(String userId);

  int insert(User user);

  int insertSelective(User user);

  User selectByPrimaryKey(String userId);

  int updateByPrimaryKeySelective(User user);

  int updateByPrimaryKey(User user);
}
