# Design Notes

## 1. Project Goal

LearnTrack is a console-based Student and Course Management System designed to demonstrate core Java and object-oriented programming concepts.

## 2. Main Components

### Main

`Main` is the application entry point. It displays the console menus, reads user input, calls the relevant services, and displays results or error messages.

### Entity

The entity package contains the application's data models.

- `Person` contains common identity and contact fields.
- `Student` extends `Person` and adds batch and active-status information.
- `Course` represents a course and its duration.
- `Enrollment` connects a student ID with a course ID and records the enrollment date and status.

### Repository

Repositories manage in-memory entity collections.

- `StudentRepository` stores students.
- `CourseRepository` stores courses.
- `EnrollmentRepository` stores enrollments.

The repositories provide operations to add, retrieve, search, and delete records.

### Service

Services coordinate application operations and apply business rules.

- `StudentService` validates student details and manages student operations.
- `CourseService` validates course details and manages course operations.
- `EnrollmentService` checks that the referenced student and course exist before creating an enrollment.

### Utility

- `IdGenerator` generates separate increasing IDs for students, courses, and enrollments.
- `InputValidator` provides reusable checks for required text, email format, and positive numbers.

### Enum

`EnrollmentStatus` defines the supported enrollment states:

- `ACTIVE`
- `COMPLETED`
- `CANCELLED`

New enrollments are initially assigned `ACTIVE`.

## 3. Object-Oriented Design

### Encapsulation

Entity fields are private and accessed through getters and setters.

### Inheritance

`Student` extends `Person` to reuse common person-related fields and behavior.

### Polymorphism

`Student` overrides `getDisplayName()` from `Person`, demonstrating method overriding.

### Composition and Dependencies

`EnrollmentService` depends on `StudentService` and `CourseService` to validate enrollment requests. The application passes the same service instances to the enrollment service so that all components operate on the same in-memory data.

## 4. Data Flow

A typical operation follows this flow:

1. The user selects a console menu option.
2. `Main` reads the required information.
3. The relevant service validates the input.
4. The service creates or retrieves an entity.
5. The repository stores or retrieves the entity from an `ArrayList`.
6. `Main` displays the result.

## 5. Error Handling

The application handles invalid numeric menu input and invalid student or course details using exception handling.

Enrollment creation checks whether the referenced student and course exist and rejects the request if either is missing.

## 6. Storage Decisions

The application uses in-memory `ArrayList` collections to keep the implementation focused on Java fundamentals and collection operations.

No database or file-based persistence is configured. Consequently, records are lost when the application terminates.

## 7. ID Generation

`IdGenerator` maintains separate static counters for student, course, and enrollment IDs. Each generation method returns the current value and increments its counter.

These IDs are unique within their respective counters during a single application run, assuming the counters are not reset.

## 8. Current Limitations

- Data is not persisted between application runs.
- Email validation uses a basic format check and does not verify whether an address exists.
- Records are managed through a console interface.
- The application does not currently implement a database, authentication, or a web API.
- Enrollment statuses are defined, but a dedicated workflow for changing enrollment status is not included in the current menu.

## 9. Possible Future Improvements

If the project scope is expanded later, possible improvements include persistent storage, stronger validation, automated tests, and operations for updating enrollment status. These are not required for the current in-memory implementation.
