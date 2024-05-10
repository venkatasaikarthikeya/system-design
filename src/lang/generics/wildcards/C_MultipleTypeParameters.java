package lang.generics.wildcards;

import java.util.HashMap;
import java.util.Map;

public class C_MultipleTypeParameters {

    public static void main(String[] args) {
        /*
            Generic Type may have multiple type parameters.
            All the type parameters of a generic type are separated with Commas
            For example:
            A Map interface has 2 type parameters
            1. Key - K
            2. Value - V
        */
        Map<Integer, String> map = new HashMap<Integer, String>();

        /*
            Takeaway:
            1. A generic type can have multiple type parameters
            2. All type parameters should be comma separated
        */
    }
}
