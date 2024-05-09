package lang.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class A_GenericsWildCards {

    public static void main(String[] args) {
        /*
            From the previous lecture, we are still in the same problem. The problem statement is, I have a
            List<Integer> and List<String>, I want a method that takes any of these and read and update the value.
            From the previous lecture, if we use a List<Object> the Compiler doesn't allow us to do this
            because even though Object is a super type of Integer, String, if the compiler allows it what
            stops the developer from adding a Float into List<String> inside that function. For this exact reason,
            the compiler was throwing error in the previous scenario.

            Things to remember:
            1. Inheritance, polymorphism with Generics is not the same as plain class and object scenarios.
            2. A specific type is not allowed for a Super type (<Integer> is not allowed for <Object>)

            Now, we are back at the same problem:
            Do we have a solution?
                Yes, Generics give us a Wildcard '?' that represents any type. So, in our case if the method receives
            the lists as List<?> then what it means to the Compiler is:
            1. Let any List<> to pass in to the function
            2. However, you don't allow the developer to add anything to the list. Just READ is allowed but not WRITE

            So, the below code doesn't throw any error.
        */
        List<String> names = new ArrayList<String>();
        names.add("Name 1");
        names.add("Name 2");
        printList(names);

        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        printList(numbers);

        /*
            So, the above code works perfectly fine as long as no one attempts to write anything to the
            list inside the function which is receiving them as List<?>.

            Takeaway:
            1. <?> tells the compiler to allow anything
            2. It also tells the compiler to throw an error is someone attempts to WRITE to <?>
        */

        /*
            Note:
            List<?> somethings = numbers;
            somethings.add(2); // Compiler throws an error
            You might argue that just in the above line itself we are assigning it to numbers, so what's wrong
            in adding a number in the next line.
                You know what, the compiler doesn't care. It doesn't have to check flow and all. All it checks is the type
            of 'somethings'. It is List<?>, so WRITE is not allowed. That's it. It doesn't care anything else.
        */

        /*
            Where we go from here?
                Now, we have seen <SpecificTypes> like <Integer>, etc.., and we have <?> that takes anything. What if we
            want something in between. For example, I want to accept all the numbers i.e. accept only <Integer>, <Float>
            and <Double> as these are subtypes of <Number>, but I don't want to accept any other types like <String>, etc..,

            To do this, we need bounds. We have 2 types of bounds namely Lower bound and Upper bound.
        */


    }

    /*

    */
    private static void printList(List<?> elements) {
        for (Object element : elements) {
            System.out.println(element);
        }
        // elements.add(1);
        /*
            The compiler is throwing an error for the above line because '?' only allows us to READ from it
            but not WRITE to it. Because, if it allows us to WRITE to it, what stops us from adding a
            Floating point number like:
            elements.add(57.5);
            which again destroys type safety.
        */
    }
}
