package MobileStore;

public class Main {
    public static void main(String[] args) {
        Store MobileOyee = new Store("Mobile Oyeeee", "Pakistan");
        Phone Samsung = new Phone("Samsung", "A15", 435933.90);
        Phone Oppo = new Phone("Oppo", "F12", 34500.50);
        Phone Apple = new Phone();
        Apple.setBrand("Apple");
        Apple.setModel("17 Pro MAX");
        Apple.setPrice(560000);
        Phone Nokia = new Phone("Nokia", "3310", 3500);
        MobileOyee.display();

        MobileOyee.addPhone(Samsung);
        MobileOyee.addPhone(Oppo);
        MobileOyee.addPhone(Apple);
        MobileOyee.addPhone(Nokia);

        Store.totalmobile();// give total mobile phones in store
    }
}
