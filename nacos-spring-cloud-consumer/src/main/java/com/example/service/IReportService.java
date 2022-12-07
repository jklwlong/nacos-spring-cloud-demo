package com.example.service;

import com.example.domain.Report;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liuwl
 * @since 2022-12-05
 */
public interface IReportService extends IService<Report> {

    String testGlobal();

}
