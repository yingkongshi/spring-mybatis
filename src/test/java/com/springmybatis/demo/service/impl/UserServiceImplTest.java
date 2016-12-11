package com.springmybatis.demo.service.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.springmybatis.demo.bean.User;
import com.springmybatis.demo.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(value="classpath:spring.xml")
//@Transactional
public class UserServiceImplTest {

  @Autowired
  private IUserService userService;
  
  @Before
  public void setUp() throws Exception {}

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testAddUser() {
    userService.addUser("123456", "liu", "abc" ,18);
  }
  
  @Test
  public void testGetUser() {
    userService.addUser("123456", "liu", "abc" ,18);
    User user = userService.getUserById("123456");
    assertTrue(18 == user.getAge());
  }

}
