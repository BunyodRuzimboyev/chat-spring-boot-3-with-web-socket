package com.example.chattest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebSocketUserDTO {
    private Long id;
    private WebSocketType type;
    private WsEvent evently;
}


