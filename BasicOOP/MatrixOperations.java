import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 3 by 3: ");
        int[] array[] = new int[3][3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        printarray(array);
        printrowSums(array);
        printdiaognal(array);
        printTranspose(array);

        sc.close();
    }

    static void printarray(int array[][]) {
        System.out.println("Matrix: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%3d", array[i][j]);
            }
            System.out.printf("\n");
        }
    }

    static void printdiaognal(int array[][]) {
        System.out.println("Diaognal: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j) {
                    System.out.printf("%3d,", array[i][j]);
                }
            }
        }
    }

    static void printTranspose(int array[][]) {
        System.out.println("\nTranspose: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.printf("%3d", array[j][i]);
            }
            System.out.print("\n");
        }
    }

    static void printrowSums(int array[][]) {
        System.out.printf("Row\tSums: \n");
        int maxRow = 0;
        int largestelement = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
                if (array[i][j] > largestelement) {
                    largestelement = array[i][j];
                    maxRow = (i + 1);
                }
            }
            System.out.printf("Row %d: %4d\n", (i + 1), sum);

        }
        System.out.println("largest Element in row " + maxRow + " is: " + largestelement);
    }
}
