package MobileStore;

import java.util.ArrayList;

class Store {
    private String name, location;
    private static int countMobile;
    ArrayList<Phone> phones;

    public Store(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void addPhone(Phone p) {
        phones = new ArrayList<>();
        phones.add(p);

        System.out.println(phones);

        ++countMobile;
    }

    public static void setCountMobile(int countMobile) {
        if (countMobile <= 0) {
            System.out.println("Soory, No mobile available ");
        } else {
            Store.countMobile = countMobile;
        }
    }

    public static int getCountMobile() {
        return countMobile;
    }

    public void display() {
        System.out.print("======Welcome======\n");
        System.out.println("Store: " + name);
        System.out.println("Location: " + location);

    }

    public static void totalmobile() {
        System.out.println("\nTotal Mobiles available in store: " + Store.getCountMobile());
    }

}
