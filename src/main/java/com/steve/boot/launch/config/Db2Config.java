package com.steve.boot.launch.config;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
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
        entityManagerFactoryRef = "secondaryEntityManager",
        transactionManagerRef = "transactionManager",
        basePackages = {"com.steve.boot.launch.dao.db2"}
)
public class Db2Config {

    @Resource
    private JpaVendorAdapter jpaVendorAdapter;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSourceProperties db2DataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource db2DataSource() throws SQLException {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        DataSourceProperties db2DataSourceProperties = db2DataSourceProperties();
        mysqlXADataSource.setURL(db2DataSourceProperties.getUrl());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setPassword(db2DataSourceProperties.getPassword());
        mysqlXADataSource.setUser(db2DataSourceProperties.getUsername());
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSourceClassName("db2");
        xaDataSource.setUniqueResourceName("db2");
        xaDataSource.setXaDataSource(mysqlXADataSource);
        xaDataSource.setBorrowConnectionTimeout(60);
        xaDataSource.setMaxPoolSize(20);
        return  xaDataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean secondaryEntityManager() throws Throwable{
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.transaction.jta.platform", AtomikosJtaPlatform.class.getName());
        properties.put("javax.persistence.transactionType", "JTA");
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setJtaDataSource(db2DataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactoryBean.setPackagesToScan("com.steve.boot.launch.dao.db2");
        entityManagerFactoryBean.setPersistenceUnitName("db2PersistenceUnit");
        entityManagerFactoryBean.setJpaPropertyMap(properties);
        return entityManagerFactoryBean;
    }

}
