# JVM Basics

## Overview

The Java Virtual Machine (JVM) executes Java bytecode. It allows compiled Java programs to run on systems that have a compatible Java runtime.

## JDK, JRE, and JVM

- **JDK (Java Development Kit):** Provides tools for developing Java programs, including the Java compiler.
- **JRE (Java Runtime Environment):** Commonly describes the runtime components required to run Java applications.
- **JVM (Java Virtual Machine):** Executes Java bytecode.

Modern Java distributions may package these components differently, but the JVM remains responsible for executing bytecode.

## How a Java Program Runs

1. A developer writes source code in `.java` files.
2. The Java compiler (`javac`) compiles source code into `.class` bytecode files.
3. The JVM loads the classes required by the program.
4. The JVM verifies and executes the bytecode.
5. The runtime manages memory and other execution activities.

Example:

```bash
javac -d out src/com/airtribe/learntrack/Main.java
```

The command above illustrates compilation of a single source file. In LearnTrack, compile all source files together because classes depend on one another.

## JVM Memory Overview

The JVM uses several runtime memory areas.

### Heap

The heap stores objects and arrays. In LearnTrack, objects such as `Student`, `Course`, and `Enrollment` are allocated on the heap.

### Java Stack

Each thread has its own JVM stack containing method-call frames, local variables, and intermediate computation state.

### Method Area

The JVM specification defines a shared area for class-related structures and runtime constants. Its implementation details depend on the JVM.

### Program Counter

Each thread has a program counter that tracks the current JVM instruction being executed, with specification-defined behavior for native methods.

### Native Method Stacks

JVM implementations may use native method stacks to support execution of native methods.

## Garbage Collection

Garbage collection reclaims heap memory occupied by objects that are no longer reachable. Developers generally do not manually free Java objects as they would in languages requiring explicit memory management.

## Application Example

When LearnTrack creates a student:

1. `StudentService` constructs a `Student` object.
2. The repository adds the object to its in-memory collection.
3. The collection retains a reference to the object.
4. The student remains reachable while that reference is retained.

When the application exits, its in-memory state is not saved automatically.

## Summary

Understanding compilation, bytecode execution, runtime memory, and garbage collection helps explain how Java applications execute and manage objects.
