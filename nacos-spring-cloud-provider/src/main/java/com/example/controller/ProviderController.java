package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuwl
 * @since 2021/5/19
 */
@Slf4j
@RefreshScope
@RestController
public class ProviderController {

    @Value("${test.str}")
    private String str;

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @RequestMapping("/provider1")
    public String provider1() {
        log.info("provider-响应-provider1");
        return str;
    }
}
