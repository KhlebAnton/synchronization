package com.company;

import java.util.ArrayList;
import java.util.List;

public class CarShowroom {

    public static final int PURCHASE = 3000;
    public static final int MACHINE_CREATION = 4000;

    private Customer customer;
    private List<Car> cars = new ArrayList<>(1);
    private int countMachine = 0;

    public CarShowroom() {
    }

    public CarShowroom(Customer customer) {
        this.customer = customer;
    }

    public synchronized Car sellCar() {
        try {
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            while (cars.size() == 0) {
                System.out.println("Автосалон: машин нет!");
                wait();
            }
            Thread.sleep(PURCHASE);
            System.out.println(Thread.currentThread().getName() + " уехал на новом авто");
            countMachine++;
            System.out.println("Автосалон: машин продано : " + countMachine);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return cars.remove(0);
    }

    public synchronized void releaseCar() {
        try {
            System.out.println("Производитель " + Thread.currentThread().getName() + " создал 1 авто..");
            Thread.sleep(MACHINE_CREATION);
            cars.add(new Car());
            System.out.println("Автосалон: машина у нас.");
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getSoldCars() {
        return countMachine;
    }
}
