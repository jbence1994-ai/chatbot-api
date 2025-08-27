package com.github.jbence1994ai.chatbot.api.chat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

@ExtendWith(MockitoExtension.class)
public class FakeChatServiceTests {

    @InjectMocks
    private FakeChatService chatService;

    @Test
    public void chatTest() {
        var result = chatService.chat("Greet.");

        assertThat(result, not(nullValue()));
    }
}
