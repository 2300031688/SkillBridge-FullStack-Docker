package com.skillbridge.config;

import com.skillbridge.model.AssessmentQuestion;
import com.skillbridge.model.Skill;
import com.skillbridge.repository.AssessmentQuestionRepository;
import com.skillbridge.repository.SkillRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner seedData(
            SkillRepository skillRepository,
            AssessmentQuestionRepository questionRepository) {

        return args -> {
            seedSkills(skillRepository);
            seedAssessmentQuestions(questionRepository);
        };
    }

    private void seedSkills(SkillRepository skillRepository) {
        if (skillRepository.count() > 0) {
            return;
        }

        List<Skill> skills = List.of(
                new Skill("Java", "Technology"),
                new Skill("Spring Boot", "Technology"),
                new Skill("React", "Technology"),
                new Skill("MySQL", "Technology"),
                new Skill("Docker", "DevOps"),
                new Skill("AWS", "Cloud"),
                new Skill("System Design", "Architecture")
        );

        skillRepository.saveAll(skills);
    }

    private void seedAssessmentQuestions(AssessmentQuestionRepository questionRepository) {
        if (questionRepository.count() > 0) {
            return;
        }

        questionRepository.saveAll(List.of(
                new AssessmentQuestion(
                        "Docker",
                        "What is a Docker image?",
                        List.of("A running process", "A read-only template", "A network", "A database"),
                        1,
                        "Images"),
                new AssessmentQuestion(
                        "Docker",
                        "Which command builds an image?",
                        List.of("docker run", "docker build", "docker ps", "docker pull"),
                        1,
                        "Commands"),
                new AssessmentQuestion(
                        "Docker",
                        "What is a Dockerfile used for?",
                        List.of("Define image build steps", "Store logs", "Create a database", "Monitor CPU"),
                        0,
                        "Dockerfile"),
                new AssessmentQuestion(
                        "Docker",
                        "What does Docker Compose help manage?",
                        List.of("Multi-container applications", "Java classes", "SQL indexes", "DNS records"),
                        0,
                        "Compose"),
                new AssessmentQuestion(
                        "Docker",
                        "What is a volume mainly used for?",
                        List.of("Persistent data", "CPU scaling", "HTTP routing", "Encryption"),
                        0,
                        "Volumes"),
                new AssessmentQuestion(
                        "AWS",
                        "What is Amazon EC2?",
                        List.of("Object storage", "Virtual server compute", "Identity service", "DNS service"),
                        1,
                        "EC2"),
                new AssessmentQuestion(
                        "AWS",
                        "What is Amazon S3 primarily used for?",
                        List.of("Object storage", "Virtual machines", "Message queues", "Source control"),
                        0,
                        "S3"),
                new AssessmentQuestion(
                        "AWS",
                        "What does IAM manage?",
                        List.of("Identity and access", "Images", "Containers", "Databases only"),
                        0,
                        "IAM"),
                new AssessmentQuestion(
                        "AWS",
                        "What is an AWS Region?",
                        List.of(
                                "A programming language",
                                "A geographic area containing AWS infrastructure",
                                "A database table",
                                "A container"),
                        1,
                        "Regions"),
                new AssessmentQuestion(
                        "AWS",
                        "Which is serverless compute?",
                        List.of("EC2", "Lambda", "S3", "RDS"),
                        1,
                        "Lambda"),
                new AssessmentQuestion(
                        "System Design",
                        "What does horizontal scaling mean?",
                        List.of(
                                "Adding more instances",
                                "Adding more CPU to one machine",
                                "Deleting servers",
                                "Adding database columns"),
                        0,
                        "Scaling"),
                new AssessmentQuestion(
                        "System Design",
                        "What does a load balancer do?",
                        List.of("Distributes traffic", "Stores files", "Compiles code", "Encrypts passwords"),
                        0,
                        "Load Balancing"),
                new AssessmentQuestion(
                        "System Design",
                        "What is caching used for?",
                        List.of(
                                "Reduce repeated expensive reads",
                                "Replace authentication",
                                "Create users",
                                "Format JSON"),
                        0,
                        "Caching"),
                new AssessmentQuestion(
                        "System Design",
                        "What is database replication?",
                        List.of(
                                "Keeping synchronized copies",
                                "Deleting duplicates",
                                "Compressing SQL",
                                "Generating APIs"),
                        0,
                        "Replication"),
                new AssessmentQuestion(
                        "System Design",
                        "High availability mainly aims to?",
                        List.of(
                                "Keep service available despite failures",
                                "Reduce code size",
                                "Increase UI colors",
                                "Remove backups"),
                        0,
                        "High Availability")
        ));
    }
}
