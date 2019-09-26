package com.example.serverconsumer.controller;

import com.example.serverconsumer.bean.User;
import com.example.serverconsumer.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gao peng
 * @date 2019/9/26 17:10
 */
@RestController
public class TestUserController1 {
  @Autowired
  private UserService userService;

  @GetMapping("hystrixGetUser/{id:\\d+}")
  public User getUser(@PathVariable Long id) {
    return userService.getUser(id);
  }
}
