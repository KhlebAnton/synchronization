package com.company;

public class Customer {

    private CarShowroom carShowroom = new CarShowroom(this);

    public Car buyCar() {
        return carShowroom.sellCar();
    }

    public void acceptCar() {
        carShowroom.releaseCar();
    }
}