package com.skillbridge.dto;

import java.util.Map;

public record AssessmentSubmitRequest(
        Long userId,
        String skill,
        Map<Long, Integer> answers) {
}
