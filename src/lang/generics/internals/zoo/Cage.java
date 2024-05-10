package lang.generics.internals.zoo;

public class Cage<T extends Animal & Eats & Runs> {

    private T animal1;
    private T animal2;

    // Default Constructor is necessary if you add any other constructor
    Cage() {}

    Cage(T animal1, T animal2) {
        this.animal1 = animal1;
        this.animal2 = animal2;
    }

    public T getAnimal1() {
        return animal1;
    }

    public void setAnimal1(T animal1) {
        this.animal1 = animal1;
    }

    public T getAnimal2() {
        return animal2;
    }

    public void setAnimal2(T animal2) {
        this.animal2 = animal2;
    }

    public boolean isCompatible() {
        /*
            If you don't write <T extends Animal>, then the method getType() animal would not be available
            to call because, the compiler doesn't know what type is T during compile time and as we know
            well Generics is a compile time construct, so to access a type's super class's functions then
            we might have to definitely specify the Upperbound using <? extends Upperbound>, so that the
            compiler will know that the type should be at least an animal.
        */
        return animal1.getType().equals(animal2.getType());
    }

    public void feedAnimal() {
        /*
            Now, you want to enforce one more restriction. You only want to put Animals in the cage which
            can eat and run. So, we only want animals which implement Eats, and Runs interface, so that
            we can call eat() and run() methods on animal objects.

            So, if you try to call eat() and run() methods on animal1 and animal2, the methods are not even
            available to call because at this moment all that the compiler knows is A cage can have anything
            that is an animal. It doesn't know if that something has the capability to eat and run. To tell
            the compiler that T can eat and run, you might have to do the below

            Incorrect ways:

            1. class Cage<T extends Animal, Eats, Runs> => Compiler considers Eats, and Runs also as type parameters
            The above thing is equivalent Generic type with Multiple type parameters like Cage<A, B, C>

            2. class Cage<T extends Animal implements Eats implements Runs> => Incorrect syntax
            implements is not allowed inside <>

            Correct way:

            class Cage<T extends Animal & Eats & Runs> => Correct syntax

            implications:
            1. We know a class can extend only 1 class in Java, hence for interfaces we can append interface names
               separated by '&' symbols.
            2. <T extends Class & Interface1 & Interface2 & ......>
               The order should class first and interfaces next
            3. If T is not extending anything and only implementing interfaces, then interface can be first
               <T extends Interface1 & Interface2 & .....>
            However the order of interfaces doesn't matter
        */
        animal1.eat();
        animal2.eat();
        animal1.run();
        animal2.run();
    }
}
