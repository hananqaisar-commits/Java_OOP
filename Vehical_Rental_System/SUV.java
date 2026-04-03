package Java_OOP.Vehical_Rental_System;

import Java_OOP.Vehical_Rental_System.Vehicle.Insurable;

class SUV extends Vehicle implements Insurable {
    public SUV(String brand, int rentPerDay, int speed) {
        super(brand, rentPerDay, speed);
    }

    @Override
    public double getInsuranceCost() {
        return 25000;
    }

    @Override
    public void calcRent(int days) {
        int rent = days * getRentPerDay();
        double luxuryTax = rent * 0.20;
        System.out.println("Luxury Rent is:" + luxuryTax);
        double total = rent + luxuryTax;

        System.out.println(getBrand() + " Rent for " + days + " days: " + total + " PKR");
    }
}