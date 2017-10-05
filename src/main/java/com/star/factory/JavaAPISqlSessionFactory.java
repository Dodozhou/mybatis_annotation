package com.star.factory;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

public class JavaAPISqlSessionFactory {
    public static SqlSessionFactory getSqlSessionFactory(){
        SqlSessionFactory sqlSessionFactory=null;
            DataSource dataSource= DataSourceFactory.getDataSource();
            TransactionFactory transactionFactory=new JdbcTransactionFactory();
            Environment environment=new Environment("dev",transactionFactory,dataSource);
            Configuration configuration=new Configuration(environment);
            configuration.getTypeAliasRegistry().registerAliases("com.star.entity");
            configuration.setCacheEnabled(true);
            configuration.addMappers("com.star.mapper");
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(configuration);
            return sqlSessionFactory;
    }
    public static SqlSession getSqlSession(){
        return getSqlSessionFactory().openSession();
    }
}
