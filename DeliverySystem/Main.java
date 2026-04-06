public class Main {
    public static void main(String[] args) {

        System.out.println("=========Menu=========");
        Resturant HN = new Resturant("Islamabad", 9.7, "HN FOODS");
        Menuitem m1 = new Menuitem("Heer Ghost", "Special Masala", 43500.90);
        Menuitem m2 = new Menuitem("Ranjha Ghost", "Special", 41500.90);

        HN.addMenu(m1);
        HN.addMenu(m2);
        System.out.println(HN);

        Order o1 = new Order("Hanan Qaisar");
        o1.addOrder(m2);
        o1.addOrder(m1);
        System.out.println(o1.toString());
        o1.display();

    }
}
