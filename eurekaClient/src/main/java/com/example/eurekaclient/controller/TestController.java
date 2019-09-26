package com.example.eurekaclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gao peng
 * @date 2019/9/26 10:29
 */
@RestController
public class TestController {
  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private DiscoveryClient client;

  @GetMapping("/info")
  public String info() {
    @SuppressWarnings("deprecation")
    List<String> list = client.getServices();

    for (String serverId : list) {
      List<ServiceInstance> list1 = client.getInstances(serverId);
      for (ServiceInstance instance : list1) {

        String info = "host：" + instance.getHost() + "，service_id：" + instance.getServiceId();
        log.info(info);
      }
    }
    return "ok";
  }

  @GetMapping("/hello")
  public String hello() {
    return "hello world";
  }
}
