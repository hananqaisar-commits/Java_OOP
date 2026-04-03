package Java_OOP.Vehical_Rental_System;

abstract class Vehicle {
    private String brand;
    private int speed;
    private int rentPerDay;
    private int days;

    public Vehicle() {
        // default
    }

    public Vehicle(String brand, int rentPerDay, int speed) {
        this.brand = brand;
        this.rentPerDay = rentPerDay;
        this.speed = speed;
    }

    public interface Insurable {
        double getInsuranceCost();
    }

    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            System.out.println("Invalid");
        } else {
            this.brand = brand;
        }
    }

    public void setSpeed(int speed) {
        if (speed < 0) {
            System.out.println("invalid");
        } else {
            this.speed = speed;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setDays(int days) {
        if (days <= 0) {
            System.out.println("Invalid");
        } else {
            this.days = days;
        }
    }

    public int getDays() {
        return days;
    }

    public String getBrand() {
        return brand;
    }

    public void setRentPerDay(int rentPerDay) {
        if (rentPerDay == 0) {
            System.out.println("Invalid");
        } else {
            this.rentPerDay = rentPerDay;
        }
    }

    public int getRentPerDay() {
        return rentPerDay;
    }

    public void displyInfo() {
        System.out.println("\nBrand: " + brand);
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("Rent per day:" + rentPerDay);
        this.calcRent(getDays());
    }

    abstract public void calcRent(int days);

}