package com.example.service.impl;

import com.example.domain.Stock;
import com.example.mapper.StockMapper;
import com.example.service.IStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

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
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements IStockService {

    @Resource
    private StockMapper stockMapper;

    @Override
    public void testGlobal(Stock stock) {
        Stock st = stockMapper.selectById(stock.getId());
        st.setNum(st.getNum() - 1);
        stockMapper.updateById(st);
    }
}
