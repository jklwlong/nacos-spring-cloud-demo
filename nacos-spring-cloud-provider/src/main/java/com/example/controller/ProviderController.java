package com.example.controller;

import com.example.domain.Stock;
import com.example.service.IStockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liuwl
 * @since 2021/5/19
 */
@Slf4j
@RefreshScope
@RestController
public class ProviderController {
    // 来自nacos配置中心
    @Value("${test.str}")
    private String str;

    @Resource
    private IStockService stockService;

    @RequestMapping("/provider1")
    public String provider1() {
        log.info("provider-响应-provider1");
        return str;
    }

    @RequestMapping("/provider2")
    public String provider2(@RequestBody Stock stock) {
        log.info("provider-响应-provider2");
        stockService.testGlobal(stock);
        return str;
    }
}
