package com.boardapi.jdbctemplate2.board.sql;

public class BoardSQL {
        public final static String SELECT_ALL = """
                        SELECT *
                        FROM boards.board
                        """;

        public final static String SELECT_BY_ID = """
                        SELECT *
                        FROM boards.board
                        WHERE board_id = ?
                        """;

        public final static String INSERT_BOARD = """
                        INSERT INTO boards.board(
                            board_title,
                            user_id,
                            board_content,
                            created_date
                        ) VALUES(?, ?, ?, ?)
                        """;

        public final static String UPDATE_BY_ID = """
                        UPDATE boards.board
                        SET board_title = ?,
                            board_content = ?,
                            modified_date = ?
                        WHERE board_id = ?
                        """;

        public final static String DELETE_BY_ID = """
                        DELETE
                        FROM boards.board
                        WHERE board_id = ?
                        """;
}
