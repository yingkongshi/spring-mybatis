package com.springmybatis.demo.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(value="classpath:spring.xml")
@Transactional
public class UserControllerTest {

  @Autowired
  private WebApplicationContext wac;
  protected MockMvc mockMvc;
  
  @Before
  public void setUp() throws Exception {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testPost() throws Exception {
    this.mockMvc.perform(post("/user").param("id", "123456").param("name", "liu")
        .param("password", "abc")).andExpect(status().isOk());
  }

  @Test
  public void testGet() throws Exception {
    this.mockMvc.perform(post("/user").param("id", "123456").param("name", "liu").param("password", "abc"))
    .andExpect(status().isOk());
    this.mockMvc.perform(get("/user").param("id", "123456"))
    .andExpect(status().isOk());
  }
}
