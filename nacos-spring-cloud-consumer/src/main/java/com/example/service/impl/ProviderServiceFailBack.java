package com.example.service.impl;

import com.example.domain.Stock;
import com.example.service.ProviderService;
import org.springframework.stereotype.Component;

/**
 * @author liuwl
 * @since 2021/5/20
 */
@Component
public class ProviderServiceFailBack implements ProviderService {
    @Override
    public String provider1() {
        return "此处熔断P1";
    }

    @Override
    public String provider2(Stock stock) {
        return "此处熔断P2";
    }
}
