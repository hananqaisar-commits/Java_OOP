package Java_OOP.Vehical_Rental_System;

import Java_OOP.Vehical_Rental_System.Vehicle.Insurable;

class Car extends Vehicle implements Insurable {

    public Car(String brand, int rentPerDay, int speed) {
        super(brand, rentPerDay, speed);
    }

    public double getInsuranceCost() {
        return 15000;
    }

    @Override
    public void calcRent(int days) {
        int rent = days * 5000;
        System.out.println("Rent for " + days + " days: " + rent + " PKR");
    }
}
