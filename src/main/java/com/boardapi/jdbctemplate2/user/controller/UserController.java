package com.boardapi.jdbctemplate2.user.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boardapi.jdbctemplate2.user.model.UserDto;
import com.boardapi.jdbctemplate2.user.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    private UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    private List<UserDto> findAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/:{userId}")
    private UserDto findUserById(@PathVariable String userId) {
        log.info("\\... Controller");
        log.info("[ Success Process ] Received parameter : " + userId);

        return this.userService.getUserById(userId);
    }

    @PostMapping
    private void createUser(@RequestBody UserDto userDto) {
        this.userService.saveUser(userDto);
    }

    @PutMapping("/:{userId}")
    private void modifyUser(@PathVariable String userId, @RequestBody UserDto userDto) {
        log.info("\\... Controller");
        log.info("[ Success Process ] Received parameter : " + userId);

        this.userService.modifyUser(userId, userDto);
    }

    @DeleteMapping("/:{userId}")
    private void deleteUser(@PathVariable String userId) {
        log.info("\\... Controller");
        log.info("[ Success Process ] Received parameter : " + userId);
        this.userService.deleteUser(userId);
    }
}
