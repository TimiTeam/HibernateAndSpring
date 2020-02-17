package com.gmail.timurworkspace.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("com.gmail.timurworkspace")
@PropertySource("classpath:/database.properties")
@EnableTransactionManagement
public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource getDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getLocalSessionFactoryBean(){
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());
        factoryBean.setPackagesToScan("com.gmail.timurworkspace");
        factoryBean.setHibernateProperties(getHibernateProperties());
        return factoryBean;
    }

    private Properties getHibernateProperties(){
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        properties.put("hibernate.current_session_context_class", environment.getProperty("hibernate.current_session_context_class"));
        properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        properties.put("hibernate.connection.pool_size", environment.getProperty("hibernate.connection.pool_size"));
        properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
        return properties;
    }

    @Bean
    public HibernateTransactionManager getHibernateTransactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getLocalSessionFactoryBean().getObject());
        return transactionManager;
    }

}
