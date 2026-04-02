import java.util.Scanner;

public class Stringinjava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("String is immutable");
        String name = new String("Hanan Qaisar, (Programmer)");
        System.out.println(name);
        System.out.println("Now we try to change string");
        name = "Hello" + name;
        System.out.println(name);
        System.out
                .println("A new String is returned to name.This is String immutability.Existing String is not change");
        System.out.println("Now disscus String Builder & string Buffer");
        StringBuilder name2 = new StringBuilder("Hello");
        System.out.println(name2);
        System.out.println("Now change this:");
        name2.append(" i am Hanan Qaisar. Software Engineer..");
        System.out.println(name2);
        name2.deleteCharAt(42);// remove extra fullStop
        System.out.println(name2);
        name2.replace(6, 7, "I,");
        System.out.println(name2);

        System.out.println("String Buffer: ");
        StringBuffer b = new StringBuffer("I am coderr");
        b.deleteCharAt(10);
        b.append(" Hanan Qaisar");
        System.out.println(b);
        sc.close();
    }
}