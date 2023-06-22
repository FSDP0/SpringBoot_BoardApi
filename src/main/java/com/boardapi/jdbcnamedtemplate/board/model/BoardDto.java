package com.boardapi.jdbcnamedtemplate.board.model;

import java.util.Date;
import com.boardapi.jdbcnamedtemplate.board.entity.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardDto {
    private Long num;

    private String title;
    private String writeName;
    private String contents;

    private Date writeDate;
    private Date modifyDate;

    public Board toEntity() {
        Board board =
                Board.builder().id(this.num).title(this.title).author(this.writeName).content(this.contents).build();

        return board;
    }

    @Builder
    public BoardDto(Long num, String title, String writeName, String contents, Date writeDate, Date modifyDate) {
        this.num = num;
        this.title = title;
        this.writeName = writeName;
        this.contents = contents;
        this.writeDate = writeDate;
        this.modifyDate = modifyDate;
    }
}