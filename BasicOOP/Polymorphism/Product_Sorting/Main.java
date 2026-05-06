package Product_Sorting;

import java.util.*;

public class Main {

    public static void header(String name) {
        System.out.printf(" ___________________________________________________\n");
        System.out.printf("|               %-36s|\n", name);
        System.out.printf("|___________________________________________________|\n");
    }

    public static void main(String[] args) {
        Product p1 = new Product("Oil", 2414, 1345, 7.9);
        Product p2 = new Product("Shampoo", 2314, 2385, 9.6);
        Product p3 = new Product("oil", 2214, 1440, 8.1);
        Product p4 = new Product("Soap", 1214, 1395, 8.0);
        Product p5 = new Product("Lotion", 1913, 740, 7.0);

        ArrayList<Product> list = new ArrayList<>();
        list.add(p4);
        list.add(p3);
        list.add(p2);
        list.add(p1);

        header("Natural sort(Price)");
        Collections.sort(list);
        for (Product i : list) {
            System.out.println(i.toString());
        }

        header("Sort by Price(Decending)");
        Collections.sort(list, new sortByPrice());
        for (Product i : list) {
            System.out.println(i.toString());
        }

        header("Sort by Alpha(Natural)");
        Collections.sort(list, new sortByAlphabets());
        for (Product i : list) {
            System.out.println(i.toString());
        }

        header("Sort by Rating(Accending)");
        Collections.sort(list, new sortByRating());
        for (Product i : list) {
            System.out.println(i.toString());
        }

    }
}