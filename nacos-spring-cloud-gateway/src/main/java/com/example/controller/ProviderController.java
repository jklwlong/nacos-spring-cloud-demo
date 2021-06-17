package com.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.service.ConsumerService;
import com.example.service.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author liuwl
 * @since 2021/5/19
 */
@Slf4j
@RestController
public class ProviderController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private ProviderService providerService;

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping("/consumer1")
    public String consumer1() {
        log.info("gateway-restTemplate-请求-service-consumer/consumer2");
        return restTemplate.postForObject("http://service-consumer/consumer2", null, String.class);
    }

    @RequestMapping("/consumer2")
    @SentinelResource("resource")
    public String consumer2() {
        log.info("gateway-Feign-请求-provider1");
        return providerService.provider1();
    }

    @RequestMapping("/consumer3")
    public String consumer3() {
        log.info("gateway-Feign-请求-consumer1");
        return consumerService.consumer1();
    }
}
