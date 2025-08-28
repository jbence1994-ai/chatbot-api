package com.github.jbence1994ai.chatbot.api.chat;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class ChatController {
    private final ChatService chatService;

    @PostMapping
    public ChatResponse chat(@Valid @RequestBody ChatRequest request) {
        log.info("ChatRequest received with conversation ID: {}", request.conversationId());

        var chat = chatService.chat(request.prompt());

        log.info("ChatResponse generated for conversation ID: {}", request.conversationId());

        return new ChatResponse(chat.getMessage());
    }
}
