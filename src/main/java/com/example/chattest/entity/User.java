package com.example.chattest.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity(name = "_user")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String username;

}
