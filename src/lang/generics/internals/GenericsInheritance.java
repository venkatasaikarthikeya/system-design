package lang.generics.internals;

import java.util.ArrayList;
import java.util.List;

public class GenericsInheritance {

    public static void main(String[] args) {

        List<String> names = new ArrayList<String>();
        names.add("Name 1");
        names.add("Name 2");

        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);

        /*
            Now, I want to create a method that can accept both the above list types and read contents from them.
            See, the method below which we created for this purpose
            Now, I will call that method with names, numbers.
        */
        // printList(names);
        // printList(numbers);
        /*
            Why does compiler show an error for the above two lines? Why is not allowing us to pass List<String>,
            List<Integer> when the expected type is List<Object> even though the String and Integer are subtypes
            of Object?

            What is the compiler would have allowed this?
                If the compiler allowed this, then what would stop us from doing the below:

            private static void printList(List<Object> objects) {
                for (Object object : objects) {
                    System.out.println(object);
                }
                objects.add(23.567);
            }

            So, as long as you read from List<Object> it won't be a problem, but if you write to it, then you can write
            anything which is a subtype of Object to a List<Object>.

            ****AGAIN TYPE SAFETY IS GONE****

            To avoid this, the compiler doesn't allow a <Base> type to accept <Derived1> type as another <Derived2> type
            can destroy the type safety.

            How do we solve this?

        */
    }

    /*
        Now, in order to accept the both List<Integer> and List<String>, we created a List<Object> variable because
        Object class is a super class of Integer and String classes.

        But, will this work?
    */
    private static void printList(List<Object> objects) {
        for (Object object : objects) {
            System.out.println(object);
        }
        objects.add(23.567);
    }
}
