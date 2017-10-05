package com.star.factory;

import org.apache.ibatis.datasource.pooled.PooledDataSource;

import javax.sql.DataSource;

public class DataSourceFactory {
    public static DataSource getDataSource() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "root";
        PooledDataSource dataSource = new PooledDataSource(driver, url, username, password);
        return dataSource;
    }

}
