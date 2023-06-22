package com.boardapi.jdbctemplate2.user.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.boardapi.jdbctemplate2.user.entity.User;
import com.boardapi.jdbctemplate2.user.sql.AddressSQL;
import com.boardapi.jdbctemplate2.user.sql.UserSQL;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<User> userRowMapper = BeanPropertyRowMapper.newInstance(User.class);

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> findAllUsers() {
        log.info("\\... Repository");

        StringBuilder SQL = new StringBuilder(UserSQL.SELECT_ALL);

        log.info("\n[ Sending SQL Query ]\n" + SQL.toString());

        return this.jdbcTemplate.query(SQL.toString(), userRowMapper);
    }

    public User findUserById(String userId) {
        log.info("\\... Repository");

        StringBuilder SQL = new StringBuilder(UserSQL.SELECT_BY_USER_ID);

        log.info("\n[ Sending SQL Query ]\n" + SQL.toString());

        return this.jdbcTemplate.queryForObject(SQL.toString(), userRowMapper, userId);
    }

    public void saveUser(User user) {
        log.info("\\... Repository");

        StringBuilder userSQL = new StringBuilder(UserSQL.INSERT_USER);
        StringBuilder addressSQL = new StringBuilder(AddressSQL.INSERT_ADDRESS);

        log.info("\n[ Sending SQL Query ]\n" + userSQL.toString());
        log.info("\n[ Sending SQL Query ]\n" + addressSQL.toString());

        this.jdbcTemplate.update(userSQL.toString(), user.getUserId(), user.getUserName(),
                user.getUserPassword(), user.getUserTel(), LocalDateTime.now());

        this.jdbcTemplate.update(addressSQL.toString(), user.getUserId(), user.getUserAddress(),
                user.getAddressZipcode());
    }

    public void editUser(String userId, User user) {
        log.info("\\... Repository");

        StringBuilder userSQL = new StringBuilder(UserSQL.UPDATE_USER_BY_USER_ID);
        StringBuilder addressSQL = new StringBuilder(AddressSQL.UPDATE_ADDRESS_BY_USER_ID);

        log.info("\n[ Sending SQL Query ]\n" + userSQL.toString());
        log.info("\n[ Sending SQL Query ]\n" + addressSQL.toString());

        this.jdbcTemplate.update(userSQL.toString(), user.getUserName(), user.getUserPassword(),
                user.getUserTel(), LocalDateTime.now(), userId);

        this.jdbcTemplate.update(addressSQL.toString(), user.getUserAddress(),
                user.getAddressZipcode(), userId);
    }

    public void deleteUser(String userId) {
        log.info("\\... Repository");

        StringBuilder SQL = new StringBuilder(UserSQL.DELETE_BY_USER_ID);

        log.info("\n[ Sending SQL Query ]\n" + SQL.toString());

        this.jdbcTemplate.update(SQL.toString(), userId);
    }
}
