import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class text_file {

    public static void main(String[] args) {

        System.out.println("=======Creating TEXT Files=======");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter filename to create: ");
        String filename = sc.nextLine();

        try {
            BufferedWriter bf_w = new BufferedWriter(new FileWriter(filename, true));
            bf_w.write("Hello, I am ready for work");
            bf_w.newLine();
            bf_w.append("How i can help tou today?");
            bf_w.newLine();
            bf_w.append('T');
            bf_w.append('H');
            bf_w.append('A');
            bf_w.append('N');
            bf_w.append('K');
            bf_w.append('S');

            bf_w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("=======Reading TEXT Files=======");

        try {
            BufferedReader bf_r = new BufferedReader(new FileReader(filename));
            String line;
            char ch;

            while (filename != null) {

                line = bf_r.readLine();
                if (line.contains(" ")) {
                    System.out.println(line);
                }

            }
            bf_r.close();
        } catch (Exception c) {
            c.printStackTrace();
        }
        sc.close();
    }
}
