import java.util.Scanner;

public class University_course_reg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Date d1 = new Date(30, 8, 2025);
        Student Hanan = new Student("Hanan Qaisar", 187);
        Course Java = new Course("Java How to programme", "Cs201", Hanan, d1);

        Java.showInfo();

        sc.close();
    }
}

class Date {
    private int date;
    private int month;
    private int year;

    public Date() {

    }

    public Date(int date, int month, int year) {
        if (date > 0 && date < 32) {
            this.date = date;
            if (month > 0 && month < 13) {
                this.month = month;
                if (year > 0) {
                    this.year = year;
                }
            }
        }
    }

    public void setDate(int date) {
        if (date > 0 && date < 32)
            this.date = date;
    }

    public int getDate() {
        return date;
    }

    public void setMonth(int month) {
        if (month > 0 && month < 13)
            this.month = month;
    }

    public int getMonth() {
        return month;
    }

    public void setYear(int year) {
        if (year > 0)
            this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void showDate() {
        System.out.println("Enrolled  : " + date + "/" + month + "/" + year);
    }

    @Override
    public String toString() {
        return "Enrolled  : " + date + "/" + month + "/" + year;
    }
}

class Student {
    private String name;
    private int rollNo;

    public Student() {

    }

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;

    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Invalid");
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void setRollNo(int rollNo) {
        if (rollNo == 0) {
            System.out.println("Invalid");
        } else {
            this.rollNo = rollNo;
        }
    }

    public int getRollNo() {
        return rollNo;
    }

    public void displayInfo() {
        System.out.println("Student   : " + name + " |" + " Roll# " + rollNo);
    }
}

class Course {
    private String courseName;
    private String courseCode;
    private Student enrolledStudent;
    private Date enrollmentDate;

    public Course(String coursename, String courseCode, Student s, Date d) {

        enrolledStudent = s;// s is whole object passed in main function it is valid in this language
        enrollmentDate = d;

        this.courseCode = courseCode;
        this.courseName = coursename;
    }

    public void showInfo() {
        System.out.println("Course    : " + courseName);
        System.out.println("code      : " + courseCode);
        enrolledStudent.displayInfo();
        enrollmentDate.showDate();
    }
}