package com.example.chattest.service;

import com.example.chattest.component.FirstEnter;
import com.example.chattest.dto.MessageDTO;
import com.example.chattest.dto.WebSocketType;
import com.example.chattest.dto.WebSocketUserDTO;
import com.example.chattest.dto.WsEvent;
import com.example.chattest.entity.Message;
import com.example.chattest.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final SimpMessagingTemplate brokerMessagingTemplate;
    private final MessageRepository messageRepository;

    public ResponseEntity send(MessageDTO dto) {

        Message message = Message.builder()
                .text(dto.getMessage())
                .chatId(FirstEnter.chatId)
                .time(new Timestamp(System.currentTimeMillis()))
                .fromWhom(dto.getFromWhom())
                .toWhom(dto.getToWhom())
                .build();
        Message save = messageRepository.save(message);

        brokerMessagingTemplate.convertAndSend("/our-websocket", new WebSocketUserDTO(dto.getToWhom(), WebSocketType.MESSAGE,  WsEvent.NEW_MESSAGE));
        //brokerMessagingTemplate.convertAndSend("/our-websocket", "Test");
        return ResponseEntity.ok(save);

    }


}
