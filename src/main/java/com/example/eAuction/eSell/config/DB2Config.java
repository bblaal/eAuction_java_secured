package com.example.eAuction.eSell.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.example.eAuction.eSell.repository",
        entityManagerFactoryRef = "db2EntityManagerRef",
        transactionManagerRef = "db2TransactionManager"
)
public class DB2Config {

    @Autowired
    Environment environment;

    // datasource bean
    @Bean
    public DataSource db2DataSource() {
        // init DriverManagerDataSource
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

        // set data source objects from app.properties
        driverManagerDataSource.setUrl(environment.getProperty("second.datasource.url"));
        driverManagerDataSource.setDriverClassName(environment.getProperty("second.datasource.driver-class-name"));
        driverManagerDataSource.setUsername(environment.getProperty("second.datasource.username"));
        driverManagerDataSource.setPassword(environment.getProperty("second.datasource.password"));

        // return datasource
        return driverManagerDataSource;
    }

    // entityManagerFactory bean
    @Bean
    public LocalContainerEntityManagerFactoryBean db2EntityManagerRef() {
        // in it localContainerEntityManagerFactoryBean
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        // set datasource to em
        localContainerEntityManagerFactoryBean.setDataSource(db2DataSource());
        // scan entity package
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.example.eAuction.eSell.model");
        // Add hibernate Vendors Adapters
        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto",
                environment.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect",
                environment.getProperty("hibernate.dialect"));
        localContainerEntityManagerFactoryBean.setJpaPropertyMap(properties);

        // return localContainerEntityManagerFactoryBean
        return localContainerEntityManagerFactoryBean;
    }

    // transaction manager bean
    @Bean
    public PlatformTransactionManager db2TransactionManager() {
        //in it JPTransactionManager
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        // set previously created entityManagerFactory bean
        jpaTransactionManager.setEntityManagerFactory(db2EntityManagerRef().getObject());
        // return JPTransactionManager
        return jpaTransactionManager;
    }
}
