package com.skillbridge.service;

import com.skillbridge.dto.AssessmentSubmitRequest;
import com.skillbridge.model.AssessmentQuestion;
import com.skillbridge.model.AssessmentResult;
import com.skillbridge.repository.AssessmentQuestionRepository;
import com.skillbridge.repository.AssessmentResultRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AssessmentService {

    private final AssessmentQuestionRepository questionRepository;
    private final AssessmentResultRepository resultRepository;

    public AssessmentService(
            AssessmentQuestionRepository questionRepository,
            AssessmentResultRepository resultRepository) {
        this.questionRepository = questionRepository;
        this.resultRepository = resultRepository;
    }

    public List<AssessmentQuestion> questions(String skill) {
        return questionRepository.findBySkillIgnoreCase(skill);
    }

    public AssessmentResult submit(AssessmentSubmitRequest request) {
        List<AssessmentQuestion> questions = this.questions(request.skill());

        int score = 0;
        List<String> weakAreas = new ArrayList<>();

        for (AssessmentQuestion question : questions) {
            Integer answer = request.answers().get(question.getId());

            if (answer != null && answer.equals(question.getCorrectIndex())) {
                score++;
            } else {
                weakAreas.add(question.getTopic());
            }
        }

        int readiness = questions.isEmpty()
                ? 0
                : (int) Math.round(score * 100.0 / questions.size());

        String level = getLevel(readiness);

        AssessmentResult result = new AssessmentResult();
        result.setUserId(request.userId());
        result.setSkill(request.skill());
        result.setScore(score);
        result.setTotal(questions.size());
        result.setReadiness(readiness);
        result.setLevel(level);
        result.setWeakAreas(String.join(", ", weakAreas));
        result.setAssessedAt(LocalDateTime.now());

        return resultRepository.save(result);
    }

    private String getLevel(int readiness) {
        if (readiness >= 80) {
            return "Advanced";
        }

        if (readiness >= 40) {
            return "Intermediate";
        }

        return "Beginner";
    }

    public Optional<AssessmentResult> latest(Long userId, String skill) {
        return resultRepository
                .findTopByUserIdAndSkillOrderByAssessedAtDesc(userId, skill);
    }

    public List<AssessmentResult> history(Long userId) {
        return resultRepository.findByUserIdOrderByAssessedAtDesc(userId);
    }
}
