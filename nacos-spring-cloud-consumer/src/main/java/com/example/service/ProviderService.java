package com.example.service;

import com.example.domain.Stock;
import com.example.service.impl.ProviderServiceFailBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liuwl
 * @since 2021/5/20
 */
@FeignClient(value="service-provider")// , fallback = ProviderServiceFailBack.class
public interface ProviderService {

    @RequestMapping("/provider1")
    String provider1();

    @RequestMapping("/provider2")
    String provider2(Stock stock);
}
