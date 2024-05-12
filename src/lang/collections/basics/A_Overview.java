package lang.collections.basics;

import java.util.Collection;

public class A_Overview {

    public static void main(String[] args) {
        /*
            Collection is a Framework and not a library
            It gives us a way to create our own collections using a standard API

            Benefits:
            1. It's done for you
            2. High-performance implementations
            3. Improves code reusability and maintainability
            4. Offers good 'preset' data structures
            5. Common vocabulary for collections

            What collections framework gives us?
            1. Core interfaces (Ex. List)
            2. Specific implementations (Ex. ArrayList) - More Specific
            3. Abstract implementations (Ex. AbstractList) - Starting point for you to create your own collections
            4. Concurrent implementations (Ex. ConcurrentHashMap) - For thread safety
            5. Algorithms (Ex. sort, binarySearch)
            6. Utilities (Ex. Arrays.compare)

            Collection Interfaces: Collection, Map

            Why do we have a separate Map why can't we have Map under Collection and have 1 root Collection interface?
                Implementations of Collection interface like List, Set, Deque, Queue all hold discrete elements, and they
            take a discrete element and give a discrete element whereas Map doesn't take discrete elements. Instead, it
            takes an association of key and its value. Therefore, the nature of the map itself makes it very different
            from other discrete data structures because of which it is not suitable to put Map below Collection. So, we
            have it as another root interface

            Generalization: Flexibility vs Power
            If you need more specific implementation like HashSet to use all of its methods - It is Power
            If you don't need that much functionality and if you want to pass it for other generalized methods than - It is Flexibility

            You should always go for higher implementations such that it has all functionality which you wanted. For example,
            if you just want to add, get, remove elements, always choose a List over ArrayList.

            Types of Collections:
            1. Index based retrieval collections
            2. Immutable collections
            3. Order based retrieval collections

            Collection Interface: It should have only the methods that are common to all of its descendants
            what methods should it have?
            Adding by index - but set doesn't need an index because no ordering
            Fetching next element - No next element for set
            Finding duplicate elements - No duplicates for set
            Removing an element - you can't remove from an Immutable collection
            Sorting - Sorting on set is not meaningful as it has no order

            If we go in this way we might end up having a separate hierarchy for each specific type

            Collection interface handles this in two ways:

            Two Ways:
            1. Optional methods - If some specific type don't need that functionality, they can throw UnSupportedOperationException
            2. Iterator pattern - Specific collections have their own ways to traverse, to eliminate this, it introduced Iterator for traversing

            So, what all things do Collection interface provide?
            1. Constructors for creating a collection
            2. Adding objects (without specifying where)
            3. Removing objects (without specifying where)
            4. Check if object exists
            5. Convert to Array
            6. Clearing whole collection

            Note: About Generalization (Flexibility vs Power) - Be as Flexible as possible with necessary Power
            Go as high up in the generalization as possible without losing the necessary power you need. If all you need is adding and removing
            elements just go with the Collection interface rather than ArrayList because you get the required Power with Collection and you
            will eventually get a lot of Flexibility.
        */
    }
}
