package com.linyuan.geektime.dubbohmilytccdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @Author linyuan
 * @desc:描述
 */
@Slf4j
public class DynamicSourceContext extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> holders = new ThreadLocal<>();

    public DynamicSourceContext(DataSource defaultDataSource, Map<Object, Object> targetDataSources){
        super.setDefaultTargetDataSource(defaultDataSource);
        super.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSourceName();
    }

    public static void setDataSourceName(String dataSourceName){
        holders.set(dataSourceName);
    }

    public static String getDataSourceName(){
        String name = holders.get();
        log.info("determineCurrentLookupKey ---->{} -----", name);
        return name;
    }

    public static void clearDataSource() {
        holders.remove();
    }
}