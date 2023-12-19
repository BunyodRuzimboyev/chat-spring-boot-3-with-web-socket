package com.example.chattest.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "_chat")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long first;
    private Long second;

}
