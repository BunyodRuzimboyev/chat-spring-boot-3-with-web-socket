package com.example.chattest.component;

import com.example.chattest.entity.Chat;
import com.example.chattest.entity.User;
import com.example.chattest.repository.ChatRepository;
import com.example.chattest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FirstEnter implements CommandLineRunner {


    public static Long chatId = null;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String initialModeType;

    private final UserRepository userRepository;
    private final ChatRepository chatRepository;

    @Override
    public void run(String... args) throws Exception {

        if (initialModeType.equals("create") || initialModeType.equals("create-drop")) {

            User user1 = User.builder()
                    .username("test1")
                    .name("example1")
                    .build();

            User savedUser1 = userRepository.save(user1);

            User user2 = User.builder()
                    .username("test2")
                    .name("example2")
                    .build();

            User savedUser2 = userRepository.save(user2);

            Chat chat = Chat.builder()
                    .first(savedUser1.getId())
                    .second(savedUser2.getId())
                    .build();

            Chat savedChat = chatRepository.save(chat);
            chatId = savedChat.getId();
        }
    }
}
