package com.skillbridge.repository;

import com.skillbridge.model.AssessmentQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssessmentQuestionRepository
        extends JpaRepository<AssessmentQuestion, Long> {

    List<AssessmentQuestion> findBySkillIgnoreCase(String skill);
}
