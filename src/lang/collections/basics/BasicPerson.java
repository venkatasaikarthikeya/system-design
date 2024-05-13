package lang.collections.basics;

import java.util.Objects;

public class BasicPerson {

    private int id;
    private String name;
    private Integer age;

    public BasicPerson(int id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    /*
        So, we would like to provide a custom equals() implementation.

        Do we blindly check for equality of all the properties?
            The answer is NO. We would only want to check for equality of properties which really make sense. We
        only want to check the equality for Object details but not the implementation details. For example, if we
        have name, id, lastRetrievedTimeStamp properties in a class, the lastRetrievedTimeStamp property might be an
        implementation detail from an ORM or another framework. So, that property is unique for every object. So, we
        should not check for equality of such properties.

        We should only check for equality of properties which are relevant in the context of equals()
    */
    @Override
    public boolean equals(Object obj) {
        // If both are holding same reference, they are pointing to same object, hence don't do further checking
        if (this == obj)
            return true;
        // Either obj is null or if both objects are of different class types, then return false
        if (obj == null || getClass() != obj.getClass())
            return false;
        // At this point we know that both are not null and both are of same class type. Hence, typecast.
        BasicPerson person = (BasicPerson) obj;
        /*
            Here comes the actual equality check and this part is very crucial.

            For primitive types, like id in the above case, == checks for actual value, so for primitive types
            do a == check.

            For Java types, like 'name' in the above case, == checks for reference and not contents, so we can't
            rely on ==. So, use equals() method of String class like:

            name.equals(person.name)

            But, there are few more checks which need to be added before the above check is made.
            1. this.name and person.name might be null - should return true in this case
            2. this.name might be null - in that case the above statement through NullPointerException
            3. After the above two, the name.equals(person.name) should be added

            So, result would be

            (name == person.name || (name != null && name.equals(person.name)))

            Instead of handling the above null checks by ourselves, Jaa provides a Objects.equals() method to
            handle all the null checks, and it boils down to as simple as below:
        */
        return id == person.id && Objects.equals(name, person.name)  && Objects.equals(age, person.age);
    }
}
