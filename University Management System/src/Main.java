import java.util.*;

class Professor {
    String name;

    public Professor(String name) {
        this.name = name;
    }
}

class Course {
    String code;
    String name;
    Professor professor;
    List<String> enrolledStudents;

    public Course(String code, String name, Professor professor) {
        this.code = code;
        this.name = name;
        this.professor = professor;
        this.enrolledStudents = new ArrayList<>();
    }
}

class Department {
    String name;
    List<Course> courses;

    public Department(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }
}

class University {
    List<Department> departments;

    public University() {
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String name) {
        departments.add(new Department(name));
    }

    public void addCourse(String deptName, String code, String name, String professorName) {
        Department department = findDepartment(deptName);
        if (department != null) {
            Professor professor = new Professor(professorName);
            Course course = new Course(code, name, professor);
            department.courses.add(course);
        } else {
            System.out.println("Department not found!");
        }
    }

    public void enrollStudent(String deptName, String courseCode, String studentName) {
        Department department = findDepartment(deptName);
        if (department != null) {
            Course course = findCourse(department, courseCode);
            if (course != null) {
                course.enrolledStudents.add(studentName);
            } else {
                System.out.println("Course not found in the department!");
            }
        } else {
            System.out.println("Department not found!");
        }
    }

    public void displayHierarchy() {
        for (Department department : departments) {
            System.out.println("Department: " + department.name);
            for (Course course : department.courses) {
                System.out.println("\tCourse: " + course.code + " - " + course.name);
                if (!course.enrolledStudents.isEmpty()) {
                    System.out.println("\t\tEnrolled Students:");
                    for (String student : course.enrolledStudents) {
                        System.out.println("\t\t\t" + student);
                    }
                }
            }
        }
    }

    public void removeCourse(String deptName, String courseCode) {
        Department department = findDepartment(deptName);
        if (department != null) {
            Course course = findCourse(department, courseCode);
            if (course != null) {
                department.courses.remove(course);
            } else {
                System.out.println("Course not found in the department!");
            }
        } else {
            System.out.println("Department not found!");
        }
    }

    private Department findDepartment(String deptName) {
        for (Department department : departments) {
            if (department.name.equals(deptName)) {
                return department;
            }
        }
        return null;
    }

    private Course findCourse(Department department, String courseCode) {
        for (Course course : department.courses) {
            if (course.code.equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        University university = new University();

        // Adding Departments
        university.addDepartment("Computer Science");
        university.addDepartment("Mathematics");

        // Adding Courses and Professors
        university.addCourse("Computer Science", "CS101", "Introduction to Programming", "John Doe");
        university.addCourse("Mathematics", "MATH201", "Calculus", "Jane Smith");

        // Enrolling Students
        university.enrollStudent("Computer Science", "CS101", "Alice");
        university.enrollStudent("Mathematics", "MATH201", "Bob");

        // Displaying Hierarchy
        university.displayHierarchy();

        // Removing Course
        university.removeCourse("Computer Science", "CS101");

        // Displaying Updated Hierarchy
        university.displayHierarchy();
    }
}
