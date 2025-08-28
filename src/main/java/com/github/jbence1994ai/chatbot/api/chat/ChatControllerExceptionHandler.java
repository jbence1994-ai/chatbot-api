package com.github.jbence1994ai.chatbot.api.chat;

import com.github.jbence1994ai.chatbot.api.common.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = ChatController.class)
public class ChatControllerExceptionHandler {

    @ExceptionHandler(exception = OllamaException.class)
    public ResponseEntity<ErrorResponse> handleOllamaException(OllamaException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(exception.getMessage()));
    }
}
