package com.hibernate.hibernate.config;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DataSourceSingleton {

    private DataSourceSingleton(){

    }

    private static class Holder{
        private final static DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
    }

    public static DriverManagerDataSource getDataSource(){
        String jdbcUrl = "jdbc:mysql://localhost:3306/spring_in_action";
        String jdbcUsername = "root";
        String jdbcPassword = "root";


        Holder.driverManagerDataSource.setUrl(jdbcUrl);
        Holder.driverManagerDataSource.setUsername(jdbcUsername);
        Holder.driverManagerDataSource.setPassword(jdbcPassword);


        return Holder.driverManagerDataSource;
    }

}
