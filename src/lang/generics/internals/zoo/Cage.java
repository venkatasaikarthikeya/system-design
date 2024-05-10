package lang.generics.internals.zoo;

public class Cage<T extends Animal> {

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
}
