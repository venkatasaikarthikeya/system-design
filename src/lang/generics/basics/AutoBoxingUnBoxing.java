package lang.generics.basics;

import java.util.Arrays;
import java.util.List;

public class AutoBoxingUnBoxing {

    @SuppressWarnings("removal")
    public static void main(String[] args) {

        /*
            Generics only work with Java types but not primitive types
            ArrayList<int> is not valid because int is a primitive and Generics only work with Objects i.e. Java types

            Then how does everything work? For example:
            A) List<Integer> numbers = Arrays.asList(1, 2, 3);
            How is the above statement acceptable instead it should be like:
            B) List<Integer> numbers = Arrays.asList(new Integer(1), new Integer(2), new Integer(3));

            A is acceptable because of concept called Autoboxing and Unboxing which has been introduced in
            Java 5 along with Generics. This is not a coincidence, it is intentional because if boxing is not there,
            then Generics would not work appropriately.
        */

        // primitive type
        int a = 1;

        // java type
        Integer b = new Integer(2);

        /*
            The below two lines try to assign a primitive to java type and assign a primitive integer to java Integer.
            Ideally, the compiler should through error, but it is not the case.
            This is because of Autoboxing.

            In Java 5, for every primitive type Wrapper classes are created to promote flexibility.
            int - Integer, float - Float, double - Double etc.,
            So, when you assign a primitive value to Integer variable, then the value is auto boxed to Integer object
            Hence, this is valid.
        */
        Integer x = a;
        Integer y = 1;

        /*
            On similar ground, we can directly assign a java type object to a primitive type variable.
            This is because of Unboxing.

            The below 2 lines try to assign Integer object reference to int primitive variable and an actual Integer
            object to primitive int variable. So, when this is done, the Object is unboxed and the actual numeric value is
            given to the variable. Hence, no error.
        */
        int d = b;
        int e = new Integer(2);

        /*
            What does these have to do with Generics?
            See the below code?
            If you want to assign a list of values to List<Integer>, then how do you do this?
            List<Integer> numbers = Arrays.asList(new Integer(1), new Integer(2), new Integer(3));
            Doesn't this seem like a pain in the ass.
            Now that we have Autoboxing and Unboxing the above piece of code could be as simple as:
        */
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        /*
            So, the java run time auto boxes 1, 2, 3 into Integer objects before it puts them in the list.
            That is why Autoboxing and Unboxing were introduced along with Generics in Java 5
        */
    }
}
