package org.example.singleton.egar;

/*
only one object would be created

cons:
The object would be created when class loads, now what if client haven't used this object,
yet it is created.
so it is not a good way to create singleton object
 */
public class Engine {

    //Eager way of creating singleton object
    private static Engine engine = new Engine();

    public static Engine getEngine(){
        return engine;
    }
}
