package com.skillbridge.repository;

import com.skillbridge.model.AssessmentResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AssessmentResultRepository
        extends JpaRepository<AssessmentResult, Long> {

    Optional<AssessmentResult> findTopByUserIdAndSkillOrderByAssessedAtDesc(
            Long userId,
            String skill);

    List<AssessmentResult> findByUserIdOrderByAssessedAtDesc(Long userId);
}
