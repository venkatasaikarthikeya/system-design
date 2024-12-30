package LLD.A_OOPS;

public class OopsMain {

    public static void main(String[] args) {

        Cat catInCatRefVariable = new Cat("Jim", 1, "M", "Pug", 4.5f, true);
        catInCatRefVariable.eat();

        Animal catInAnimalRefVariable = new Cat("Mike", 2, "M", "July", 4.9f, true);
        catInAnimalRefVariable.eat();

        System.out.println(Cat.family);
    }
}
