package com.airtribe.learntrack.util;

public class IdGenerator {
    private static int studentId = 1;
    private static int courseId = 1;
    private static int enrollmentId = 1;

    public static int generateStudentId() {
        return studentId++;        //Will Automatically increase the ids
    }

    public static int generateCourseId() {
        return courseId++;
    }

    public static int generateEnrollmentId() {
        return enrollmentId++;
    }
}