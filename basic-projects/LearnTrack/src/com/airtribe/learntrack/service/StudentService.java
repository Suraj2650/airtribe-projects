package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.InputValidator;

import java.util.List;

public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService() {
        studentRepository = new StudentRepository();
    }

    public Student addStudent(String firstName, String lastName,
                              String email, String batch) {

        if (!InputValidator.isNotEmpty(firstName)
                || !InputValidator.isNotEmpty(lastName)
                || !InputValidator.isValidEmail(email)
                || !InputValidator.isNotEmpty(batch)) {
            throw new IllegalArgumentException(
                    "Invalid student details. Check name, email and batch.");
        }

        Student student = new Student(
                IdGenerator.generateStudentId(),
                firstName.trim(),
                lastName.trim(),
                email.trim(),
                batch.trim(),
                true
        );

        studentRepository.addStudent(student);
        return student;
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public Student getStudentById(int id) {
        return studentRepository.getStudentById(id);
    }

    public boolean deleteStudent(int id) {
        return studentRepository.deleteStudent(id);
    }
}