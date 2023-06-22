package com.boardapi.jdbcnamedtemplate.user.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.boardapi.jdbcnamedtemplate.user.entity.User;
import com.boardapi.jdbcnamedtemplate.user.utils.UserSQLProps;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UserRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final UserSQLProps userSQLProps;

    private final RowMapper<User> userRowMapper = BeanPropertyRowMapper.newInstance(User.class);

    public UserRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, UserSQLProps userSQLProps) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.userSQLProps = userSQLProps;
    }

    public List<User> findAllUsers() {
        log.info("\\... Repository");

        String SQL = userSQLProps.getSELECT_ALL();

        log.info("\n[ Sending SQL Query ]\n" + SQL);

        return this.namedParameterJdbcTemplate.query(SQL, userRowMapper);
    }

    public User findUserById(String userId) {
        log.info("\\... Repository");

        String SQL = userSQLProps.getSELECT_BY_USER_ID();
        SqlParameterSource namedParameter = new MapSqlParameterSource("userId", userId);

        log.info("\n[ Sending SQL Query ]\n" + SQL);

        return this.namedParameterJdbcTemplate.queryForObject(SQL, namedParameter, userRowMapper);
    }

    public void saveUser(User user) {
        log.info("\\... Repository");

        user.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));

        String userSQL = userSQLProps.getINSERT_USER();
        String addressSQL = userSQLProps.getINSERT_ADDRESS();

        log.info("\n[ Sending SQL Query ]\n" + userSQL);
        log.info("\n[ Sending SQL Query ]\n" + addressSQL);

        SqlParameterSource userNamedParameterSource = new BeanPropertySqlParameterSource(user);
        this.namedParameterJdbcTemplate.update(userSQL, userNamedParameterSource);

        SqlParameterSource addressNamedParameterSource = new BeanPropertySqlParameterSource(user);
        this.namedParameterJdbcTemplate.update(addressSQL, addressNamedParameterSource);
    }

    public void editUser(String userId, User user) {
        log.info("\\... Repository");

        user.setUserId(userId);
        user.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));

        String userSQL = userSQLProps.getUPDATE_USER_BY_USER_ID();
        String addressSQL = userSQLProps.getUPDATE_ADDRESS_BY_USER_ID();

        log.info("\n[ Sending SQL Query ]\n" + userSQL);
        log.info("\n[ Sending SQL Query ]\n" + addressSQL);

        SqlParameterSource userNamedParameterSource = new BeanPropertySqlParameterSource(user);
        this.namedParameterJdbcTemplate.update(userSQL, userNamedParameterSource);

        SqlParameterSource addressNamedParameterSource = new BeanPropertySqlParameterSource(user);
        this.namedParameterJdbcTemplate.update(userSQL, addressNamedParameterSource);
    }

    public void deleteUser(String userId) {
        log.info("\\... Repository");

        String SQL = userSQLProps.getDELETE_BY_USER_ID();

        log.info("\n[ Sending SQL Query ]\n" + SQL);

        SqlParameterSource namedParameter = new MapSqlParameterSource("userId", userId);

        this.namedParameterJdbcTemplate.update(SQL, namedParameter);
    }
}
