package lang.generics.basics;

import java.util.ArrayList;
import java.util.Date;

public class WhyGenerics {

    public static void main(String[] args) {

        /*
            Let's assume a world without generics. I want to add names to an ArrayList.
            This is how I would do this if I don't have generics
        */
        ArrayList names = new ArrayList();
        names.add("John");
        names.add("Jane");
        names.add("Jack");

        /*
            String firstName = names.get(0); // This throws compilation error

            So, by default if you don't specify generics, the ArrayList's add(Object) method takes an Object type
            and the get() method returns an Object type.

            In the above code you are getting an Object type from ArrayList and assigning it to a String variable
            which is not allowed. Hence, the above code throws compilation error.

            Solution to this is to type cast the Object type to String type after getting it from get() method.
        */

        String firstName = (String) names.get(0);
        System.out.println(firstName);

        /*
            So, the first drawback of not using generics is:
            1. You need to explicitly cast everything before assigning it to a variable

            What if I were to add a Date object to the names arraylist above by mistake
        */

        /*
            names.add(new Date());
            String fourthName = (String) names.get(3);
            Observe that the compiler doesn't throw any error because the responsibility of adding the right types is
            completely on you. Now, if you try to run this, you would get a class cast exception because
            a Date type can't be cast to a String type. Hence, you will get an error. So, this is not safe.

            So, the two drawbacks of not using Generics are:
            1. Explicit type cast everytime when you access an object of a collection
            2. No type safety. You can even add a Cat object to names and no one will stop you doing that which finally gives
                a class cast exception
        */

        ArrayList<String> newNames = new ArrayList<String>();

        newNames.add("John");
        newNames.add("Jane");
        newNames.add("Jack");

        String nameOne = newNames.get(0);
        System.out.println(nameOne);

        /*
            Observer that we are not casting this to a String explicitly because the compiler takes the responsibility on behalf of
            us, and it sees that only Strings are added to the arraylist. Hence, there is no need for explicit casting.

            newNames.add(new Date());
            The above line throws a compile time error and the compiler doesn't allow us to do this because it knows the list should
            only have strings because we specified it through a Generic

            Hence, there is no scope for a class cast exception. This is how generics make out lives easier.
        */
    }
}
