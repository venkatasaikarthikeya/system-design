package lang.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class B_UpperBoundWildCards {

    public static void main(String[] args) {

        /*
            Till now, we have seen two types of acceptance: (Only a specific type or Any type)

            1. Accept a specific type like (<SpecificType> accepts <SpecificType>)
            List<Integer> x = new ArrayList<Integer>();
            List<Integer> y = x;
            List<Object> z = x; // Throws an error

            2. Accept any type like (<?> accepts <Anything> for example <Integer>, <String>, etc..,)
            List<Integer> x = new ArrayList<Integer>();
            List<?> y = x; // Works fine but only READS are allowed

            What if we want to Accept something between SpecificType and Anything?
                The solution to this is '<? extends Upperbound>'

            See the example below:
                I have a list of integers and a list of doubles. Now, I want a printList function which
            accepts both the List<Integer> and List<Double> i.e. it should basically accept a List<Number>
            because Integer and Double are subtypes of Number. The function should not accept any other list
            types which are not subtypes of Number.

                We know that List<?> accepts anything and List<SpecificType> accepts only that SpecificType, now
            we want a flexibility such that the List should accept anything which is a subtype of Number. To do
            this we have
            List<? extends Number>
            What this means to the Compiler is, to accept a List of any type that extends Number.

                Similar to <?>, we can only READ the elements from this, but we can't WRITE to this. Because, if
            we allowed WRITEs on this, then what stops someone to add a Double value to a List<Integer> values
            which again destroys type safety. Hence, only READ is supported but not WRITE.
        */

        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        printList(numbers);

        List<Double> doubles = new ArrayList<Double>();
        doubles.add(1.0);
        doubles.add(2.0);
        doubles.add(3.0);
        printList(doubles);

        /*

        */

    }

    private static void printList(List<? extends Number> numbers) {
        for (Number number : numbers) {
            System.out.println(number);
        }
        // When we get en element out of the collection, its type would be Number
        Number number = numbers.get(0);
    }
}
