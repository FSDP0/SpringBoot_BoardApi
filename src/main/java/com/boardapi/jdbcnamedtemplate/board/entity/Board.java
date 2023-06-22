package com.boardapi.jdbcnamedtemplate.board.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Board {
    private Long boardId;

    private String boardTitle;
    private String userId;
    private String boardContent;

    private Date createdDate;
    private Date modifiedDate;

    @Builder
    public Board(Long id, String title, String author, String content, Date createdDate, Date modifiedDate) {
        this.boardId = id;
        this.boardTitle = title;
        this.boardContent = content;
        this.userId = author;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
