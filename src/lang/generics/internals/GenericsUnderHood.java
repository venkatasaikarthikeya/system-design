package lang.generics.internals;

import java.util.ArrayList;
import java.util.List;

public class GenericsUnderHood {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        addToNames(names, "Name 1");
        addToNames(names, "Name 2");
        System.out.println(names);
        // names.add(5);
        /*
            If I try do add something like above, the compiler throws an error, saying that it's not allowed
            because it is not a String. Perfectly fair.
        */

        /*
            What if I do something like below by creating a new method
        */
        incorrectAddToNames(names, 3);
        System.out.println(names);
        /*
            So, according to the above this doesn't seem to be an error to the compiler.
            If I directly try to add an integer to the names, it is a problem to the compiler. But, if I do it
            by passing it to another method by removing the type inside that target method, that seems to be fine
            for the compiler.

            See the problem with this:
            String nameThree = names.get(2); // This throws a ClassCastException
        */

        /*
            So, basically Generics is a Compile time construct, and it has nothing to do with the actual instances.
            In the above approach, the compiler was not throwing an error because, the compiler associates the generic
            type with variable name but not with the underlying instance.

            If it had associated the Generic type with the underlying instance, then the other method also would never allow
            an integer to be added to a list of strings.

            All this is because Generics is a Compile Time Construct. It has been created to help the developers by throwing
            compile time errors by the compiler to not get into ClassCastExceptions.

            Code with Generic types -> Compiler -> Compiled Successfully -> ByteCode
            The ByteCode would not have generics at all. This phenomenon is known as Type Erasure. So, at run time there might be
            a possibility for an integer to be added to a list of strings.

            But, we can avoid it during compile time. That is the main advantage of Generics.
        */

        /*
            Why should the Java language still allow Collections without Generic Types? If it doesn't allow it, then we would
            not have run into the above error case?
                Java basically provides a lot of backwards compatibility so that it would not be a pain for developer who
            wrote their code in older version constructs. It doesn't do breaking changes. Even it has backward compatibility
            with the very older versions of Java.

            So, no scope to avoid this. So, the only solution is to use Generic types everywhere.

            Takeaways:
            1. Generics is a compile time construct
            2. List<Type> names = new ArrayList<>();
               List<Type> is only associated with the variable 'names', it has nothing to do with the underlying instance of
               ArrayList<>()
            3. Type Erasure: Once a code is successfully compiled, all the generic types are removed from the code before it is run
        */

        /*
            Note:
            We can assign a generic type to a raw type
            List x = names; // This is not an error

            We can assign a raw type to a generic type
            List x = new ArrayList();
            List<String> y = x; // Not an error

            All of this is again because of the backwards compatibility story.
        */
    }

    private static void addToNames(List<String> names, String s) {
        names.add(s);
    }

    private static void incorrectAddToNames(List names, Integer s) {
        names.add(s);
    }
}
