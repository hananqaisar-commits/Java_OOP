import java.util.Scanner;

public class StudentMarksSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] marks = new int[3][4];// Rectangular Array

        Input_Output i1 = new Input_Output();
        i1.input(marks, sc);// input method and passing sc
        i1.output(marks);// output method

        sc.close();
    }
}

class Input_Output {

    public void input(int[][] marks, Scanner input) {

        for (int row = 0; row < marks.length; row++) {
            for (int coloumn = 0; coloumn < marks[row].length; coloumn++) {

                System.out.print("Enter " + (row + 1) + " row " + (coloumn + 1) + " column index: ");
                marks[row][coloumn] = input.nextInt();

            }
        }

    }

    public void output(int[][] marks) {

        for (int row = 0; row < marks.length; row++) {
            System.out.print("{");
            for (int coloumn = 0; coloumn < marks[row].length; coloumn++) {

                System.out.print(marks[row][coloumn] + ", ");
            }
            System.out.print("\b\b" + " }");
            System.out.println("");
        }
    }
}
