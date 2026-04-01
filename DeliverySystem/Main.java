import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("=========Menu=========");
        Resturant HN = new Resturant("Islamabad", 9.7, "HN FOODS");
        Menuitem m1 = (new Menuitem("Heer Ghost", "Special Masala", 43500.90));
        Menuitem m2 = (new Menuitem("Ranjha Ghost", "Special", 41500.90));

        HN.setMenu(m1);

        Order o1 = new Order("Hanan Qaisar", m1);
        System.out.println(o1);

        System.out.println(HN);
    }
}
