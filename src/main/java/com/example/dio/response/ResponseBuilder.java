package com.example.dio.response;

import org.springframework.http.ResponseEntity;

public class ResponseBuilder {

    public static <T> ResponseEntity<T> buildResponse(T data) {
        return ResponseEntity.ok(data);
    }

    public static ResponseEntity<String> buildErrorResponse(String message) {
        return ResponseEntity.badRequest().body(message);
    }
}