package com.boardapi.jdbcnamedtemplate.board.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Component
@PropertySource("classpath:board/board.xml")
@ConfigurationProperties(prefix = "board")
@Getter
@Setter
public class BoardSQLProps {
    private String SELECT_ALL;
    private String SELECT_BY_ID;

    private String INSERT_BOARD;

    private String UPDATE_BY_ID;

    private String DELETE_BY_ID;
}