package com.github.jbence1994ai.chatbot.api.chat;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.ai")
public record SystemPromptConfig(String systemPrompt) {
}
