package lang.collections.basics;

public class B_Equals {

    public static void main(String[] args) {

        /*
            There are two types of equality in Java:
            1. Referential Equality
            2. Object Equality

            1. Referential Equality:
                The == operator which we use for comparison of two objects, always check for referential equality but
            not object equality. The operator checks if two variables are holding the same reference. In other
            words it tells if two variables are pointing the same instance.
            Example:
            See BasicPerson.java class. Let's create an instance of it
        */
        BasicPerson p1 = new BasicPerson(1, "Sai", 25);
        BasicPerson p2 = p1;
        // Now p1 is pointing to an instance of BasicPerson, and we have assigned p2 to p1
        // With this p2 will also point to the same instance
        // So, if we do a == operation on them, it should return true as they are referentially equal
        System.out.println(p1 == p2); // Prints true

        /*
            But, most of the time this is not what we want. We would like to check if two objects are having same
            contents and this is what means by object equality in Java.
            Is == operator not sufficient for this?
                No, it is not sufficient. Let's see the below example:
        */
        BasicPerson p3 = new BasicPerson(1, "Sai", 25);
        /*
            Now, if you see the object to which p3 is pointing to also has the same values as p1. So, ideally if you
            do a p1 == p3, our expectation would be to get true. But, that is not the case.
        */
        System.out.println(p1 == p3); // Prints false
        /*
            The above statement prints false. The answer is simple they are not referentially equal and the compiler
            doesn't care if their contents are equal or not.

            The solution to this is to utilize the equals functionality every class gets from the root class called as
            Object class.

            What's the Object class?
                So basically, in Java there is an Object class which is a parent of all the classes, and it's a root class.
            Every class which you create extends Object class by default, and you don't extend it manually, it is implied.
            The object class has 3 methods: toString(), equals(), hashcode()
            So every class gets these 3 methods from the Object class.

            So, let's see what happens if call p1.equals(p3). Does it do a content equals?
        */
        System.out.println(p1.equals(p3)); // Prints false
        /*
            The above statement also prints false. Let's have a look at the equals() method of object class to check why it returned
            false.

            public boolean equals(Object obj) {
                return (this == obj);
            }

            If you see the default implementation of equals() method from Object class, even it is doing a referential equality
            check, which is the reason behind the false printed for the above statement.

            So, the only thing which we could do to check for Object equality is to override the equals() method which a class
            received from Object class and specify a custom behavior for that, so that, when we p1.equals(p3) method, the custom
            behavior given by us will be invoked, and we get the expected result as True when contents of both objects are equal.

            Let's go to the BasicPerson.java and override the equals() method as per our needs.
        */

        /*
            Take Away:

            Default equals() method:
            * Allows implementations to override
            * Standard API to compare: 'p1.equals(p2)'
            * Defaults to comparing reference

            The Collections Contract: For collections to work effectively for class like List<BasicPerson>, we should provide
            appropriate equals behavior for the BasicPerson class, so that collections understand which is what.
            1. Set - no duplicate elements => uses equals() of BasicPerson to check duplicates
            2. 'contains' method in collection interface => uses equals() of BasicPerson to check if object is present
            3. so much more - Hence, it is very important to override equals to make collections work appropriately

            The equals() method:
            1. used to check object equality
            2. default implementation checks memory address
            3. can be overridden to provide custom implementation
            4. should be based on data members that matters

            The equals contract: Whenever you implement equals() all below properties should be satisfied

            1. Reflexivity: An object should be equal to itself
            Point p1 = new Point(1, 2);
            p1.equals(p1); // should return true

            2. Symmetry: if x is equal to y, then y should also be equal to x
            Point p1 = new Point(1, 2);
            Point p2 = new Point(1, 2);
            p1.equals(p2);
            p2.equals(p1);
            // if one of above is true, both should be true

            3. Transitivity: if x is equal to y, y is equal to z, then x should also be equal to z

            4. Consistency: should return the same result unless the state of the object has been modified

            5. Non-nullity: An object should never be considered equal to null
            Point p = new Point(1, 2);
            p.equals(null); // should always return false
        */


    }
}
