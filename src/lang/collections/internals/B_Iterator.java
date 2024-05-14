package lang.collections.internals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class B_Iterator {

    public static void main(String[] args) {
        /*
            Iterator Pattern:
            Iterator is a way to traverse a collection of objects without exposing its underlying representation.

            We know traversing an ArrayList is different from traversing a Set and every specific collection
            type has its own way to allow the users to traverse the collection. List has ordering so, it can
            be traversed in an orderly manner while a Set in itself has no ordering, so we can't traverse a Set
            the same way how we traverse a List. Hence, every collection has its own way for traversing it.

            So, if we want to traverse any collection without bothering about the underlying representation, then
            the solution to this is Iterator.

            Iterator:
            * Implementation agnostic
            * separates the traversal algorithm from the collection
            * provided by a separate iterator object

            Syntax:
            1. Get iterator object from a collection object
            Iterator<String> iterator = fruits.iterator();

            2. Check if there is a next element in the collection
            boolean isNextAvailable = iterator.hasNext();

            3. Get the next element in the collection
            String nextElement = iterator.next();
        */

        Collection<String> fruits = getFruits();

        // Get iterator from collection object
        Iterator<String> iterator = fruits.iterator();
        // Iterate until you have a next element
        while (iterator.hasNext()) {
            // Get the next element in the collection
            String fruit = iterator.next();
            System.out.println(fruit);
        }

        // The below syntax is known as Enhanced for loop. The below syntax can be considered equivalent to above syntax
        // can be used when you want to iterate a collection that implements Iterable interface. Instead of getting an
        // iterator and iterating through it the below syntax would be more concise
        for (String fruit : fruits) {
            // Get the next element in the collection
            System.out.println(fruit);
        }

        /*
            Fail Fast Iterators:
                A fail fast iterator is an iterator which is not tolerant to underlying changes.

            * Iterators not tolerant to underlying changes
            * uses an internal modification counter (after ever iterator.next() call it checks if counter is updated -> if
            the underlying collection has changed, then counter would be updated)
            * Then it throws a ConcurrentModificationException if modified since last next()

            So, whenever we want to iterate through a collection -> we get an iterator from the collection object ->
            while iterating the collection using iterator, if someone alters the collection on which this iterator
            is iterating -> then the iterator may get confused as the underlying collection would be different from
            what it is iterating on -> then it through a ConcurrentModificationException

            Such iterators are called Fail Fast Iterators. The iterator which we created for fruits example is a Fail
            fast iterator.

            Fail fast iterators throw ConcurrentModificationException on a best effort basis.

            There are some other iterators which are tolerant to underlying changes...we shall see later.

            There is also a way to change underlying collection without getting an exception while iterator is
            iterating over the collection. The way is to tell the iterator what to add and remove so that it can plan
            and iterate accordingly.
        */
        while (iterator.hasNext()) {
            // Get the next element in the collection
            String fruit = iterator.next();
            // iterator removes the fruit
            iterator.remove();
            System.out.println(fruit);
        }

    }

    private static Collection<String> getFruits() {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        return fruits;
    }
}
