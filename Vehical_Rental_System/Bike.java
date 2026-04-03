package Java_OOP.Vehical_Rental_System;

class Bike extends Vehicle {
    public Bike(String brand, int rentPerDay, int speed) {
        super(brand, rentPerDay, speed);
    }

    public void calcRent(int days) {
        if (days > 7) {
            int rent = days * getRentPerDay();
            double discount = 0.10 * rent;
            double discountedPrice = rent - discount;

            System.out.println(
                    getBrand() + " Rent for " + days + " days: " + discountedPrice + " PKR (10% discount applied)");
        } else {
            int rent = days * getRentPerDay();
            System.out.println(getBrand() + " Rent for " + days + " days: " + rent + " PKR");
        }
    }
}