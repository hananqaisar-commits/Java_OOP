//run:
//javac HighestRowSum.java RowAboveAverage.java
//javac HighestRowSum

import java.util.Scanner;
import java.util.ArrayList;

public class HighestRowSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array[] = new int[3][4];
        System.out.println("Enter 3 by 4 array: ");
        Input i1 = new Input();
        i1.input(array, sc);
        ArrayList<Integer> arraylist = new ArrayList<>();

        sc.close();

        int MaxSum = Integer.MIN_VALUE;
        int maxRow = 0;
        for (int i = 0; i < array.length; i++) {

            int sum = 0;
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];

            }
            if (sum > MaxSum) {
                MaxSum = sum;
                maxRow = i;
            }

        }

        System.out.println("Row have highest sum: " + MaxSum);

        for (int i = maxRow; i == maxRow; i++) {

            for (int j = 0; j < array[i].length; j++) {

                arraylist.add(array[i][j]);
            }

        }
        System.out.println(arraylist);
    }
}
// You have a 2D int array (3×4). Find the row that has the highest sum, then
// store all elements of that row into an ArrayList<Integer> and print.