import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        {

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter name: ");
            String name = sc.nextLine();

            System.out.println("Enter education: ");
            String education = sc.nextLine();

            System.out.println("Enter rollNO: ");
            int rollNo = sc.nextInt();

            Student student = new Student(name, education, rollNo);

            text_fileIO IO = new text_fileIO();
            IO.write(student.toFile(), "class.txt");
            IO.read_parsing("class.txt");

            sc.close();
        }

    }
}