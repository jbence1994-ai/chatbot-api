package com.github.jbence1994ai.chatbot.api.chat;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OllamaChatService implements ChatService {
    private final SystemPromptConfig systemPromptConfig;
    private final OllamaChatModel ollamaChatModel;

    @Override
    public Chat chat(String message) {
        try {
            var systemMessage = new SystemMessage(systemPromptConfig.systemPrompt());
            var userMessage = new UserMessage(message);
            var prompt = new Prompt(List.of(systemMessage, userMessage));

            var response = ollamaChatModel.call(prompt)
                    .getResult()
                    .getOutput()
                    .getText();

            return new Chat(response);
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new OllamaException();
        }
    }
}
