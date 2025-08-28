package com.github.jbence1994ai.chatbot.api.chat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.charset.StandardCharsets.UTF_8;

@Component
@Slf4j
public class SystemPromptUtil {

    public String getSystemPrompt() {
        String systemPrompt = "";

        try {
            systemPrompt = Files.readString(Path.of("system_prompt.txt"), UTF_8);
        } catch (IOException ignored) {
        }

        return systemPrompt;
    }
}
