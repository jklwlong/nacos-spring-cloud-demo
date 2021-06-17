package com.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.service.ProviderService;
import lombok.extern.slf4j.Slf4j;
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

    @RequestMapping("/consumer1")
    public String consumer1() {
        log.info("consumer-restTemplate-请求-service-provider/provider1");
        return restTemplate.postForObject("http://service-provider/provider1", null, String.class);
    }

    @RequestMapping("/consumer2")
    @SentinelResource("resource")
    public String consumer2() {
        log.info("consumer-Feign-请求-provider1");
        return providerService.provider1();
    }
}
