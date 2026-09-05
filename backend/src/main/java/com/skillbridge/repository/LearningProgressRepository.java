package com.skillbridge.repository;

import com.skillbridge.model.LearningProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LearningProgressRepository
        extends JpaRepository<LearningProgress, Long> {

    List<LearningProgress> findByUserIdOrderBySkillAscTopicAsc(Long userId);

    Optional<LearningProgress> findByUserIdAndSkillAndTopic(
            Long userId,
            String skill,
            String topic);
}
