package Java_OOP.Vehical_Rental_System;

import java.util.Scanner;

import Java_OOP.Vehical_Rental_System.Vehicle.Insurable;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Vehicle car = new Car("Honda", 3200, 170);
        car.setDays(13);

        // car.calcRent(10);
        // car.displyInfo();

        System.out.println("Enter brand, Rent per day and speed: ");
        Vehicle Suv = new SUV(sc.nextLine(), sc.nextInt(), sc.nextInt());
        Suv.setDays(16);
        // Suv.calcRent(13);
        // Suv.displyInfo();

        Vehicle bike = new Bike("United", 700, 70);
        bike.setDays(8);
        // bike.calcRent(8);
        // bike.displyInfo();

        Vehicle[] autos = new Vehicle[3];
        autos[0] = car;
        autos[1] = Suv;
        autos[2] = bike;

        for (Vehicle vehicle : autos) {

            vehicle.displyInfo();
            if (vehicle instanceof Insurable) {
                Insurable i = (Insurable) vehicle;
                System.out.println("Submit insurance amount: " + i.getInsuranceCost());
            }
            // vehicle.calcRent(sc.nextInt());
        }

        sc.close();
    }
}