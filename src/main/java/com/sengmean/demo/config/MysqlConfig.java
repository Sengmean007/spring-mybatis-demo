//package com.sengmean.demo.config;
//
//        import org.springframework.beans.factory.annotation.Value;
//        import org.springframework.boot.autoconfigure.domain.EntityScan;
//        import org.springframework.boot.jdbc.DataSourceBuilder;
//        import org.springframework.context.annotation.Bean;
//        import org.springframework.context.annotation.Configuration;
//        import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.task.AsyncTaskExecutor;
//import org.springframework.jdbc.datasource.init.DataSourceInitializer;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import com.mysql.cj.xdevapi.SessionFactory;
//
//import javax.sql.DataSource;
//
///**
// * Sengmean 01/04/2019
// */
//@Configuration
//@EntityScan("com.sengmean.demo.model")
//@EnableTransactionManagement
//@PropertySource("classpath:application.properties")
//public class MysqlConfig {
//
//    @Value("${spring..datasource.driver-class-name}") String driverClassName;
//    @Value("${spring.datasource.url}") String url;
//    @Value("${spring.datasource.username}") String username;
//    @Value("${spring.datasource.password}") String password;
//    @Bean(name = "dataSource")
//    public DataSource getDataSource() {
//        return DataSourceBuilder
//                .create()
//                .username(username)
//                .password(password)
//                .url(url)
//                .build();
//    }
//
//    @Bean(name = "sessionFactory")
//    public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
//        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
////        sessionBuilder.scanPackages("");
//        sessionBuilder.buildSessionFactory((AsyncTaskExecutor) dataSource);
//        return null;
//    }
//
//    @Bean(name = "transactionManager")
//    public HibernateTransactionManager getTransactionManager (
//            SessionFactory sessionFactory) {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager(
//        );
//        return transactionManager;
//    }
//
//    @Bean
//    public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
//        final DataSourceInitializer initializer = new DataSourceInitializer();
//        initializer.setDataSource(dataSource);
//        return initializer;
//    }
//}
