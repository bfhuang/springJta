package com.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bfhuang on 7/6/17.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "secondEntityManagerFactory",
        transactionManagerRef = "secondTransactionManager",
        basePackages = {"com.seconddb" })
public class SecondDBConfiguration {

    @Bean
    @ConfigurationProperties("second.datasource")
    public DataSourceProperties secondDataSourceProperties() {
        return new DataSourceProperties();
    }


    @Bean
    @ConfigurationProperties("second.datasource")
    public DataSource secondDatasource() {
        return secondDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean secondEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {

        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", "create");
        return builder
                .dataSource(secondDatasource())
                .packages("com.seconddb")
                .persistenceUnit("seconddb")
                .properties(properties)
                .build();
    }


    @Bean
    public PlatformTransactionManager secondTransactionManager(
            @Qualifier("secondEntityManagerFactory") EntityManagerFactory
                    entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(entityManagerFactory);
        return jpaTransactionManager;
    }
}
