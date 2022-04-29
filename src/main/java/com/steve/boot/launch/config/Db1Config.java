package com.steve.boot.launch.config;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;

@Configuration
@DependsOn("transactionManager")
@EnableJpaRepositories(
        entityManagerFactoryRef = "primaryEntityManager",
        transactionManagerRef = "transactionManager",
        basePackages = {"com.steve.boot.launch.dao.db1"}
)
public class Db1Config {

    @Resource
    private JpaVendorAdapter jpaVendorAdapter;

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSourceProperties db1DataSourceProperties() {
        return new DataSourceProperties();
    }
    @Primary
    @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource db1DataSource() throws SQLException {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        DataSourceProperties db1DataSourceProperties = db1DataSourceProperties();
        mysqlXADataSource.setURL(db1DataSourceProperties.getUrl());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setPassword(db1DataSourceProperties.getPassword());
        mysqlXADataSource.setUser(db1DataSourceProperties.getUsername());
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSourceClassName("db1");
        xaDataSource.setUniqueResourceName("db1");
        xaDataSource.setXaDataSource(mysqlXADataSource);
        xaDataSource.setBorrowConnectionTimeout(60);
        xaDataSource.setMaxPoolSize(20);
        return  xaDataSource;
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean primaryEntityManager() throws Throwable{
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.transaction.jta.platform", AtomikosJtaPlatform.class.getName());
        properties.put("javax.persistence.transactionType", "JTA");
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setJtaDataSource(db1DataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactoryBean.setPackagesToScan("com.steve.boot.launch.dao.db1");
        entityManagerFactoryBean.setPersistenceUnitName("db1PersistenceUnit");
        entityManagerFactoryBean.setJpaPropertyMap(properties);
        return entityManagerFactoryBean;
    }

}
