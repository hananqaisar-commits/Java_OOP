import java.util.Scanner;

public class RowAboveAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] array = new int[3][3];
        System.out.println("Enter 3 by 3 array: ");
        Input i1 = new Input();
        i1.input(array, sc);
        CalacRowAvg(array);

        sc.close();
    }

    static void CalacRowAvg(int array[][]) {

        for (int i = 0; i < array.length; i++) {
            double avg = 0;

            for (int j = 0; j < array.length; j++) {
                avg += array[i][j];
            }
            avg /= array.length;

            System.out.println("\nArray " + (i + 1) + " Average: " + avg);
            System.out.println("Above average: ");

            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > avg) {
                    System.out.print(array[i][j] + " ");
                }
            }
        }
    }
}

class Input {
    void input(int array[][], Scanner sc) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = sc.nextInt();
            }
        }
    }
}
// User enter a 2D int array, print all elements of each row that are greater
// than
// the row's average.