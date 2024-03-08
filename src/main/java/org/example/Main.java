package org.example;

import org.example.singleton.egar.Engine;
import org.example.singleton.lazy.Car;

public class Main {
    public static void main(String[] args) {
        //It will gives you compile error
        // Car car = new Car();

        Car car1 = Car.getCar(); //it is lazy way
        System.out.println(car1.hashCode());

        Car car2 = Car.getCar();
        System.out.println(car2.hashCode());

        //both car1 and car2 will have same hashcode, as only one object is created

        System.out.println(Engine.getEngine().hashCode());
        System.out.println(Engine.getEngine().hashCode());
    }
}