package Day012;
/*
    Containment in Java also called composition in javas is an object oriented programming concept where  class contains an object of another class as an memebr.
     
    It represents a "has-a" relationship between two classes.
    Unlike inheritance represents an "is-a" relationship.
    
    Key Points
    1) Has -A relationship - A class hahs another class object.
    2) code Resuability - insteaf of inherting by including object of another class.
    3) Flexibility - changes in one class does not affect other class./Easier to change Relationships.Compared to inheritance.
    */

class engine {
    void start() {
        System.out.println("engine started");

    }
}

class Car {
    engine eng;

    Car() {

        eng = new engine();
    }

    void drive() {

        eng.start();
        System.out.println("car is driving");

    }
}

public class composition {

    public static void main(String[] args) {
        Car cr = new Car();
        cr.drive();

    }
}
