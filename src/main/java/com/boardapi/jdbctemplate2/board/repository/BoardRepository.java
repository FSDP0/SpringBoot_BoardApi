package com.boardapi.jdbctemplate2.board.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.boardapi.jdbctemplate2.board.entity.Board;
import com.boardapi.jdbctemplate2.board.sql.BoardSQL;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BoardRepository {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Board> boardMapper = BeanPropertyRowMapper.newInstance(Board.class);

    public BoardRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Board> findAllBoard() {
        log.info("\\... Repository");

        StringBuilder SQL = new StringBuilder(BoardSQL.SELECT_ALL);

        log.info("\n[ Sending SQL Query ]\n" + SQL.toString());

        return this.jdbcTemplate.query(SQL.toString(), boardMapper);
    }

    public Board findBoardById(Long id) {
        log.info("\\... Repository");

        StringBuilder SQL = new StringBuilder(BoardSQL.SELECT_BY_ID);

        log.info("\n[ Sending SQL Query ]\n" + SQL.toString());

        return this.jdbcTemplate.queryForObject(SQL.toString(), boardMapper, id);
    }

    public void saveBoard(Board board) {
        log.info("\\... Repository");

        StringBuilder SQL = new StringBuilder(BoardSQL.INSERT_BOARD);

        log.info("\n[ Sending SQL Query ]\n" + SQL.toString());

        this.jdbcTemplate.update(SQL.toString(), board.getBoardTitle(), board.getUserId(),
                board.getBoardContent(), LocalDateTime.now());
    }

    public void editBoard(Long id, Board board) {
        log.info("\\... Repository");

        StringBuilder SQL = new StringBuilder(BoardSQL.UPDATE_BY_ID);

        log.info("\n[ Sending SQL Query ]\n" + SQL.toString());

        this.jdbcTemplate.update(SQL.toString(), board.getBoardTitle(), board.getBoardContent(),
                LocalDateTime.now(), id);
    }

    public void deleteBoard(Long id) {
        log.info("\\... Repository");

        StringBuilder SQL = new StringBuilder(BoardSQL.DELETE_BY_ID);

        log.info("\n[ Sending SQL Query ]\n" + SQL.toString());

        this.jdbcTemplate.update(SQL.toString(), id);
    }
}
