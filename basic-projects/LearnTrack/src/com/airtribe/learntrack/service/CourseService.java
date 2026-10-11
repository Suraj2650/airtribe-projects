package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.InputValidator;

import java.util.List;

public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService() {
        courseRepository = new CourseRepository();
    }

    public Course addCourse(String courseName, String description,
                            int durationInWeeks) {

        if (!InputValidator.isNotEmpty(courseName)
                || !InputValidator.isNotEmpty(description)
                || !InputValidator.isPositive(durationInWeeks)) {
            throw new IllegalArgumentException(
                    "Invalid course details. Duration must be positive.");
        }

        Course course = new Course(
                IdGenerator.generateCourseId(),
                courseName.trim(),
                description.trim(),
                durationInWeeks,
                true
        );

        courseRepository.addCourse(course);
        return course;
    }

    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    public Course getCourseById(int id) {
        return courseRepository.getCourseById(id);
    }

    public boolean deleteCourse(int id) {
        return courseRepository.deleteCourse(id);
    }
}