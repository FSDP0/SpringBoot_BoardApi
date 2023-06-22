package com.boardapi.jdbctemplate.user.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Component
@PropertySource("classpath:user/user.xml")
@PropertySource("classpath:user/address.xml")
@ConfigurationProperties(prefix = "user")
@Getter
@Setter
public class UserSQLProps {
    private String SELECT_ALL;
    private String SELECT_BY_USER_ID;

    private String INSERT_USER;
    private String INSERT_ADDRESS;

    private String UPDATE_USER_BY_USER_ID;
    private String UPDATE_ADDRESS_BY_USER_ID;

    private String DELETE_BY_USER_ID;
}
