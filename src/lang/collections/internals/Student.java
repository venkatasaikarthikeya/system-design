package lang.collections.internals;

import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparable<Student> {

    private Integer id;
    private String name;
    private Integer age;
    private Long zipcode;

    public static Comparator<Student> nameComparator = new Comparator<Student>() {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    public static Comparator<Student> ageComparator = new Comparator<Student>() {

        @Override
        public int compare(Student o1, Student o2) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    };

    public static Comparator<Student> zipcodeComparator = new Comparator<Student>() {

        @Override
        public int compare(Student o1, Student o2) {
            return Long.compare(o1.getZipcode(), o2.getZipcode());
        }
    };

    public Student(Integer id, String name, Integer age, Long zipcode) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.zipcode = zipcode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Long getZipcode() {
        return zipcode;
    }

    public void setZipcode(Long zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + ", zipcode=" + zipcode + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student other = (Student) o;
        return Objects.equals(id, other.id) &&
                Objects.equals(name, other.name) &&
                Objects.equals(age, other.age) &&
                Objects.equals(zipcode, other.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, zipcode);
    }

    /*
        Returns ->
            = 0 => if this.id and o.id are equal
            > 0 => if this.id > o.id
            < 0 => if this.id < o.id
    */
    @Override
    public int compareTo(Student o) {
        return Integer.compare(age, o.age);
    }
}
