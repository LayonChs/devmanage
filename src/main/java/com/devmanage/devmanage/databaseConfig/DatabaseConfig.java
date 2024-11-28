package com.devmanage.devmanage.databaseConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/devmanage");
        dataSource.setUsername("root");
        dataSource.setPassword("L@yon9479");
        return dataSource;
    }

    public JdbcTemplate db(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    
}
