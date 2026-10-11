# Setup Instructions

## Prerequisites

- A Java Development Kit (JDK) compatible with the installed Java features.
- An IDE such as IntelliJ IDEA or Eclipse, or a terminal with Java compiler tools available.
- Git, if cloning the repository.

Verify Java installation:

```bash
java -version
javac -version
```

Both commands should display installed Java version information.

## Get the Project

Clone the repository:

```bash
git clone <YOUR_PUBLIC_REPOSITORY_URL>
```

Move into the project directory:

```bash
cd <YOUR_REPOSITORY_FOLDER>
```

Replace the placeholders with your actual repository URL and folder name.

## Open in an IDE

1. Open the project folder in your IDE.
2. Configure the installed JDK as the project SDK.
3. Mark `src` as the source directory if the IDE does not detect it automatically.
4. Verify that Java package declarations match the directory structure.
5. Open `src/com/airtribe/learntrack/Main.java`.

## Run the Application

Run the `main` method in `Main.java`.

The application displays a console menu with options to manage students, courses, and enrollments.

Follow the menu prompts to add, list, search for, and delete records.

## Compile and Run from a Terminal

From the project root, compile the Java source files into a separate output directory.

On macOS/Linux with a shell that supports the command below:

```bash
mkdir -p out
javac -d out $(find src -name "*.java")
java -cp out com.airtribe.learntrack.Main
```

On Windows, compiling through the IDE is the simplest option. Alternatively, use PowerShell to collect the Java source files and pass them to `javac`.

## Basic Verification

Check the following after starting the application:

1. Add a student with valid details.
2. List students and confirm the new record appears.
3. Add a course with a positive duration.
4. Create an enrollment using the existing student and course IDs.
5. Try invalid menu input.
6. Try enrolling a nonexistent student or course.
7. Exit the application.

## Known Limitation

Records are stored in memory using Java collections. They are lost when the application exits. A database is not configured in this version.
