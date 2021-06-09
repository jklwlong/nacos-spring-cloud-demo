package com.example.controller;

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
@RefreshScope
@RestController
public class ProviderController {

    @Value("${test.str}")
    private String str;

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @RequestMapping("/provider1")
    public String provider1() {
//        return applicationContext.getEnvironment().getProperty("test.str");
        return str;
    }
}
