package com.boardapi.jdbctemplate.board.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boardapi.jdbctemplate.board.model.BoardDto;
import com.boardapi.jdbctemplate.board.service.BoardSerivce;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("boards")
public class BoardController {
    private final BoardSerivce boardSerivce;

    private BoardController(BoardSerivce boardSerivce) {
        this.boardSerivce = boardSerivce;
    }

    @GetMapping
    private List<BoardDto> findAllBoard() {
        return this.boardSerivce.getAllBoards();
    }

    @GetMapping("/:{id}")
    private BoardDto findBoardById(@PathVariable Long id) {
        log.info("\\... Controller");
        log.info("[ Success Process ] Received parameter : " + id);

        return this.boardSerivce.getBoardById(id);
    }

    @PostMapping
    private void createBoard(@RequestBody BoardDto boardDto) {
        this.boardSerivce.createBoard(boardDto);
    }

    @PutMapping("/:{id}")
    private void editBoard(@PathVariable Long id, @RequestBody BoardDto boardDto) {
        log.info("\\... Controller");
        log.info("[ Success Process ] Received parameter : " + id);

        this.boardSerivce.modifyBoard(id, boardDto);
    }

    @DeleteMapping("/:{id}")
    private void deleteBoard(@PathVariable Long id) {
        log.info("\\... Controller");
        log.info("[ Success Process ] Received parameter : " + id);

        this.boardSerivce.removeBoard(id);
    }
}
