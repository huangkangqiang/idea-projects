package com.example.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

/**
 * Created by huang on 2018/5/20.
 * =============================================
 */
@Configuration
//配置mybatis mapper的扫描路径
@MapperScan("com.example.demo.dao")
public class DataSourceConfiguration {

    @Value(value = "${jdbc.driver}")
    private String jdbcDriver;
    @Value(value = "${jdbc.url}")
    private String jdbcUrl;
    @Value(value = "${jdbc.username}")
    private String jdbcUsername;
    @Value(value = "${jdbc.password}")
    private String jdbcPassword;

    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //设置数据库驱动
        dataSource.setDriverClass(jdbcDriver);
        //设置数据库url
        dataSource.setJdbcUrl(jdbcUrl);
        //设置数据库用户名
        dataSource.setUser(jdbcUsername);
        //设置数据库密码
        dataSource.setPassword(jdbcPassword);
        //关闭连接后不自动commit
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
}
