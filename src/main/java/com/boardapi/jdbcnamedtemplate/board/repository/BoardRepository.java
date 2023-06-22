package com.boardapi.jdbcnamedtemplate.board.repository;

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
import com.boardapi.jdbcnamedtemplate.board.entity.Board;
import com.boardapi.jdbcnamedtemplate.board.utils.BoardSQLProps;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BoardRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final BoardSQLProps boardSQLProps;

    private final RowMapper<Board> boardMapper = BeanPropertyRowMapper.newInstance(Board.class);

    public BoardRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, BoardSQLProps boardSQLProps) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.boardSQLProps = boardSQLProps;
    }

    public List<Board> findAllBoard() {
        log.info("\\... Repository");

        String SQL = boardSQLProps.getSELECT_ALL();

        log.info("\n[ Sending SQL Query ] " + SQL);

        return this.namedParameterJdbcTemplate.query(SQL, boardMapper);
    }

    public Board findBoardById(Long id) {
        log.info("\\... Repository");

        String SQL = boardSQLProps.getSELECT_BY_ID();

        log.info("\n[ Sending SQL Query ] " + SQL);

        SqlParameterSource namedParameter = new MapSqlParameterSource("boardId", id);

        return this.namedParameterJdbcTemplate.queryForObject(SQL, namedParameter, boardMapper);
    }

    public void saveBoard(Board board) {
        log.info("\\... Repository");

        board.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));

        String SQL = boardSQLProps.getINSERT_BOARD();

        log.info("\n[ Sending SQL Query ] " + SQL);

        SqlParameterSource namedParameterSource = new BeanPropertySqlParameterSource(board);

        this.namedParameterJdbcTemplate.update(SQL, namedParameterSource);
    }

    public void editBoard(Long id, Board board) {
        log.info("\\... Repository");

        board.setBoardId(id);
        board.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));

        String SQL = boardSQLProps.getUPDATE_BY_ID();

        log.info("\n[ Sending SQL Query ] " + SQL);

        SqlParameterSource namedParameterSource = new BeanPropertySqlParameterSource(board);

        this.namedParameterJdbcTemplate.update(SQL, namedParameterSource);
    }

    public void deleteBoard(Long id) {
        log.info("\\... Repository");

        String SQL = boardSQLProps.getDELETE_BY_ID();

        log.info("\n[ Sending SQL Query ] " + SQL);

        SqlParameterSource namedParameter = new MapSqlParameterSource("boardId", id);

        this.namedParameterJdbcTemplate.update(SQL, namedParameter);
    }
}
