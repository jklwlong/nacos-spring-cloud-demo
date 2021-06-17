package com.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liuwl
 * @since 2021/5/20
 */
@FeignClient(value="service-consumer")
public interface ConsumerService {

    @RequestMapping("/consumer1")
    String consumer1();
}
