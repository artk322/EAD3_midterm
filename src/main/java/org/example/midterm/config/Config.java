//package org.example.midterm.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import javax.sql.DataSource;
//
//@Configuration
//@ComponentScan(basePackages = "org.example.midterm")
//
//@EnableJpaRepositories(basePackages = "org.example.midterm.repository")
//
//public class Config {
//
//
//    @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/notes_db");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("postgres");
//
//        return dataSource;
//    }
//
//
//}
