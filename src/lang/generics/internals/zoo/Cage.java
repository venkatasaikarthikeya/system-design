package lang.generics.internals.zoo;

public class Cage<T> {

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
}
