package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {

    private final List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public Course getCourseById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    public boolean deleteCourse(int id) {
        Course course = getCourseById(id);

        if (course != null) {
            courses.remove(course);
            return true;
        }

        return false;
    }
}