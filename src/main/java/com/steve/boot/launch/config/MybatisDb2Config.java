package com.steve.boot.launch.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(
        basePackages = "com.steve.boot.launch.mapper.db2",
        sqlSessionTemplateRef = "sqlSessionTemplateSecondary"

)
public class MybatisDb2Config {

    @Bean(name="db2DataSource", initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "atomikos.datasource.db2")
    public DataSource db2DataSource(){
        return new AtomikosDataSourceBean();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactorySecondary(@Qualifier("db2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/db2/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean("sqlSessionTemplateSecondary")
    SqlSessionTemplate sqlSessionTemplateSecondary(@Qualifier("sqlSessionFactorySecondary") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
