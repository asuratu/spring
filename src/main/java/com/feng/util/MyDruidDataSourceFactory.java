package com.feng.util;

import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

/**
 * @author AsuraTu
 */
public class MyDruidDataSourceFactory extends PooledDataSourceFactory {
    public MyDruidDataSourceFactory() {
        this.dataSource = new com.alibaba.druid.pool.DruidDataSource();
    }
}
