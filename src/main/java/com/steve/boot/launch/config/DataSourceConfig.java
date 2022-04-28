package com.steve.boot.launch.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSourceProperties dataSourceOneProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSourceProperties dataSourceTwoProperties() {
        return new DataSourceProperties();
    }

    /**
     *
     *The following pooling DataSource implementations are supported by this builder. When no type has been explicitly set, the first available pool implementation will be picked:
     *
     * Hikari (com.zaxxer.hikari.HikariDataSource)
     * Tomcat JDBC Pool (org.apache.tomcat.jdbc.pool.DataSource)
     * Apache DBCP2 (org.apache.commons.dbcp2.BasicDataSource)
     * Oracle UCP (oracle.ucp.jdbc.PoolDataSourceImpl)
     * The following non-pooling DataSource implementations can be used when explicitly set as a type:
     *
     * Spring's SimpleDriverDataSource (org.springframework.jdbc.datasource.SimpleDriverDataSource)
     * Oracle (oracle.jdbc.datasource.OracleDataSource)
     * H2 (org.h2.jdbcx.JdbcDataSource)
     * Postgres (org.postgresql.ds.PGSimpleDataSource)
     * Any DataSource implementation with appropriately named methods
     */
    @Primary
    @Bean("db1DataSource")
    public DataSource db1DataSource(@Qualifier("dataSourceOneProperties") DataSourceProperties properties){
        return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
        //return properties.initializeDataSourceBuilder().type(SimpleDriverDataSource.class).build();
    }

    @Bean("db2DataSource")
    public DataSource db2DataSource(@Qualifier("dataSourceTwoProperties") DataSourceProperties properties){
        return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
        //return properties.initializeDataSourceBuilder().type(SimpleDriverDataSource.class).build();
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
