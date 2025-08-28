package com.github.jbence1994ai.chatbot.api.chat;

import reactor.core.publisher.Flux;

public interface ChatService {
    ChatResponse chat(ChatRequest request);

    Flux<ChatResponse> chatStream(ChatRequest request);
}
