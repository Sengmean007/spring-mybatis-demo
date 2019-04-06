package com.sengmean.demo.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.EmptyStackException;

/**
 * Sengmean 01/04/2019
 */
@Configuration
@MapperScan("com.sengmean.demo.repository")
public class MybatisConfig {

    @Autowired
    private DataSource dataSource;

    public MybatisConfig(){
        super();
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean () throws EmptyStackException {
        SqlSessionFactoryBean sqlSessionFactoryBean  = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() throws EmptyStackException{
        return new DataSourceTransactionManager(dataSource);
    }
}
