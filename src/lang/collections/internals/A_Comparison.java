package lang.collections.internals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A_Comparison {

    public static void main(String[] args) {

        /*
            Comparable Interface:

            public interface Comparable<T> {
                public int compareTo(T o);
            }

            compareTo() method returns:
                0   => if this.attribute == o.attribute
                +ve => if this.attribute > o.attribute
                -ve => if this.attribute < o.attribute

            The compareTo() method is from Comparable<T> interface. Comparable<T> gives a Natural Ordering for a class. Natural
            Ordering in this context means that, given a class, if you want to naturally order the objects of that
            class using an attribute then that is natural ordering.

            For example,
            for Student class -> student id can be used for natural ordering
            for Bank Account class -> account id can be used for natural ordering

            So, if you think, it is logical to give a natural ordering for the objects of a class, then you can make
            that class implement Comparable<T> interface and override compareTo method.

            Sometimes, it might not be meaningful to give a natural ordering. For example, it is not logical to order
            the objects of a Database connection class. In such cases, you won't implement Comparable<T>

            There might be some other scenarios where you want to give custom ordering for the elements of a collection
            apart from natural ordering. You might want to order the objects of the same class in multiple ways in
            multiple situations.
            For example, in general student objects are ordered by id
            1. But before taking attendance, you might want to order them by name
            2. while dropping the students at home, you might want to order them by zipcode

            So, the same student objects might want to be ordered in different ways in different situations. In such
            situations Comparable<T> might not be a good choice because you can't have that flexibility with Comparator.

            For this purpose we have Comparator<T> interface

            Comparator Interface:
            A comparison function, which imposes a Total Ordering on some collection of objects.
            Comparators can be passed to a sort method such as Collections.sort(List, Comparator) or
            Arrays.sort(Object[],Comparator)) to allow precise control over the sort order.

            You might want to implement compare() method of Comparator for total ordering

            interface Comparator<T>() {
                public int compare(T o1, T o2);
                //......
            }

            compare() method returns:
                0   => if o1.attribute == o2.attribute
                +ve => if o1.attribute > o2.attribute
                -ve => if o1.attribute < o2.attribute

            Then you can use that comparator to sort student by name
            Collections.sort(students, nameComparator);

            Refer the code below
        */

        List<Student> students = new ArrayList<Student>();

        Student s1 = new Student(4, "Venkata", 24, 90818L);
        Student s2 = new Student(1, "Sai", 21, 90815L);
        Student s3 = new Student(3, "Keya", 23, 90819L);
        Student s4 = new Student(2, "Karthik", 25, 90817L);

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        Collections.sort(students);
        printStudentList(students);

        // Sort students by name
        Collections.sort(students, Student.nameComparator);
        printStudentList(students);

        // Sort students by age
        Collections.sort(students, Student.ageComparator);
        printStudentList(students);

        // Sort students by zipcode
        Collections.sort(students, Student.zipcodeComparator);
        printStudentList(students);
    }

    private static void printStudentList(List<Student> students) {
        for (Student student : students) {
            System.out.println(student.toString());
        }
        System.out.println();
    }
}
