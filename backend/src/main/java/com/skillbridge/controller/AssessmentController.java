package com.skillbridge.controller;

import com.skillbridge.dto.AssessmentSubmitRequest;
import com.skillbridge.model.AssessmentQuestion;
import com.skillbridge.service.AssessmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/assessments")
public class AssessmentController {

    private final AssessmentService assessmentService;

    public AssessmentController(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }

    /**
     * Returns assessment questions for the selected skill.
     * Example: GET /api/assessments/Docker
     */
    @GetMapping("/{skill}")
    public List<Map<String, Object>> getQuestions(@PathVariable String skill) {
        return assessmentService.questions(skill)
                .stream()
                .map(this::toQuestionResponse)
                .toList();
    }

    private Map<String, Object> toQuestionResponse(AssessmentQuestion question) {
        return Map.of(
                "id", question.getId(),
                "skill", question.getSkill(),
                "question", question.getQuestion(),
                "options", question.getOptions(),
                "topic", question.getTopic()
        );
    }

    /**
     * Submits answers and calculates the user's skill level.
     */
    @PostMapping("/submit")
    public Object submitAssessment(@RequestBody AssessmentSubmitRequest request) {
        return assessmentService.submit(request);
    }

    /**
     * Returns the latest assessment for a user and skill.
     */
    @GetMapping("/latest")
    public Object getLatestAssessment(
            @RequestParam Long userId,
            @RequestParam String skill) {

        return assessmentService
                .latest(userId, skill)
                .orElse(null);
    }

    /**
     * Returns all assessment attempts made by a user.
     */
    @GetMapping("/history/{userId}")
    public Object getAssessmentHistory(@PathVariable Long userId) {
        return assessmentService.history(userId);
    }
}
