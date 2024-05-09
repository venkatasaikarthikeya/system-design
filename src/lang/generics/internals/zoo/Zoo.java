package lang.generics.internals.zoo;

public class Zoo {

    public static void main(String[] args) {
        /*
            A zoo has a lot of cages. Each cage has only animals of same type. For example, a cage of monkeys will
            only have monkeys and a cage of lions will only have lions. We do not put different animals in the
            same cage for example, if I put a monkey and a lion in the same cage, then the Lion would kill and eat
            the monkey. We don't want this to happen. So, we want to have different cages for different types of
            animals. A cage can have at most 2 animals.

            (Assumption: No animals are having a common behavior. So, we can't create a base class or interface)

            Assume we don't want to use generics, so we have created the Cage class with two variables animal1, animal2 which
            are of type Object because as per our assumption we can't create base class or interface. Hence, in order
            to let cage work for multiple types of animals, we made the variables animal1 and animal2 as Object type
            so that it can support multiple types.
        */
        Cage cage = new Cage();
        cage.setAnimal1(new Monkey());
        // what stops us from adding a lion to the above cage
        cage.setAnimal2(new Lion());

        /*
            See, someone mistakenly added a lion to a monkey cage. Now, the monkey was killed and eaten by Lion.
            So, what's the solution?
                USE GENERICS
            If we use generics, we can modify the Cage class with a Type Parameter. Now, if you see the updated cage class,
            we can see that Cage<T> is a parameterized type and with whatever type you create Cage, only that type of animal
            will be allowed in to the cage by the compiler. Obviously, we know this is a compile time construct.
        */
        Cage<Monkey> monkeyCage = new Cage<>();
        monkeyCage.setAnimal1(new Monkey());
        monkeyCage.setAnimal2(new Monkey());

        Cage<Lion> lionCage = new Cage<>();
        lionCage.setAnimal1(new Lion());
        lionCage.setAnimal2(new Lion());
        /*
            monkeyCage.setAnimal1(new Lion()); throws a compile time error saying that the required type is Monkey and the
            actual type is Lion. It asks us to replace lion with a monkey.
            This way our animals are safe.
        */

    }
}
