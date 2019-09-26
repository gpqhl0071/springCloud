package com.example.serverconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author gao peng
 * @date 2019/9/26 14:11
 */
@RestController
public class TestController {
  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/info")
  public String getInfo() {
    return this.restTemplate.getForEntity("http://Server-Provider/info", String.class).getBody();
  }
}
