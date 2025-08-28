package com.github.jbence1994ai.chatbot.api.chat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ChatControllerTests {

    @Mock
    private ChatService chatService;

    @InjectMocks
    private ChatController chatController;

    @Test
    public void chatTest() {
        when(chatService.chat(any())).thenReturn(new ChatResponse("Hello, World!"));

        var result = chatController.chat(new ChatRequest("Greet.", UUID.randomUUID()));

        assertThat(result, not(nullValue()));
        assertThat(result.message(), not(nullValue()));
    }
}
