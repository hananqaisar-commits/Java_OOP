import java.util.Scanner;

public class CopyConstructor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Book title: ");
        String title = sc.nextLine();
        Book b1 = new Book(title);
        Book b2 = new Book(b1);
        Book b3 = b2;
        b3.title = "C++";
        System.out.println("Now b2 title changes to: " + b2.title);
        System.out.println(b3);
        System.out.println(b2);
        System.out.println("This is problem in shallow copy constructor");

        sc.close();
    }
}

class Book {
    String title;
    double price;

    public Book(String title) {
        this.title = title;
        price = 1035.50;
        this.print();
    }

    public Book(Book other) {
        this.title = other.title;
        price = 3450.00;
        this.print();
    }

    public void print() {
        System.out.println("Book is printing");
        System.out.println("Price: " + this.price);
        System.out.println("Book: " + this.title);
    }
}
