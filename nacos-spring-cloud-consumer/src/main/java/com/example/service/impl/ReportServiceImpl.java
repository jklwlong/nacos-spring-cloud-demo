package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.Report;
import com.example.domain.Stock;
import com.example.mapper.ReportMapper;
import com.example.service.IReportService;
import com.example.service.ProviderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuwl
 * @since 2022-12-05
 */
@Service
public class ReportServiceImpl extends ServiceImpl<ReportMapper, Report> implements IReportService {

    @Resource
    private ReportMapper reportMapper;

    @Resource
    private ProviderService providerService;

    @Resource
    private RestTemplate restTemplate;

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
//    @GlobalLock
    public String testGlobal() {
        Report report = new Report();
        report.setName("名字");
        report.setType("类型");
        report.setDay("今天");
        report.setStartTime("开始");
        report.setEndTime("结束");
        report.setUseTime("10分钟");
        reportMapper.insert(report);

        Stock stock = new Stock();
        stock.setId(1);
        // 当Feign使用了FailBack时Seata无法感知异常，事务不回滚，需要判断返回值主动抛出异常
        String res = providerService.provider2(stock);
//        throw new RuntimeException();
//        String res = restTemplate.postForObject("http://service-provider/provider2", stock, String.class);
        int i=1/0;
        return res;
    }

}
