package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.enums.EnrollmentStatus;

import java.time.LocalDate;
import java.util.List;

public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentService studentService;
    private final CourseService courseService;

    public EnrollmentService(StudentService studentService,
                             CourseService courseService) {
        this.enrollmentRepository = new EnrollmentRepository();
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public Enrollment enrollStudent(int studentId, int courseId) {

        if (studentService.getStudentById(studentId) == null) {
            throw new IllegalArgumentException(
                    "Student not found: " + studentId);
        }

        if (courseService.getCourseById(courseId) == null) {
            throw new IllegalArgumentException(
                    "Course not found: " + courseId);
        }

        Enrollment enrollment = new Enrollment(
                IdGenerator.generateEnrollmentId(),
                studentId,
                courseId,
                LocalDate.now(),
                EnrollmentStatus.ACTIVE
        );

        enrollmentRepository.addEnrollment(enrollment);
        return enrollment;
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.getAllEnrollments();
    }

    public Enrollment getEnrollmentById(int id) {
        return enrollmentRepository.getEnrollmentById(id);
    }

    public boolean deleteEnrollment(int id) {
        return enrollmentRepository.deleteEnrollment(id);
    }
}