package com.github.jbence1994ai.chatbot.api.common;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "chatbot-api.client-app")
public record ClientAppConfig(String url) {
}
