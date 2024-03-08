package org.example.singleton.lazy;

/*
1. Making constructor private:
        when an object is created a constructor calls invoke, how about restricting constructor
        So it won't invoke.
        We can make it as private, so no object would be created using new keyword further.

2. Getting object from a method:
        Now, we will be creating a method which will be returning object of this class.
        But, it's tricky if we create function like : (non-static)
        public Car getCar(){

        }

        If function is non-static , it would require an object to access this method, that means singleton
        concept is violating.
        For flow, we will be making it as static. So using class name we can access this.

3. creating field of object as private and static:
        as static function will be using this field, so have to make it as static.

4. it is lazy way of creating single object:
        Until client doesn't call Car.getCar(), it won't be created

cons:
5. Synchronized method:
If thread safety is your concern, then lazy initialization of object need to be synchronized
For example:
if only one thread is there ,then it is useful.
But if multiple threads are there, and we know threads run concurrently, then it's a problem
Suppose t1 and t2 thread comes to getCar() method at same time and both created object then it's not sing;eton
concept. So will be using synchronized so at a time only one thread can execute

But here, while getting object there can be other code as well in our method, only we need to synchronized
our object creation line, to synchronized only particular line, will be using synchronized block

6. Synchronized block:

 */
public class Car {

    //3.creating field of object as private and static
    private static Car car;

    //1. making constructor private
    private Car(){

    }

    //4. it is lazy way of creating single object
    //2. Getting object from a method:
    public static Car getCar(){
        //making an object
        /*
        if we create object like
        Car car = new Car();
        this method can be called multiple times, so to avoid that we have make field variable
        and will give a condition
        So only first time it will initialize and rest of time it will be returning same object
         */
        if( car == null){
            car = new Car();
        }
        return car;
    }

    //5.Synchronized method:
    /*public synchronized static Car getCarSynchronized(){
        if( car == null){
            car = new Car();
        }
        return car;
    }*/

    //6. Synchronized block:
    public static Car getCarThreded(){
        if(car == null){
            synchronized (Car.class){
                if( car == null){
                    car = new Car();
                }
                return car;
            }
        }
        return car;
    }

}
