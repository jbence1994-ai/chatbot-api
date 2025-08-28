package com.github.jbence1994ai.chatbot.api.chat;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OllamaChatService implements ChatService {
    private final SystemPromptConfig systemPromptConfig;
    private final OllamaChatModel ollamaChatModel;

    @Override
    public ChatResponse chat(ChatRequest request) {
        try {
            var systemMessage = new SystemMessage(systemPromptConfig.systemPrompt());
            var userMessage = new UserMessage(request.prompt());
            var prompt = new Prompt(List.of(systemMessage, userMessage));

            var message = ollamaChatModel.call(prompt)
                    .getResult()
                    .getOutput()
                    .getText();

            return new ChatResponse(message);
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new OllamaException();
        }
    }

    @Override
    public Flux<ChatResponse> chatStream(ChatRequest request) {
        try {
            var systemMessage = new SystemMessage(systemPromptConfig.systemPrompt());
            var userMessage = new UserMessage(request.prompt());
            var prompt = new Prompt(List.of(systemMessage, userMessage));

            return ollamaChatModel.stream(prompt)
                    .mapNotNull(chatResponse -> chatResponse.getResult().getOutput().getText())
                    .map(ChatResponse::new);
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new OllamaException();
        }
    }
}
