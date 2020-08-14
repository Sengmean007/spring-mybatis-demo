package com.sengmean.demo.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

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
