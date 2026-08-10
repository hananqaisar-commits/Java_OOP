
class DataManager {
    public static Store MobileOyee = new Store("Mobile Oyee", "Pakistan");
    public static Store MobileWorld = new Store("Mobile World", "USA");

    static {
        Phone Samsung = new Phone("Samsung", "A15", 435933.90);
        Phone Oppo = new Phone("Oppo", "F12", 34500.50);
        Phone Apple = new Phone();
        Apple.setBrand("Apple");
        Apple.setModel("17 Pro MAX");
        Apple.setPrice(560000);
        Phone Nokia = new Phone("Nokia", "3310", 3500);
        Phone Redmi1 = new Phone("Redmi", "Note 10 Pro", 43000.99);

        MobileOyee.addPhone(Samsung);
        MobileOyee.addPhone(Oppo);
        MobileOyee.addPhone(Apple);
        MobileOyee.addPhone(Nokia);
        MobileOyee.addPhone(Redmi1);

        MobileWorld.addPhone(Apple);
        MobileWorld.addPhone(Redmi1);
    }
}