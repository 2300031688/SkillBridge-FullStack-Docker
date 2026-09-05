package com.skillbridge.controller;

import com.skillbridge.service.LearningProgressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {

    private final LearningProgressService progressService;

    public ProgressController(LearningProgressService progressService) {
        this.progressService = progressService;
    }

    @GetMapping("/{userId}")
    public Object getProgress(@PathVariable Long userId) {
        return progressService.byUser(userId);
    }

    @PutMapping
    public Object updateProgress(
            @RequestParam Long userId,
            @RequestParam String skill,
            @RequestParam String topic,
            @RequestParam Integer percent) {

        return progressService.update(userId, skill, topic, percent);
    }
}
