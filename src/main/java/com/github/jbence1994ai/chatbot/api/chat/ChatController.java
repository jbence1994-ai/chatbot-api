package com.github.jbence1994ai.chatbot.api.chat;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class ChatController {
    private final ChatService chatService;

    @PostMapping
    public ChatResponse chat(@Valid @RequestBody ChatRequest request) {
        log.info("ChatRequest with conversation ID: {}", request.conversationId());

        var chatResponse = chatService.chat(request);

        log.info("ChatResponse for conversation ID: {}", request.conversationId());

        return chatResponse;
    }

    @PostMapping("/stream")
    public Flux<ChatResponse> chatStream(@Valid @RequestBody ChatRequest request) {
        log.info("ChatRequest with conversation ID: {}", request.conversationId());

        var chatResponse = chatService.chatStream(request);

        log.info("ChatResponse for conversation ID: {}", request.conversationId());

        return chatResponse;
    }
}
