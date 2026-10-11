package com.airtribe.learntrack;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService =
                new EnrollmentService(studentService, courseService);

        boolean running = true;

        while (running) {
            System.out.println("\n===== LearnTrack =====");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Courses");
            System.out.println("3. Manage Enrollments");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        studentMenu(scanner, studentService);
                        break;
                    case 2:
                        courseMenu(scanner, courseService);
                        break;
                    case 3:
                        enrollmentMenu(scanner, enrollmentService);
                        break;
                    case 4:
                        running = false;
                        System.out.println("Exiting LearnTrack...");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        scanner.close();
    }

    private static void studentMenu(
            Scanner scanner, StudentService service) {

        boolean back = false;

        while (!back) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. Find Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Back");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("First name: ");
                        String firstName = scanner.nextLine();

                        System.out.print("Last name: ");
                        String lastName = scanner.nextLine();

                        System.out.print("Email: ");
                        String email = scanner.nextLine();

                        System.out.print("Batch: ");
                        String batch = scanner.nextLine();

                        Student student = service.addStudent(
                                firstName, lastName, email, batch);

                        System.out.println(
                                "Student added. ID: " + student.getId());
                        break;

                    case 2:
                        if (service.getAllStudents().isEmpty()) {
                            System.out.println("No students found.");
                        } else {
                            for (Student s : service.getAllStudents()) {
                                System.out.println(
                                        s.getId() + " | "
                                                + s.getDisplayName() + " | "
                                                + s.getEmail() + " | Batch: "
                                                + s.getBatch() + " | Active: "
                                                + s.isActive());
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Student ID: ");
                        int searchId =
                                Integer.parseInt(scanner.nextLine());

                        Student found = service.getStudentById(searchId);

                        if (found == null) {
                            System.out.println("Student not found.");
                        } else {
                            System.out.println(
                                    found.getId() + " | "
                                            + found.getDisplayName() + " | "
                                            + found.getEmail());
                        }
                        break;

                    case 4:
                        System.out.print("Student ID: ");
                        int deleteId =
                                Integer.parseInt(scanner.nextLine());

                        if (service.deleteStudent(deleteId)) {
                            System.out.println("Student deleted.");
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 5:
                        back = true;
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void courseMenu(
            Scanner scanner, CourseService service) {

        boolean back = false;

        while (!back) {
            System.out.println("\n--- Course Management ---");
            System.out.println("1. Add Course");
            System.out.println("2. List Courses");
            System.out.println("3. Find Course");
            System.out.println("4. Delete Course");
            System.out.println("5. Back");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Course name: ");
                        String name = scanner.nextLine();

                        System.out.print("Description: ");
                        String description = scanner.nextLine();

                        System.out.print("Duration in weeks: ");
                        int duration =
                                Integer.parseInt(scanner.nextLine());

                        Course course = service.addCourse(
                                name, description, duration);

                        System.out.println(
                                "Course added. ID: " + course.getId());
                        break;

                    case 2:
                        if (service.getAllCourses().isEmpty()) {
                            System.out.println("No courses found.");
                        } else {
                            for (Course c : service.getAllCourses()) {
                                System.out.println(
                                        c.getId() + " | "
                                                + c.getCourseName() + " | "
                                                + c.getDurationInWeeks()
                                                + " weeks | Active: "
                                                + c.isActive());
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Course ID: ");
                        int searchId =
                                Integer.parseInt(scanner.nextLine());

                        Course found = service.getCourseById(searchId);

                        if (found == null) {
                            System.out.println("Course not found.");
                        } else {
                            System.out.println(
                                    found.getId() + " | "
                                            + found.getCourseName() + " | "
                                            + found.getDescription());
                        }
                        break;

                    case 4:
                        System.out.print("Course ID: ");
                        int deleteId =
                                Integer.parseInt(scanner.nextLine());

                        if (service.deleteCourse(deleteId)) {
                            System.out.println("Course deleted.");
                        } else {
                            System.out.println("Course not found.");
                        }
                        break;

                    case 5:
                        back = true;
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void enrollmentMenu(
            Scanner scanner, EnrollmentService service) {

        boolean back = false;

        while (!back) {
            System.out.println("\n--- Enrollment Management ---");
            System.out.println("1. Enroll Student");
            System.out.println("2. List Enrollments");
            System.out.println("3. Find Enrollment");
            System.out.println("4. Delete Enrollment");
            System.out.println("5. Back");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Student ID: ");
                        int studentId =
                                Integer.parseInt(scanner.nextLine());

                        System.out.print("Course ID: ");
                        int courseId =
                                Integer.parseInt(scanner.nextLine());

                        Enrollment enrollment =
                                service.enrollStudent(studentId, courseId);

                        System.out.println(
                                "Enrollment created. ID: "
                                        + enrollment.getId());
                        break;

                    case 2:
                        if (service.getAllEnrollments().isEmpty()) {
                            System.out.println("No enrollments found.");
                        } else {
                            for (Enrollment e :
                                    service.getAllEnrollments()) {
                                System.out.println(
                                        e.getId()
                                                + " | Student: " + e.getStudentId()
                                                + " | Course: " + e.getCourseId()
                                                + " | Date: " + e.getEnrollmentDate()
                                                + " | Status: " + e.getStatus());
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enrollment ID: ");
                        int searchId =
                                Integer.parseInt(scanner.nextLine());

                        Enrollment found =
                                service.getEnrollmentById(searchId);

                        if (found == null) {
                            System.out.println("Enrollment not found.");
                        } else {
                            System.out.println(
                                    found.getId()
                                            + " | Student: " + found.getStudentId()
                                            + " | Course: " + found.getCourseId()
                                            + " | Date: " + found.getEnrollmentDate()
                                            + " | Status: " + found.getStatus());
                        }
                        break;

                    case 4:
                        System.out.print("Enrollment ID: ");
                        int deleteId =
                                Integer.parseInt(scanner.nextLine());

                        if (service.deleteEnrollment(deleteId)) {
                            System.out.println("Enrollment deleted.");
                        } else {
                            System.out.println("Enrollment not found.");
                        }
                        break;

                    case 5:
                        back = true;
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}