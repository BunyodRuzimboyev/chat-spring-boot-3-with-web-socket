package com.example.chattest.controller;

import com.example.chattest.service.UserService;
import com.example.chattest.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {


    private final UserService service;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserDTO dto) {
        return service.addUser(dto);
    }
}
