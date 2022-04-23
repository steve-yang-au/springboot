package com.steve.boot.launch.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

//    @Primary
//    @Bean("db1DataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.db1")
//    public DataSource db1DataSource(){
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean("db2DataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.db2")
//    public DataSource db2DataSource(){
//        return DataSourceBuilder.create().build();
//    }
    @Primary
    @Bean(name="db1DataSource", initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "atomikos.datasource.db1")
    public DataSource db1DataSource(){
        return new AtomikosDataSourceBean();
    }

    @Bean(name="db2DataSource", initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "atomikos.datasource.db2")
    public DataSource db2DataSource(){
        return new AtomikosDataSourceBean();
    }

    @Primary
    @Bean("primaryJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("db1DataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean("secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("db2DataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
