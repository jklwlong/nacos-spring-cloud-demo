package com.example.service;

import com.example.domain.Stock;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liuwl
 * @since 2022-12-05
 */
public interface IStockService extends IService<Stock> {

    void testGlobal(Stock stock);
}
