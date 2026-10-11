package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Enrollment;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepository {

    private final List<Enrollment> enrollments = new ArrayList<>();

    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollments;
    }

    public Enrollment getEnrollmentById(int id) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getId() == id) {
                return enrollment;
            }
        }
        return null;
    }

    public boolean deleteEnrollment(int id) {
        Enrollment enrollment = getEnrollmentById(id);

        if (enrollment != null) {
            enrollments.remove(enrollment);
            return true;
        }

        return false;
    }
}