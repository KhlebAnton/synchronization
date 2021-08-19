package com.company;

public class Main {

    public static void main(String[] args) {
        final CarShowroom carShowroom = new CarShowroom();
        final Customer customer = new Customer();


        while (carShowroom.getSoldCars() != 10) {
            for (int i = 1; i <= 12; i++) {
                new Thread(null, customer::buyCar, "Покупатель " + i).start();
                new Thread(null, customer::acceptCar, "LADA").start();
            }
        }
    }
}
