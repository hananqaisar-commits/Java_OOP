package src.smart_student_ranking_system;

import java.lang.annotation.Documented;
import java.util.Comparator;

public class Student implements summary, Comparable<Student> {
    private String Name;
    private int rollNo;
    private double cgpa;

    public Student(String name, int rollNo, double cgpa) {
        Name = name;
        this.rollNo = rollNo;
        this.cgpa = cgpa;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            System.out.println("INVALID");
        else {
            Name = name;
        }
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        if (rollNo > 0) {
            this.rollNo = rollNo;
        } else {
            System.out.println("INVALID");
        }
    }

    public void setCgpa(double cgpa) {
        if (cgpa > 0.0)
            this.cgpa = cgpa;
        else
            System.out.println("INVALID");
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public int GPA() {
        return 4;
    }

    @Override
    public void detail() {
        System.out.printf("Name: %-10s | RollNo: %-4d | CGPA: %-3f\n",getName(),getRollNo(),getCgpa());

    }

    @Override
    public int compareTo(Student student) {
        return Double.compare(this.cgpa,student.cgpa);
    }

    static Comparator<Student> byName = (a,b) -> a.getName().compareTo(b.getName());
    static Comparator<Student> byrollNO=(a,b) -> a.getRollNo() - b.getRollNo();

}
