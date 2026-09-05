package com.skillbridge.model;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "assessment_questions")
public class AssessmentQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String skill;

    @Column(nullable = false, length = 1000)
    private String question;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "assessment_question_options",
            joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "option_text", nullable = false)
    private List<String> options;

    @Column(nullable = false)
    private Integer correctIndex;

    @Column(nullable = false)
    private String topic;

    public AssessmentQuestion() {
    }

    public AssessmentQuestion(
            String skill,
            String question,
            List<String> options,
            Integer correctIndex,
            String topic) {

        this.skill = skill;
        this.question = question;
        this.options = options;
        this.correctIndex = correctIndex;
        this.topic = topic;
    }

    public Long getId() {
        return id;
    }

    public String getSkill() {
        return skill;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public Integer getCorrectIndex() {
        return correctIndex;
    }

    public String getTopic() {
        return topic;
    }
}
