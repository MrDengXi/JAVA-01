package com.linyuan.mysql02.datasourceroute;

import org.springframework.stereotype.Component;

/**
 * @Author DengXi
 * @Date 2021/3/8 9:39 上午
 * @desc:描述
 */
@Component
public class DBContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public String get(){
        String dataSourceRoutingKey = contextHolder.get();
        if(dataSourceRoutingKey == null){
            // 默认数据源1
            dataSourceRoutingKey = DataSourceConstants.DATA_SOURCE1;
        }
        return dataSourceRoutingKey;
    }

    public void useDataSource2() {
        contextHolder.remove();
        contextHolder.set(DataSourceConstants.DATA_SOURCE2);
    }

    public void clear(){
        contextHolder.remove();
    }
}
