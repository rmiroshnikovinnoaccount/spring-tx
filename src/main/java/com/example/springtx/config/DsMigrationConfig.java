package com.example.springtx.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan
@EnableTransactionManagement
@EnableJdbcRepositories(basePackages = {
        "com.example.springtx.repository"
}, transactionManagerRef = "dsMigrationTxManager")
public class DsMigrationConfig {

    @Bean(name = "dsMigrationTxManager")
    public PlatformTransactionManager dsMigrationTxManager() {
        return new DataSourceTransactionManager(migrationDataSource());
    }

    @Bean(name = "migrationDataSource")
    @ConfigurationProperties(prefix = "spring.migration-datasource")
    public DataSource migrationDataSource() {
        return new DriverManagerDataSource();
    }
}
