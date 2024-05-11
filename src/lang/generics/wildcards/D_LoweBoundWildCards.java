package lang.generics.wildcards;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class D_LoweBoundWildCards {

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        printList(integers);

        List<Double> doubles = new ArrayList<Double>();
        doubles.add(1.0);
        doubles.add(2.0);
        doubles.add(3.0);
        printList(doubles);

        List<? extends Number> upperBoundExample;
        upperBoundExample = integers; // valid
        upperBoundExample = doubles; // valid
        Number readFromSuperTypeNumbers = upperBoundExample.get(0); // Compiler knows the elements would at least be a number

        /*
            We have already seen the Upper Bound wildcards where, inorder to read anything that is a <Number> we have used an
            upper bound generic type i.e. <? extends Number>, so that it accepts any List of type that extends Number. So, we
            can assign a List<Integer> to List<? extends Number> and read Number from it and call Number class methods on these.
            Similarly, we can assign a List<Double> or List<Float> to List<? extends Number> and read Number from it and call
            Number class methods on these. Here, the target type should be at least a Number or any of its subtypes, so that we
            can read Number from it.
            List<Integer> integers = new ArrayList<Integer>();
            List<Double> doubles = new ArrayList<Double>();
            List<? extends Number> numbers;
            numbers = integers; // valid
            numbers = doubles; // valid
            Number element = numbers.get(0); // This returns a number because the compiler only knows that it is at least a Number

            *****LOWER BOUND WILD CARDS*****
            Motivation: With Upper bound types your use case would be like If you want to receive any subtype of class and read that
            class from it. It doesn't provide you a way to add elements to it. What if you want to do this is the motivation for
            Lower bound wild card types.

            Use case: I have a List<Number> numbers and I would like to accept List<Any Super Class of Number> so, that I can add a
            Number or any of its subtypes to that list.

            We can't do it with upper bound wild cards. Hence, we need Lower bound wild cards for this purpose.
        */

        List<Object> objects = new ArrayList<Object>();

        List<? super Number> lowerBoundExample;
        // lowerBoundExample = integers; // Not valid
        lowerBoundExample = objects; // valid because Object is a super type of Number
        lowerBoundExample.add(5); // adding a Integer
        lowerBoundExample.add(3.0); // adding a Double
        lowerBoundExample.add(2.0f); // adding a Float

        Object readFromLowerBoundExample = lowerBoundExample.get(0); // Compiler knows the elements would at least be an Object


        /*
            Takeaway:

            Note: PECS (From generic type point of view) -> Producer Extends Consumer Super
            1. <?> - Unbounded Wild card type (Accepts Anything) - READ as Objects
            2. <? extends ClassName> - Upper bounded wild card type (Accepts Anything which extends ClassName including ClassName) - READ as ClassName
            3. <? super ClassName> - Lower bounded wild card type (Accepts Anything which is Super class of ClassName including ClassName) - Write as subclass of ClassName, READ as Objects
        */
    }

    /*
        This can take anything that is a List<Number> to any of its super classes, so that we can write
    */
    private static void addToList(List<? super Number> elements) {
        elements.add(1);
        elements.add(2.0);
        elements.add(3.0f);
    }

    private static void printList(List<? extends Number> elements) {
        for (Number number : elements) {
            System.out.println(number);
        }
        Number number = elements.get(0);
    }
}
