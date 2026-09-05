package com.skillbridge.service;

import com.skillbridge.model.LearningProgress;
import com.skillbridge.repository.LearningProgressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearningProgressService {

    private final LearningProgressRepository progressRepository;

    public LearningProgressService(LearningProgressRepository progressRepository) {
        this.progressRepository = progressRepository;
    }

    public List<LearningProgress> byUser(Long userId) {
        return progressRepository.findByUserIdOrderBySkillAscTopicAsc(userId);
    }

    public LearningProgress update(
            Long userId,
            String skill,
            String topic,
            Integer percent) {

        LearningProgress progress = progressRepository
                .findByUserIdAndSkillAndTopic(userId, skill, topic)
                .orElseGet(() -> new LearningProgress(userId, skill, topic));

        int safePercent = Math.max(0, Math.min(100, percent));

        progress.setProgressPercent(safePercent);
        progress.setCompleted(safePercent >= 100);

        return progressRepository.save(progress);
    }
}
