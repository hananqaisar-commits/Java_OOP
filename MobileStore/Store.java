package MobileStore;

import java.util.ArrayList;

class Store {
    private String name, location;
    ArrayList<Phone> phones;
    private static int countMobile;
    public int count;

    public Store(String name, String location) {

        this.count = 0;// Store have 0 mobile by default
        this.name = name;
        this.location = location;
        phones = new ArrayList<>();// Now each phones arraylist belongs to each Store

    }

    public void addPhone(Phone p) {
        ++count; // increment this individual store count
        phones.add(p); // first add phone
        ++countMobile; // increment total across all stores
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

    public void count() {
        System.out.println("Total mobile: " + count);
    }

    public static void totalmobile() {
        System.out.println("\nTotal Mobiles available in all stores: " + Store.getCountMobile());
    }

}