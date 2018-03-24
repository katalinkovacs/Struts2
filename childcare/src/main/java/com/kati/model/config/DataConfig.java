package com.kati.model.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
public class DataConfig {  //It will create 2 beans!!!!
    //2 beans --> DriverManagerDataSource AND JdbcOperations
    // These will be added to the Application Context created by SPRING


    Logger LOG = LoggerFactory.getLogger(DataConfig.class);

    @Value("${jdbc.url}")
    String jdbcUrl;

    @Value("${jdbc.user}")
    String jdbcUser;

    @Value("${jdbc.password}")
    String jdbcPassword;

    @Value("${jdbc.driverClassName}")
    String jdbcDriverClassName;


    @Autowired
    private Environment env;

    @Bean
    public DriverManagerDataSource dataSource() {

        LOG.info("In DataConfig CLASS - dataSource METHOD ***************** Datasource created ");
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(jdbcUrl);
        ds.setUsername(jdbcUser);
        ds.setPassword(jdbcPassword);
        ds.setDriverClassName(jdbcDriverClassName);
        return ds;
    }

    //This depends on DriverManagerDataSource
    @Bean
    public JdbcOperations jdbcTemplate(DriverManagerDataSource dataSource) {
        LOG.info("In DataConfig CLASS - jdbcTemplate METHOD *****************");
        //JdbcTemplate myJdbcTemplate = new JdbcTemplate(dataSource);
        return new JdbcTemplate(dataSource); // same as return myJdbcTemplate
    }



/*
    // It needs 2 beans --> DriverManagerDataSource AND JdbcOperations !!!!!
    // These will be added to the Application Context created by SPRING

    // BEAN1 --> DriverManagerDataSource
    @Bean
    public DriverManagerDataSource dataSource() {

        System.out.println("In DataConfig CLASS - dataSource METHOD ***************** Datasource created ");

        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        //ds.setUrl("jdbc:mysql://localhost/katidb");
        //ds.setUsername("admin");
        //ds.setPassword("admin");
        ds.setUrl("jdbc:mysql://localhost/fullstackprojectdata");  // DB connection + auth
        ds.setUsername("root");
        ds.setPassword("mysql");
        return ds;

    }

    // BEAN2  --> JdbcOperations
    @Bean
    public JdbcOperations jdbcTemplate(DriverManagerDataSource dataSource) {

        System.out.println("In DataConfig CLASS - jdbcTemplate METHOD *****************");
        return new JdbcTemplate(dataSource);
    }

*/

}
