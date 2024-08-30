package com.example.eAuction.eListing.config;

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
        basePackages = "com.example.eAuction.eListing.repository",
        entityManagerFactoryRef = "db1EntityManagerRef",
        transactionManagerRef = "db1TransactionManager"
)
public class DB1Config {

    @Autowired
    Environment environment;

    // datasource bean
    @Bean
    @Primary
    public DataSource db1DataSource() {
        // init DriverManagerDataSource
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

        // set data source objects from app.properties
        driverManagerDataSource.setUrl(environment.getProperty("spring.datasource.url"));
        driverManagerDataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        driverManagerDataSource.setUsername(environment.getProperty("spring.datasource.username"));
        driverManagerDataSource.setPassword(environment.getProperty("spring.datasource.password"));

        // return datasource
        return driverManagerDataSource;
    }

    // entityManagerFactory bean
    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean db1EntityManagerRef() {
        // init localContainerEntityManagerFactoryBean
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        // set datasource to em
        localContainerEntityManagerFactoryBean.setDataSource(db1DataSource());
        // scan entity package
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.example.eAuction.eListing.model");
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
    @Primary
    public PlatformTransactionManager db1TransactionManager() {
        //in it JPATransactionManager
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        // set previously created entityManagerFactory bean
        jpaTransactionManager.setEntityManagerFactory(db1EntityManagerRef().getObject());
        // return JPTransactionManager
        return jpaTransactionManager;
    }
}
