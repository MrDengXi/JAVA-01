package com.linyuan.mysql.datasourceroute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author DengXi
 * @Date 2021/3/8 9:36 上午
 * @desc:描述
 */
public class DataSourceRoute extends AbstractRoutingDataSource {

    @Autowired
    private DBContextHolder dbContextHolder;

    @Override
    protected Object determineCurrentLookupKey() {
        String dataSourceRoutingKey = dbContextHolder.get();
        return dataSourceRoutingKey;
    }
}
