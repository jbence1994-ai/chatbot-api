package com.github.jbence1994ai.chatbot.api.chat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OllamaChatServiceTests {

    @Mock
    private SystemPromptUtil systemPromptUtil;

    @Mock
    private OllamaChatModel ollamaChatModel;

    @InjectMocks
    private OllamaChatService chatService;

    @BeforeEach
    public void setUp() {
        when(systemPromptUtil.getSystemPrompt()).thenReturn("You're a help-desk assistant.");
    }

    @Test
    public void chatTest_HappyPath() {
        when(ollamaChatModel.call(any(Prompt.class))).thenReturn(new ChatResponse(List.of(new Generation(new AssistantMessage("Hello, World!")))));

        var result = assertDoesNotThrow(() -> chatService.chat(new ChatRequest("Greet.", UUID.randomUUID())));

        assertThat(result.message(), not(nullValue()));
    }

    @Test
    public void chatTest_UnhappyPath_OllamaException() {
        doThrow(OllamaException.class).when(ollamaChatModel).call(any(Prompt.class));

        var result = assertThrows(
                OllamaException.class,
                () -> chatService.chat(new ChatRequest("Greet.", UUID.randomUUID()))
        );

        assertThat(result.getMessage(), equalTo("Ollama currently unavailable."));
    }
}
