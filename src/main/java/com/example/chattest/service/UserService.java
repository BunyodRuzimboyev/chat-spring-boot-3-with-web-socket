package com.example.chattest.service;

import com.example.chattest.repository.UserRepository;
import com.example.chattest.dto.UserDTO;
import com.example.chattest.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    public ResponseEntity addUser(UserDTO dto) {

        User user = User.builder()
                .name(dto.getName())
                .username(dto.getUsername())
                .build();

        User savedUser = repository.save(user);

        return ResponseEntity.ok(savedUser);

    }


}
