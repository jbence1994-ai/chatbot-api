package com.github.jbence1994ai.chatbot.api.chat;

public class OllamaException extends RuntimeException {
    public OllamaException() {
        super("Ollama currently unavailable.");
    }
}
