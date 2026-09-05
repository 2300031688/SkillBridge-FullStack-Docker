package com.skillbridge.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoadmapService {

    private final Map<String, Map<String, List<String>>> roadmaps = new LinkedHashMap<>();

    public RoadmapService() {
        roadmaps.put("Java Full Stack Developer", mapOf(
                entry("Java", "Syntax & Data Types", "OOP", "Collections", "Exception Handling", "Java 8+", "Multithreading"),
                entry("Spring Boot", "Project Structure", "REST Controllers", "Service Layer", "JPA & Hibernate", "Validation", "Spring Security"),
                entry("React", "Components", "Props & State", "Hooks", "Routing", "Forms", "API Integration"),
                entry("SQL", "SELECT & WHERE", "Joins", "Grouping", "Subqueries", "Indexes", "Transactions"),
                entry("Docker", "Images & Containers", "Basic Commands", "Dockerfile", "Volumes", "Networking", "Docker Compose"),
                entry("AWS", "EC2", "S3", "IAM", "Regions & Availability", "Lambda", "Deployment Basics"),
                entry("System Design", "Scaling", "Load Balancing", "Caching", "Replication", "High Availability", "API Design")
        ));

        roadmaps.put("Frontend Developer", mapOf(
                entry("HTML", "Semantic HTML", "Forms", "Tables", "Accessibility", "SEO Basics"),
                entry("CSS", "Selectors", "Box Model", "Flexbox", "Grid", "Responsive Design", "Animations"),
                entry("JavaScript", "ES6+", "Functions", "DOM", "Async JavaScript", "Promises", "Fetch & APIs"),
                entry("React", "Components", "Props & State", "Hooks", "Routing", "Forms", "Performance"),
                entry("TypeScript", "Types", "Interfaces", "Generics", "Utility Types", "React with TypeScript"),
                entry("Testing", "Unit Tests", "Component Tests", "Mocking", "Test Cases"),
                entry("Next.js", "App Router", "Pages", "Server Components", "Data Fetching", "Deployment")
        ));

        roadmaps.put("Backend Developer", mapOf(
                entry("Java", "Syntax", "OOP", "Collections", "Exceptions", "Java 8+"),
                entry("Spring Boot", "REST APIs", "Dependency Injection", "JPA & Hibernate", "Validation", "Security"),
                entry("REST APIs", "HTTP Methods", "Status Codes", "Request/Response", "Validation", "Error Handling"),
                entry("SQL", "Queries", "Joins", "Grouping", "Transactions", "Indexes"),
                entry("Docker", "Images", "Containers", "Dockerfile", "Compose", "Networking"),
                entry("Redis", "Key-Value Model", "Caching", "TTL", "Data Structures", "Use Cases"),
                entry("System Design", "Scaling", "Load Balancing", "Caching", "Queues", "High Availability")
        ));

        roadmaps.put("Python Developer", mapOf(
                entry("Python", "Syntax", "Functions", "OOP", "Modules", "Exceptions", "Testing"),
                entry("Django / Flask", "Routing", "Views", "Templates", "REST APIs", "Authentication"),
                entry("SQL", "Queries", "Joins", "Grouping", "Subqueries", "Indexes"),
                entry("REST APIs", "HTTP", "Endpoints", "JSON", "Validation", "Error Handling"),
                entry("Git", "Repositories", "Branches", "Commits", "Merge", "Pull Requests"),
                entry("Docker", "Images", "Dockerfile", "Compose", "Volumes"),
                entry("Testing", "Unit Tests", "Fixtures", "Mocking", "Coverage")
        ));

        roadmaps.put("Data Analyst", mapOf(
                entry("SQL", "SELECT", "Joins", "Grouping", "Subqueries", "Window Functions", "Indexes"),
                entry("Excel", "Formulas", "Lookup Functions", "Pivot Tables", "Cleaning", "Charts"),
                entry("Python", "Variables", "Functions", "Lists", "Pandas", "Data Cleaning"),
                entry("Pandas", "Series & DataFrame", "Filtering", "GroupBy", "Merge", "Missing Data"),
                entry("Power BI", "Data Import", "Data Model", "DAX Basics", "Visuals", "Dashboards"),
                entry("Statistics", "Mean & Median", "Variance", "Probability", "Distributions", "Hypothesis Testing"),
                entry("Data Visualization", "Chart Selection", "Distribution", "Comparison", "Trends", "Dashboards")
        ));

        roadmaps.put("Cloud Engineer", mapOf(
                entry("Linux", "Files & Directories", "Permissions", "Processes", "Networking", "Shell Basics"),
                entry("Networking", "IP & Ports", "DNS", "HTTP/HTTPS", "Subnets", "Routing"),
                entry("AWS", "IAM", "EC2", "S3", "VPC", "Lambda", "Cloud Monitoring"),
                entry("Docker", "Images", "Containers", "Dockerfile", "Volumes", "Networking"),
                entry("Kubernetes", "Pods", "Deployments", "Services", "ConfigMaps", "Ingress"),
                entry("Terraform", "Providers", "Resources", "Variables", "State", "Modules"),
                entry("Monitoring", "Metrics", "Logs", "Alerts", "Dashboards", "Health Checks")
        ));

        roadmaps.put("DevOps Engineer", mapOf(
                entry("Linux", "Files", "Permissions", "Processes", "Services", "Shell"),
                entry("Git", "Commits", "Branches", "Merge", "Rebase", "Pull Requests"),
                entry("Docker", "Images", "Containers", "Dockerfile", "Compose", "Networking"),
                entry("Jenkins", "Jobs", "Pipelines", "Stages", "Agents", "Credentials"),
                entry("AWS", "IAM", "EC2", "S3", "VPC", "Deployment"),
                entry("Kubernetes", "Pods", "Deployments", "Services", "ConfigMaps", "Ingress"),
                entry("Terraform", "Providers", "Resources", "Variables", "State", "Modules")
        ));
    }

    public Map<String, List<String>> forRole(String role) {
        return roadmaps.getOrDefault(role, roadmaps.get("Java Full Stack Developer"));
    }

    @SafeVarargs
    private final Map<String, List<String>> mapOf(Map.Entry<String, List<String>>... entries) {
        Map<String, List<String>> result = new LinkedHashMap<>();
        for (Map.Entry<String, List<String>> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    private Map.Entry<String, List<String>> entry(String skill, String... topics) {
        return Map.entry(skill, List.of(topics));
    }
}
