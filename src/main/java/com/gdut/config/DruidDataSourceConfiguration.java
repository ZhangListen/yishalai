package com.gdut.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 数据库连接池
 * Created by huang on 2017/1/6.
 */
@Configuration
public class DruidDataSourceConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        System.out.println("druidDataSource started!!!!!!!!!!!!!!!!!!!1");
        DruidDataSource druidDataSource = new DruidDataSource();
        try {
            //关闭druid的解析功能
            druidDataSource.setFilters("wall,stat");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return druidDataSource;
    }
}