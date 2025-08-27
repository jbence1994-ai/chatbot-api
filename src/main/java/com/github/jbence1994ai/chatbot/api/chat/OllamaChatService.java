package com.github.jbence1994ai.chatbot.api.chat;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OllamaChatService implements ChatService {
    private final OllamaChatModel ollamaChatModel;

    @Override
    public Chat chat(String prompt) {
        try {
            var response = ollamaChatModel.call(prompt);

            return new Chat(response);
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new OllamaException();
        }
    }
}
