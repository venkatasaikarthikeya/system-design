## **Nested Classes in Java**

A **nested class** is a class defined within another class. Nested classes logically group together classes that are used in a single unit, making the code more readable and encapsulated. Nested classes have access to the members (fields, methods, and constructors) of their enclosing class, including private members.

---

### **Types of Nested Classes**

Java provides two main types of nested classes:

1. **Static Nested Class**:
    - Declared with the `static` keyword.
    - Does not require an instance of the enclosing class to be instantiated.
    - Can only access static members of the enclosing class.

2. **Non-Static Nested Class (Inner Class)**:
    - Does not have the `static` keyword.
    - Requires an instance of the enclosing class to be instantiated.
    - Can access both static and non-static members of the enclosing class.

---

### **Types of Inner Classes**

Inner classes can be further divided into:

1. **Member Inner Class**:
    - A non-static class declared inside another class.
    - Has full access to all members of the enclosing class, including `private` members.

2. **Anonymous Inner Class**:
    - A class declared and instantiated in a single statement.
    - Commonly used to override methods or provide event-handling functionality.
    - Does not have a name.

3. **Local Inner Class**:
    - Defined within a method or a block.
    - Can only access final or effectively final local variables of the method where it is defined.

---

### **Access Levels of Nested Classes**

Nested classes can have any access modifier:
- **`public`**: Accessible from anywhere.
- **`protected`**: Accessible from the same package or subclasses.
- **`default` (package-private)**: Accessible within the same package.
- **`private`**: Accessible only within the enclosing class.

---

### **Implications of Nested Classes**

1. **Encapsulation**:
    - Nested classes help logically group classes that are used together, improving readability and organization.

2. **Access to Enclosing Class Members**:
    - Non-static nested classes (inner classes) have access to all members (including private) of the enclosing class.
    - Static nested classes can only access static members of the enclosing class.

3. **Tight Coupling**:
    - Nested classes can tightly couple the functionality of two classes, which may or may not always be desirable.

4. **Reduced Visibility**:
    - Nested classes can be made `private`, hiding their implementation from other classes, which is useful for helper classes.

---

### **Examples of Nested Classes**

#### 1. **Static Nested Class**
```java
class Outer {
    static String staticMember = "Static Member";

    static class StaticNested {
        void display() {
            System.out.println("Accessing: " + staticMember);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Outer.StaticNested nested = new Outer.StaticNested();
        nested.display();
    }
}
```

#### 2. **Member Inner Class**
```java
class Outer {
    String nonStaticMember = "Non-static Member";

    class Inner {
        void display() {
            System.out.println("Accessing: " + nonStaticMember);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.display();
    }
}
```

#### 3. **Local Inner Class**
```java
class Outer {
    void outerMethod() {
        String localVariable = "Local Variable";

        class LocalInner {
            void display() {
                System.out.println("Accessing: " + localVariable);
            }
        }

        LocalInner localInner = new LocalInner();
        localInner.display();
    }
}

public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.outerMethod();
    }
}
```

#### 4. **Anonymous Inner Class**
```java
interface Greeting {
    void sayHello();
}

public class Main {
    public static void main(String[] args) {
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello from Anonymous Inner Class!");
            }
        };

        greeting.sayHello();
    }
}
```

---

### **Comparison of Nested Classes**

| **Type**                  | **Requires Enclosing Class Instance** | **Can Access Static Members** | **Can Access Non-Static Members** | **Use Case**                                 |
|---------------------------|---------------------------------------|-------------------------------|-----------------------------------|----------------------------------------------|
| **Static Nested Class**   | No                                    | Yes                           | No                                | Utility classes, grouping related logic.     |
| **Member Inner Class**    | Yes                                   | Yes                           | Yes                               | Requires access to enclosing class members.  |
| **Local Inner Class**     | Yes                                   | Yes                           | Yes                               | Temporary, method-specific logic.            |
| **Anonymous Inner Class** | Depends                               | Yes                           | Yes                               | Event handling or method-specific overrides. |

---

### **Advantages of Nested Classes**

1. **Logical Grouping**:
    - Organizes code by grouping closely related classes together.
2. **Encapsulation**:
    - Hides implementation details from the outside world.
3. **Improved Readability**:
    - Reduces clutter by keeping helper classes within their parent classes.

---

### **Disadvantages of Nested Classes**

1. **Complexity**:
    - Can make code harder to read if overused.
2. **Increased Coupling**:
    - Nested classes tightly couple the outer and inner classes, making them less reusable.

---

### **Best Practices**

1. Use **static nested classes** for utility or helper classes that don’t depend on the outer class instance.
2. Use **member inner classes** sparingly, and only when they add significant value by accessing the outer class’s members.
3. Use **local and anonymous inner classes** for short-lived tasks, like event handling.

By following these principles, you can effectively leverage nested classes in Java to write organized, encapsulated, and maintainable code.

---

## **Anonymous Inner Classes in Java**

An **Anonymous Inner Class** is a type of inner class without a name. It is often used to create a one-time implementation of an interface, abstract class, or even a concrete class. Anonymous inner classes are concise and typically used for short-lived purposes, like event handling or implementing simple functionality.

---

### **Characteristics of Anonymous Inner Classes**

1. **No Name**: They are unnamed and defined directly at the point of instantiation.
2. **Single Use**: Typically used for one-off implementations.
3. **Extends/Implements One Entity**: They can extend a single class or implement a single interface.
4. **Can Access Outer Class Members**: Like other inner classes, they have access to all members of the enclosing class, including private members.
5. **Defined Inline**: The implementation is provided in place of instantiation.

---

### **Syntax of Anonymous Inner Classes**

#### 1. **Implementing an Interface**
```java
interface Greeting {
    void sayHello();
}

public class Main {
    public static void main(String[] args) {
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello from Anonymous Inner Class!");
            }
        };

        greeting.sayHello();
    }
}
```

#### 2. **Extending an abstract Class**
```java
abstract class Animal {
    abstract void makeSound();
}

public class Main {
    public static void main(String[] args) {
        Animal dog = new Animal() {
            @Override
            void makeSound() {
                System.out.println("Woof! Woof!");
            }
        };

        dog.makeSound();
    }
}
```

#### 3. **Using with Concrete Classes**
```java
class Printer {
    void print() {
        System.out.println("Printing...");
    }
}

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer() {
            @Override
            void print() {
                System.out.println("Anonymous Inner Class Printing...");
            }
        };

        printer.print();
    }
}
```

---

### **Limitations of Anonymous Inner Classes**

1. **No Reusability**:
   - Since anonymous inner classes are unnamed, they cannot be reused.

2. **Single Implementation**:
   - They can only extend one class or implement one interface at a time due to Java's single inheritance model.

3. **Limited to One Object**:
   - Each anonymous inner class defines a new class and instance, making it impractical for cases requiring multiple objects of the same type.

4. **Verbose for Simple Operations**:
   - For small operations, the boilerplate can become cumbersome.

---

### **Were Anonymous Inner Classes Replaced?**

**No, they were not replaced**, but **Java 8** introduced **lambda expressions** that serve a similar purpose in certain contexts, specifically for functional interfaces. Lambda expressions provide a more concise way to write code that previously required anonymous inner classes.

**Functional Interface or SAM Interface**: An interface with a single abstract method is known as a Functional Interface.

#### Example: Anonymous Inner Class vs. Lambda Expression

**Anonymous Inner Class**:
```java
Runnable task = new Runnable() {
    @Override
    public void run() {
        System.out.println("Task executed");
    }
};
new Thread(task).start();
```

**Lambda Expression**:
```java
Runnable task = () -> System.out.println("Task executed");
new Thread(task).start();
```

---

### **Current State of Anonymous Inner Classes**

Anonymous inner classes are still fully supported in modern Java. They coexist with lambda expressions and are used when:

1. You need to extend a class or implement multiple methods of an interface.
2. You want access to the enclosing class’s non-final members.
3. The task is more complex than what a single functional method (like in lambda) can handle.

---

### **When to Use Anonymous Inner Classes vs. Lambda Expressions**

| **Feature**                   | **Anonymous Inner Classes**                                      | **Lambda Expressions**                          |
|-------------------------------|------------------------------------------------------------------|-------------------------------------------------|
| **Scope**                     | Can extend a class or implement multiple methods.                | Limited to single-method functional interfaces. |
| **Readability**               | Less concise for simple operations.                              | Highly concise and expressive.                  |
| **Access to Enclosing Class** | Can access all members of the enclosing class, even non-final.   | Can access only effectively final variables.    |
| **Use Case**                  | When working with classes or interfaces having multiple methods. | When working with functional interfaces.        |

---

### **Best Practices for Anonymous Inner Classes**

1. **Use for Specific, One-Time Implementations**:
   - Ideal for event handling or overriding methods in GUI applications.

2. **Avoid Overuse**:
   - For simple single-method interfaces, prefer lambda expressions.

3. **Combine with Encapsulation**:
   - Use anonymous inner classes within private methods or classes to encapsulate their functionality.

4. **Balance Readability and Functionality**:
   - Ensure that the usage of an anonymous inner class does not make the code unnecessarily complex or harder to read.

---

### **Conclusion**

Anonymous inner classes remain a powerful and versatile feature in Java, providing a mechanism for creating ad-hoc class implementations. While lambda expressions simplify functional programming tasks, anonymous inner classes are indispensable for more complex scenarios where extending classes or implementing multiple methods is required. In modern Java development, understanding when to use each construct ensures cleaner, more maintainable code.

---

## **Lambda Expressions in Java**

**Lambda expressions** are a feature introduced in **Java 8** that allows you to write concise and functional-style code. They are used to implement **functional interfaces** (interfaces with a single abstract method, also called **SAM** interfaces). Lambdas make it easy to pass functionality as an argument to methods or to create inline implementations of interfaces.

---

### **Syntax of Lambda Expressions**

The general syntax of a lambda expression is:
```java
(parameters) -> expression_or_block
```

- **Parameters**: Specify the input(s) for the method being implemented.
- **Arrow Token (`->`)**: Separates the parameter list and the method body.
- **Expression or Block**: Defines the method body.

---

### **Types of Lambda Signatures**

Lambda expressions can have varying parameter and body configurations. Below are common types of lambda signatures:

---

#### **1. No Parameters**
If the abstract method has no parameters, the lambda expression uses empty parentheses `()`.

**Example**:
```java
@FunctionalInterface
interface Greeting {
    void sayHello();
}

public class Main {
    public static void main(String[] args) {
        Greeting greeting = () -> System.out.println("Hello, world!");
        greeting.sayHello();
    }
}
```

---

#### **2. Single Parameter (No Parentheses)**
If there is only one parameter, you can omit parentheses around it.

**Example**:
```java
@FunctionalInterface
interface Printer {
    void print(String message);
}

public class Main {
    public static void main(String[] args) {
        Printer printer = message -> System.out.println(message);
        printer.print("Hello, Lambda!");
    }
}
```

---

#### **3. Multiple Parameters**
For multiple parameters, you must enclose them in parentheses.

**Example**:
```java
@FunctionalInterface
interface Calculator {
    int add(int a, int b);
}

public class Main {
    public static void main(String[] args) {
        Calculator calculator = (a, b) -> a + b;
        System.out.println("Sum: " + calculator.add(5, 3));
    }
}
```

---

#### **4. No Return Value**
When the method has a `void` return type, the lambda body does not return anything explicitly.

**Example**:
```java
@FunctionalInterface
interface Action {
    void perform(int number);
}

public class Main {
    public static void main(String[] args) {
        Action action = number -> System.out.println("Performing action on: " + number);
        action.perform(10);
    }
}
```

---

#### **5. Explicit Return Statement**
When the lambda body has multiple statements or an explicit return, you need to enclose the body in curly braces `{}`.

**Example**:
```java
@FunctionalInterface
interface Multiplier {
    int multiply(int a, int b);
}

public class Main {
    public static void main(String[] args) {
        Multiplier multiplier = (a, b) -> {
            System.out.println("Multiplying " + a + " and " + b);
            return a * b;
        };
        System.out.println("Result: " + multiplier.multiply(4, 5));
    }
}
```

---

#### **6. Without Type Declaration**
Java uses **type inference**, so you don't need to explicitly declare parameter types if they can be inferred from the context.

**Example**:
```java
@FunctionalInterface
interface Concatenator {
    String concatenate(String s1, String s2);
}

public class Main {
    public static void main(String[] args) {
        Concatenator concat = (s1, s2) -> s1 + s2;
        System.out.println(concat.concatenate("Hello, ", "World!"));
    }
}
```

---

#### **7. With Explicit Type Declaration**
You can specify the parameter types explicitly if needed.

**Example**:
```java
@FunctionalInterface
interface Subtractor {
    int subtract(int x, int y);
}

public class Main {
    public static void main(String[] args) {
        Subtractor subtractor = (int x, int y) -> x - y;
        System.out.println("Difference: " + subtractor.subtract(10, 4));
    }
}
```

---

### **Using Lambda Expressions with Built-in Functional Interfaces (Predicate, Consumer, Function, Supplier)**

Java provides several built-in functional interfaces in the `java.util.function` package:

#### **1. Predicate (T -> boolean)**
Represents a condition.
```java
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(4)); // true
    }
}
```

#### **2. Consumer (T -> void)**
Performs an action on an input.
```java
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Consumer<String> printer = message -> System.out.println(message);
        printer.accept("Hello from Consumer!");
    }
}
```

#### **3. Function (T -> R)**
Transforms an input into an output.
```java
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Integer, String> intToString = num -> "Number: " + num;
        System.out.println(intToString.apply(5));
    }
}
```

#### **4. Supplier (() -> T)**
Provides an output without any input.
```java
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<String> messageSupplier = () -> "Hello from Supplier!";
        System.out.println(messageSupplier.get());
    }
}
```

---

### **Benefits of Lambda Expressions**

1. **Conciseness**: Reduces boilerplate code for implementing functional interfaces.
2. **Readability**: Improves the clarity of the code.
3. **Functional Programming**: Supports functional programming paradigms in Java.
4. **Performance**: Lambdas avoid the overhead of creating anonymous inner class objects.

---

### **When to Use Lambda Expressions**

1. **Functional Interfaces**: Lambdas can only be used with interfaces that have a single abstract method.
2. **Short and Simple Logic**: Ideal for concise implementations like predicates, consumers, or simple logic in streams.

---

### **Conclusion**

Lambda expressions are a powerful tool for modern Java programming. They replace verbose anonymous inner classes for functional interfaces, enabling concise and readable code. With support for type inference, multiple parameter configurations, and the ability to work seamlessly with Java’s functional interfaces, lambdas are an essential feature for developers working with Java 8 and later.