package com.example.chattest.entity;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity(name = "_message")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private Long fromWhom;
    private Long toWhom;

    private Long chatId;

    private Timestamp time = new Timestamp(System.currentTimeMillis());

}
