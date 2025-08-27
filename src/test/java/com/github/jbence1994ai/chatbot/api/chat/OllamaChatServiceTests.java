package com.github.jbence1994ai.chatbot.api.chat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ai.ollama.OllamaChatModel;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OllamaChatServiceTests {

    @Mock
    private OllamaChatModel ollamaChatModel;

    @InjectMocks
    private OllamaChatService chatService;

    @Test
    public void chatTest_HappyPath() {
        when(ollamaChatModel.call("Greet.")).thenReturn("Hello, World!");

        var result = assertDoesNotThrow(() -> chatService.chat("Greet."));

        assertThat(result.getMessage(), not(nullValue()));
    }

    @Test
    public void chatTest_UnhappyPath_OllamaException() {
        doThrow(OllamaException.class).when(ollamaChatModel).call("Greet.");

        var result = assertThrows(
                OllamaException.class,
                () -> chatService.chat("Greet.")
        );

        assertThat(result.getMessage(), equalTo("Ollama currently unavailable."));
    }
}
