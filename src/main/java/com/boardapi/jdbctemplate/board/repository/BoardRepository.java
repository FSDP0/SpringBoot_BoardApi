package com.boardapi.jdbctemplate.board.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.boardapi.jdbctemplate.board.entity.Board;
import com.boardapi.jdbctemplate.board.utils.BoardSQLProps;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BoardRepository {
    private final JdbcTemplate jdbcTemplate;
    private final BoardSQLProps boardSQLProps;

    private final RowMapper<Board> boardMapper = BeanPropertyRowMapper.newInstance(Board.class);

    public BoardRepository(JdbcTemplate jdbcTemplate, BoardSQLProps boardSQLProps) {
        this.jdbcTemplate = jdbcTemplate;
        this.boardSQLProps = boardSQLProps;
    }

    public List<Board> findAllBoard() {
        log.info("\\... Repository");

        StringBuilder SQL = new StringBuilder(boardSQLProps.getSELECT_ALL());

        log.info("\n[ Sending SQL Query ] " + SQL.toString());

        return this.jdbcTemplate.query(SQL.toString(), boardMapper);
    }

    public Board findBoardById(Long id) {
        log.info("\\... Repository");

        StringBuilder SQL = new StringBuilder(boardSQLProps.getSELECT_BY_ID());

        log.info("\n[ Sending SQL Query ] " + SQL.toString());

        return this.jdbcTemplate.queryForObject(SQL.toString(), boardMapper, id);
    }

    public void saveBoard(Board board) {
        log.info("\\... Repository");

        StringBuilder SQL = new StringBuilder(boardSQLProps.getINSERT_BOARD());

        log.info("\n[ Sending SQL Query ] " + SQL.toString());

        this.jdbcTemplate.update(SQL.toString(), board.getBoardTitle(), board.getUserId(),
                board.getBoardContent(), LocalDateTime.now());
    }

    public void editBoard(Long id, Board board) {
        log.info("\\... Repository");

        StringBuilder SQL = new StringBuilder(boardSQLProps.getUPDATE_BY_ID());

        log.info("\n[ Sending SQL Query ] " + SQL.toString());

        this.jdbcTemplate.update(SQL.toString(), board.getBoardTitle(), board.getBoardContent(),
                LocalDateTime.now(), id);
    }

    public void deleteBoard(Long id) {
        log.info("\\... Repository");

        StringBuilder SQL = new StringBuilder(boardSQLProps.getDELETE_BY_ID());

        log.info("\n[ Sending SQL Query ] " + SQL.toString());

        this.jdbcTemplate.update(SQL.toString(), id);
    }
}
