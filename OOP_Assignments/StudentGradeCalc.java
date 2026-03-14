import java.util.Scanner;

public class StudentGradeCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student s1 = new Student("Ali Hassan", 101, 92.5);
        Student s2 = new Student("Sara Khan", 102, 67.0);

        // Print details of both students
        System.out.println("=== Student 1 ===");
        System.out.println("Name       : " + s1.getName());
        System.out.println("Roll No    : " + s1.getRollNo());
        System.out.println("Marks      : " + s1.getMarks());
        System.out.println("Grade      : " + s1.calculateGrade());
        System.out.println("University : " + Student.universityName);
        System.out.println("Department : " + s1.depart);

        System.out.println("\n=== Student 2 ===");
        System.out.println("Name       : " + s2.getName());
        System.out.println("Roll No    : " + s2.getRollNo());
        System.out.println("Marks      : " + s2.getMarks());
        System.out.println("Grade      : " + s2.calculateGrade());
        System.out.println("University : " + Student.universityName);
        System.out.println("Department : " + s2.depart);

        Student.changeUniversity("FAST University, Lahore Campus");

        System.out.println("\n====== After University Change ======");
        System.out.println("S1 University : " + Student.universityName);
        System.out.println("S2 University : " + Student.universityName);

        sc.close();
    }
}

class Student {
    private String name;
    private int rollNo;
    private double marks;
    static String universityName = "Comsats University, Lahore Campus";
    final String depart = "Computer Science";

    // Default constructor
    public Student() {

    }

    public Student(String name, int rollNo, double marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public double getMarks() {
        return marks;
    }

    // Setters
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Invalid");
        } else {
            this.name = name;
        }
    }

    public void setRollNo(int rollNo) {
        if (rollNo < 0) {
            System.out.println("Invalid");
        } else {
            this.rollNo = rollNo;
        }
    }

    public void setMarks(double marks) {
        if (marks < 0) {
            System.out.println("invalid");
        } else {
            this.marks = marks;
        }
    }

    public String calculateGrade() {
        if (marks >= 85)
            return "A";
        else if (marks >= 70)
            return "B";
        else if (marks >= 50)
            return "C";
        else
            return "Fail";
    }

    public static void changeUniversity(String newName) {
        universityName = newName;
    }
}
// 1. Define a class named Student with the following private attributes: name
// (String), rollNo (int),
// and marks (double).
// 2. Add a static variable universityName and a final variable department with
// value &quot;Software
// Engineering&quot;.
// 3. Create a default constructor that initializes all attributes with default
// values.
// 4. Create a parameterized constructor that initializes all attributes using
// parameters.
// 5. Implement getter and setter methods for name, rollNo, and marks.
// 6. Write a method calculateGrade() that returns:
// - &quot;A&quot; if marks ≥ 85
// - &quot;B&quot; if marks ≥ 70
// - &quot;C&quot; if marks ≥ 50
// - &quot;Fail&quot; otherwise.
// 7. Implement a static method changeUniversity(String newName) to change the
// university name.
// 8. In the main method:
// - Create two Student objects using the parameterized constructor.
// - Print student details using getters.
// - Display grades using calculateGrade().
// - Change the university name using the static method and show that it affects
// both objects.