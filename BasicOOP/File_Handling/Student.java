
public class Student {

    String name;
    String education;
    int roll;

    public Student() {
    }

    public Student(String name, String education, int roll) {
        this.name = name;
        this.education = education;
        this.roll = roll;
    }

    @Override
    public String toString() {
        return name + "," + education + "," + roll + "\n";
    }

    public String toFile() {
        return String.format("%s,%s,%d\n", name, education, roll);
    }

}