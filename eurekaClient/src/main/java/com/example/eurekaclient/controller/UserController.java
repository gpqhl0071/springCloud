package com.example.eurekaclient.controller;

import com.example.eurekaclient.bean.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gao peng
 * @date 2019/9/26 16:29
 */
@RestController
@RequestMapping("user")
public class UserController {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @GetMapping("/{id:\\d+}")
  public User get(@PathVariable Long id) {
    log.info("获取用户id为 " + id + "的信息");
    return new User(id, "mrbird", "123456");
  }

  @GetMapping
  public List<User> get() {
    List<User> list = new ArrayList<>();
    list.add(new User(1L, "mrbird", "123456"));
    list.add(new User(2L, "scott", "123456"));
    log.info("获取用户信息 " + list);
    return list;
  }

  @PostMapping
  public void add(@RequestBody User user) {
    log.info("新增用户成功 " + user);
  }

  @PutMapping
  public void update(@RequestBody User user) {
    log.info("更新用户成功 " + user);
  }

  @DeleteMapping("/{id:\\d+}")
  public void delete(@PathVariable Long id) {
    log.info("删除用户成功 " + id);
  }

}
