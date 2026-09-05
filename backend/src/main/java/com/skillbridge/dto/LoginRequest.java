package com.skillbridge.dto;

public record LoginRequest(
        String email,
        String password) {
}
