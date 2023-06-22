package com.boardapi.jdbctemplate.user.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.boardapi.jdbctemplate.user.entity.User;
import com.boardapi.jdbctemplate.user.utils.UserSQLProps;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final UserSQLProps userSQLProps;

    private final RowMapper<User> userRowMapper = BeanPropertyRowMapper.newInstance(User.class);

    public UserRepository(JdbcTemplate jdbcTemplate, UserSQLProps userSQLProps) {
        this.jdbcTemplate = jdbcTemplate;
        this.userSQLProps = userSQLProps;
    }

    public List<User> findAllUsers() {
        StringBuilder SQL = new StringBuilder(userSQLProps.getSELECT_ALL());

        log.info("\\... Repository");
        log.info("\n[ Sending SQL Query ]" + SQL.toString());

        return this.jdbcTemplate.query(SQL.toString(), userRowMapper);
    }

    public User findUserById(String userId) {
        StringBuilder SQL = new StringBuilder(userSQLProps.getSELECT_BY_USER_ID());

        log.info("\\... Repository");
        log.info("\n[ Sending SQL Query ]" + SQL.toString());

        return this.jdbcTemplate.queryForObject(SQL.toString(), userRowMapper, userId);
    }

    public void saveUser(User user) {
        StringBuilder userSQL = new StringBuilder(userSQLProps.getINSERT_USER());
        StringBuilder addressSQL = new StringBuilder(userSQLProps.getINSERT_ADDRESS());

        log.info("\\... Repository");
        log.info("\n[ Sending SQL Query ]" + userSQL.toString());
        log.info("\n[ Sending SQL Query ]" + addressSQL.toString());

        this.jdbcTemplate.update(userSQL.toString(), user.getUserId(), user.getUserName(),
                user.getUserPassword(), user.getUserTel(), LocalDateTime.now());

        this.jdbcTemplate.update(addressSQL.toString(), user.getUserId(), user.getUserAddress(),
                user.getAddressZipcode());
    }

    public void editUser(String userId, User user) {
        StringBuilder userSQL = new StringBuilder(userSQLProps.getUPDATE_USER_BY_USER_ID());
        StringBuilder addressSQL = new StringBuilder(userSQLProps.getUPDATE_ADDRESS_BY_USER_ID());

        log.info("\\... Repository");
        log.info("\n[ Sending SQL Query ]" + userSQL.toString());
        log.info("\n[ Sending SQL Query ]" + addressSQL.toString());

        this.jdbcTemplate.update(userSQL.toString(), user.getUserName(), user.getUserPassword(),
                user.getUserTel(), LocalDateTime.now(), userId);

        this.jdbcTemplate.update(addressSQL.toString(), user.getUserAddress(),
                user.getAddressZipcode(), userId);
    }

    public void deleteUser(String userId) {
        StringBuilder SQL = new StringBuilder(userSQLProps.getDELETE_BY_USER_ID());

        log.info("\\... Repository");
        log.info("\n[ Sending SQL Query ]" + SQL.toString());

        this.jdbcTemplate.update(SQL.toString(), userId);
    }
}
