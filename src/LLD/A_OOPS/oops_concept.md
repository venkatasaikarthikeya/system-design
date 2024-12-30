### Object-Oriented Programming (OOP):

    - Object-Oriented Programming is a programming paradigm that states that "It is the process of simulating real
      world objects into Program code".

### Class, Object, Inheritance:
```text

Object (Xerox) : Instance of some class
Class  (Original) : Specification of object. It tells us how our object looks like
Example:
    Circle c = new Circle();
    In the above statement:
        new Circle() is known as an Object
        c is known as reference variable as it holds reference(or address) of circle object.


Class has:
constructor, getters, setters (trivial items and they can be generated in most IDEs)
attributes (OR) fields (OR) properties (OR) data members
behaviors (OR) methods (OR) member functions
These are collectively called as "Members of Class"


Apart from the constructor, getters, and setters, other members of the class can be of two types:

1. Non-Static members => (Non-Static properties and Non-Static methods)
   Non-Static members means they belong to an object. They are always associated with an object. They can't exist without object.
   They are accessed by creating an object of that class.
   ClassName object = new ClassName();
   object.nonStaticProperty and object.nonStaticMethod()
     
2. Static members => (Static properties and Static methods)
   Static members means they belong to a class and not to an object. They are always associated with the class not with object. 
   They exist indepdendently and they exist even without a single object of a class.
   They are accessed directly with className.staticProperty or className.staticMethod()
   
 
Access Specifiers:
public:
    - Members declared as public can be accessed by anyone.
    - Static members => 
    - ClassName.property & ClassName.method()
    - NonStatic members => 
    - ClassName object = new ClassName()
    - object.property & object.method()

private:
    - Members declared as private can not be accessed by anyone.
    - Static members => private properties and private methods can't be accessed with ClassName
    - NonStatic members => private properties and private methods can't be accessed with object as well
    
protected:
    - Members declared as protected can be accessed by this class and all of the classes below its class hierarchy
    - Static members => protected properties and protected methods can be accessed with ClassName
    - ClassName.property & ClassName.method()
    - NonStatic members => protected properties and protected methods can be accessed with object as well.
    - ClassName object = new ClassName()
    - object.property & object.method()


Inheritance:
    Inheritance is the ability to build new classes on top of existing ones. Main benefit of Inheritance is code reuse.
    - Inheritance lets sub classes inherit the properties and methods of the classes above them in the class hierarchy and provide them
      an option to add their own properties and methods as well, apart from what they receive from their parent classes. 
    (Children would build upon what has been given to them by their parents)
    
                                            Animal
                                            /    \
                                         Cat     Dog
                                         
    - Cat and Dog sub classes inherits the attributes and behaviors of Animal super class.
    - Cat and Dog sub classes can have their own attributes and behaviors in addition to what they get from Animal class.
    - Cat and Dog sub classes can also extend and/or override the animal class's behaviors. 
    - Cat and Dog sub classes also inherits static members of Animal class and can access them with Cat.staticProperty & Cat.staticMethod()
    
class Animal { 
    public Animal() { }
}
class Cat extends Animal {
    public Cat() {
        super();
    }
}

    - The constructor of a sub class should always call the super class constructor using super(arguments)

class Animal {
    public Animal() { }
    
    public void makeSound() {
        System.out.println("Animal is making sound.....");
    }
}

Now, we all know that Cat makes meow sound. Now how do I let the cat class make this sound?
    - Just override the makeSound() in Cat class like below.
    
class Cat extends Animal {
    public Cat() {
        super();
    }
    
    @Override
    public void makeSound() {
        System.out.println("meow.....meowwwww");
    }
}

This is how we override the makeSound() method of Cat class.

Now, we want our Dog class to sound like an animal and then bark. Now how do I let the dag class make both the sounds?
    - Just override the makeSound() in Dog class and call super class's method as well.

class Dog extends Animal {
    public Dog() {
        super();
    }
    
    @Override
    public void makeSound() {
        super.makeSound();
        System.out.println("bow.....bowwwwww");
    }
}

This lets the Dog to first sound like an animal, and then bark.

* Should we explicitly specify @Override to tell compiler that we are overriding something?
    No, it is not mandatory to use the @Override annotation when overriding a method in Java. However, using @Override is 
highly recommended for several reasons:
1. Compile-Time Checking:
    - The @Override annotation ensures that the method is indeed overriding a method in the parent class or interface.
    - If the method signature in the child class does not match the parent class (due to typos or incorrect parameters), the 
      compiler will throw an error.
2. Improves Code Readability:
    - It explicitly indicates to readers of the code that the method is intended to override a parent class or interface method.
3. Prevents Errors:
    - Without @Override, if a method in the parent class is renamed or removed, the child class may no longer override it, and 
      no error will be raised. Using @Override ensures that such discrepancies are caught during compilation.
      
Consequences of using inheritance:
    - subclasses have the same interface(public methods of a class in this context) as their parent class
    - You can't hide a method in a subclass if it was declared public in the superclass
    - You must also implement all abstract methods, even if they don't make sense for your subclass
```

### Abstraction:
    - An object can have many attributes and behaviors
    - But, only few of them will be required in the context of an application
    - Abstraction gives the developer the freedom to choose the required attributes and required behaviors that fit in
      the context of an application

```text
For example, a real world Student object can have all the following attributes and behaviors:

Real World Student object:
attrs:
id, name, age, gender, address, parentMobileNo, hasGirlFriend, favoriteVideoGame, favoriteFood, gfMobileNo, etc..,
behaviors:
academicPerformance, sportsPerformance, discipline, happyBehavior, psychoticBehavior, etc..,

A real world student object would have all the above attributes and behaviors. Assume you are building a School Management Software.
When you design entities for this School Management Software, one of the most important entity is Student. So, you would like to
create a Student class with attributes and behaviors which are relavant to the Software.

Student class:
attrs:
id, name, age, gender, address, parentMobileNo
behaviors:
academicPerformance, sportsPerformance, discipline

If you observer, we have considered only a subset of attributes and behaviors of student that are relavant to the software. 

Why does someone want to know if he has a gf or not? what his favorite video game is?
    No one really cares. We are only concerned with the attributes and behaviors of the student that are relavant in the context of
the software. 

    This freedom of choosing the subset of attributes and behaviors of a real world object that are relavant to the context is
known as Abstraction
```

### Encapsulation:
    - Encapsulation is the ability of an object to hide parts of its state and behavior from other objects, exposing only a 
      limited interface(interface in this context means, public methods of a class) to the rest of the program.
    - Simple Analogy: If an AC suddenly doesn't work, you will just try to play with the remote. Hit the remote on the back and try
      again, or change the batteries of the remote. You would never be able to touch the condensor, motor of AC even if something is
      wrong. Because, the company doesn't want to let the customers directly mess with the equipment. To protect the equipment, they
      would just provide a small interface to the user to operate the complex AC system and hence remote is the interface here.

```text
class Car {
    private FuelTank fuelTank;
    private Cylinder cylinder;
    private Piston piston;
    private Ignition ignition;
    
    public Car(FuelTank fuelTank, Cylinder cylinder, Piston piston, Ignition ignition) {
        this.fuelTank = fuelTank;
        this.cylinder = cylinder;
        this.piston = piston;
        this.ignition = ignition;
    }
    
    private void movePiston() {
        System.out.println("Move piston and initiate motion.....");
    }
    
    private void startCylinder() {
        getFuelFromFuelTank();
        movePiston();
    }
    
    private void getFuelFromFuelTank() {
        System.out.println("Send some fuel to Cyliner");
    }
    
    private void startIgnition() {
        startCylinder();
    }
    
    public void startCar() {
        startIgnition();    
    }
}

If you see this Car class, it has lot of attributes and behaviors which are not even understandable to a person who drives a car.
    All the person need to know is startCar(). Encapsulation helps us to provide an interface to that can be used to operate a 
complex system. This is done by encapsulating the attributes and behaviors within the boundary of a class and assigning appropriate
access levels to these attributes and behaviors which would hide them from the person who operates it.

    In the above, a person does not need to ignite engine, send fuel to cylinder and initiate piston movment. Instead, we just
provide an interface to the user (startCar() method in this case) that he can use to operate the car without having to deal with
the complexity of the system.

This is known as Encapsulation.

To encapsulate something means to make it private, and thus accessible only from within of the methods of its own class, There's
a little bit less restrictive mode called protected that makes a member of a class available to sub classes as well. 
```

### Polymorphism:
    - Polymorphism means ability to take multiple forms
    - Polymorphism states that, "THE SAME COMMAND WHEN APPLIED ON DIFFERENT OBJECTS GIVES YOU DIFFERENT RESULTS"
    - Example: A very simple example would be, you are given a command to wash the vegetables. You would wash each vegetable in a 
               way that is suitable for that vegetable. You would wash the potatoes very hardly to remove dirt, whereas you would
               go easy on tomatoes. If you wash the tomatoes, the same way like potatoes, then the tomato pulp may come out due
               to the force. So, the same command when applied on different objects, would give you different results.

Polymorphism in Java allows objects to take on many forms, enabling code reuse and flexibility. There are two main types of polymorphism in Java:

---

### 1. **Compile-Time Polymorphism (Static Polymorphism)**
- **Definition**: The method to be called is determined at compile time.
- **Achieved Through**: **Method Overloading**.
- **Key Features**:
    - Methods in the same class share the same name but differ in parameters (number, type, or order).
    - No runtime overhead because the method resolution happens at compile time.

#### Example:
```java
class Calculator {
    // Overloaded methods
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(5, 10));          // Calls add(int, int)
        System.out.println(calc.add(5.5, 10.5));      // Calls add(double, double)
        System.out.println(calc.add(5, 10, 15));      // Calls add(int, int, int)
    }
}
```

**Output**:
```
15
16.0
30
```

---

### 2. **Runtime Polymorphism (Dynamic Polymorphism)**
- **Definition**: The method to be called is determined at runtime.
- **Achieved Through**: **Method Overriding** and **Upcasting**.
- **Key Features**:
    - A subclass provides a specific implementation of a method already defined in its parent class.
    - The method to execute is decided based on the object's actual type, not the reference type.

#### Example:
```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myAnimal;  // Parent class reference

        myAnimal = new Dog(); // Dog object
        myAnimal.sound();     // Calls Dog's sound()

        myAnimal = new Cat(); // Cat object
        myAnimal.sound();     // Calls Cat's sound()
    }
}
```

**Output**:
```
Dog barks
Cat meows
```

---

### **Key Differences Between Compile-Time and Runtime Polymorphism**

| Aspect               | Compile-Time Polymorphism                 | Runtime Polymorphism              |
|----------------------|-------------------------------------------|-----------------------------------|
| **Achieved Through** | Method Overloading                        | Method Overriding                 |
| **Binding Type**     | Static Binding (Compile-Time Binding)     | Dynamic Binding (Runtime Binding) |
| **Decided At**       | Compile Time                              | Runtime                           |
| **Execution Speed**  | Faster (less overhead)                    | Slower (method lookup at runtime) |
| **Example**          | `add(int, int)` vs. `add(double, double)` | Subclass overriding `sound()`     |

---

### **Other Related Concepts in Polymorphism**

1. **Type Casting (Upcasting and Down casting)**:
    - **Upcasting**: Assigning a subclass object to a superclass reference.
    - **Down casting**: Casting a superclass reference back to a subclass type.

2. **Polymorphism and Interfaces**:
    - Interfaces allow a class to define methods that can have multiple implementations in different classes.

3. **Polymorphism and Abstract Classes**:
    - Abstract classes can also be used for runtime polymorphism when subclasses provide specific implementations of abstract methods.

---

### **Conclusion**
Polymorphism is a cornerstone of object-oriented programming in Java. **Compile-time polymorphism** ensures multiple method signatures for the same functionality, while **runtime polymorphism** enables flexibility and extensibility by allowing behavior to be determined dynamically at runtime.

---

### Key Concept:
**A base class pointer can hold the reference to objects of its descendent classes**
```text
                                   implements
                            A  ------------------> B
                           / \
                         /     \
                        C       D
                        |
                        E

      Assume this is the class hierarchy. Now, all the below are possible
      Trivial Case -> A ref1 = new A();   C ref2 = new C();   D ref3 = new D();   E ref4 = new E(); 
      A ref1 = new C();   A ref2 = new D();  A ref3 = new E();
      B ref1 = new A();   B ref2 = new C();  B ref3 = new D();  B ref4 = new E();
```

---

### **Generalization in Object-Oriented Programming (OOP)**

**Generalization** is the process of extracting shared characteristics (attributes and behaviors) from two or more classes and combining them into a generalized superclass. It allows for code reuse and simplifies maintenance by defining common functionality in a single location, which can be inherited by multiple subclasses.

#### Example:
- Classes `Car`, `Bike`, and `Truck` all have common properties like `speed` and `fuel` and methods like `start()` and `stop()`.
- Generalization would create a superclass, e.g., `Vehicle`, to encapsulate these common features. The specific details (e.g., `numberOfWheels`) remain in the subclasses.

---

### **How Generalization Is Solved Using Abstract Classes**

Abstract classes are a key mechanism for implementing generalization in OOP:
1. **Abstract classes serve as templates**:
   - They define common behaviors or properties that subclasses share.
   - Specific implementations can vary in subclasses.

2. **Partial Implementation**:
   - Abstract classes allow partial implementation through non-abstract methods, while abstract methods enforce subclasses to implement the rest.

3. **Polymorphism Support**:
   - Abstract classes can be used to create polymorphic behavior, where a common interface (`abstract` methods) is provided, but the implementation varies in each subclass.

#### Example:
```java
abstract class Vehicle {
    String fuelType;

    Vehicle(String fuelType) {
        this.fuelType = fuelType;
    }

    void start() {
        System.out.println("Vehicle is starting");
    }

    abstract void move(); // Abstract method
}

class Car extends Vehicle {
    Car(String fuelType) {
        super(fuelType);
    }

    @Override
    void move() {
        System.out.println("Car is moving on four wheels.");
    }
}

class Bike extends Vehicle {
    Bike(String fuelType) {
        super(fuelType);
    }

    @Override
    void move() {
        System.out.println("Bike is moving on two wheels.");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car("Petrol");
        Vehicle bike = new Bike("Diesel");

        car.start(); // Generalized behavior
        car.move();  // Specific behavior of Car
        bike.move(); // Specific behavior of Bike
    }
}
```

---

## **Abstract Classes in Java**

An **abstract class** in Java is a class declared with the `abstract` keyword. It provides a base class for other classes to extend, offering a combination of:
- Abstract methods (methods without implementation)
- Non-abstract methods (methods with implementation)

#### Key Characteristics:
1. **Cannot Be Instantiated**:
   - You cannot create objects of an abstract class.
   - Abstract classes are meant to be extended by subclasses.

2. **Can Have Both Abstract and Non-Abstract Methods**:
   - Abstract methods are placeholders for behavior to be implemented by subclasses.
   - Non-abstract methods can provide shared behavior to all subclasses.

3. **Supports Inheritance**:
   - **A class extending the abstract class must implement all abstract methods unless it is also declared abstract**

4. **Constructors**:
   - Abstract classes can have constructors, which are called when a subclass object is created.

---

### **Abstract Methods**

An abstract method is a method declared without a body, and it must be implemented by subclasses. Declaring an abstract method makes the class abstract.

#### Syntax:
```java
abstract class Shape {
    abstract void draw(); // Abstract method
}
```

---

### **Access Levels for Abstract Methods and Classes**

1. **Access Levels for Abstract Methods**:
   - Abstract methods can be `public`, `protected`, or default (package-private).
   - Abstract methods **cannot be `private`**, as they must be visible to subclasses for implementation.

   ```java
   abstract class Parent {
       protected abstract void doSomething(); // Visible to subclasses
       public abstract void doAnotherThing(); // Visible everywhere
   }
   ```

2. **Access Levels for Abstract Classes**:
   - Abstract classes can have any access modifier (`public`, `protected`, package-private).
   - Abstract classes **cannot be `private`** because they are intended to be extended.

---

### **Rules for Abstract Classes and Methods**

1. **At Least One Abstract Method**:
   - An abstract class typically contains at least one abstract method. However, it can contain none, in which case it just acts as a base class to prevent instantiation.

2. **Subclass Responsibility**:
   - Subclasses of an abstract class must implement all its abstract methods unless they are also declared abstract.

3. **Abstract Class Cannot Be Final**:
   - A class cannot be both `abstract` and `final`, as `final` prevents inheritance, which contradicts the purpose of abstract classes.

4. **Cannot Have Abstract Static Methods**:
   - Static methods belong to the class, not to objects, so they cannot be abstract.

---

### **Advantages of Abstract Classes**
1. **Code Reusability**:
   - Common functionality can be implemented once and reused in all subclasses.

2. **Encapsulation of Shared Behavior**:
   - Abstract classes define shared behavior while allowing specialized behavior in subclasses.

3. **Polymorphism**:
   - Abstract classes enable polymorphism, where a single reference type can represent multiple concrete implementations.

---

### **Abstract Class**

| Feature              | Abstract Class                                   | 
|----------------------|--------------------------------------------------|
| **Methods**          | Can have both abstract and non-abstract methods. |
| **Fields**           | Can have instance variables.                     |
| **Inheritance**      | A class can extend only one abstract class.      |
| **Access Modifiers** | Methods can have any access modifier.            |
| **Constructors**     | Can have constructors.                           |

---

### **Conclusion**

Generalization is a fundamental concept in OOP, allowing shared characteristics and behaviors to be centralized in a base class. Abstract classes provide a mechanism for implementing generalization by defining common behaviors while leaving specific behaviors to subclasses. Abstract methods enforce rules for subclasses, while non-abstract methods facilitate code reuse. By understanding the rules and best practices of abstract classes and methods, developers can create flexible, maintainable, and scalable software designs.
                            
---

## **Interface in Java**

An **interface** in Java is a reference type, similar to a class, that is a collection of abstract methods. It defines a contract that implementing classes must follow. An interface acts as a blueprint for classes by specifying the methods they must implement, but it does not contain any implementation of those methods.

---

### **Methods in an Interface**

1. **Abstract Methods (Prior to Java 8)**:
   - All methods in an interface were `abstract` by default and had no implementation.

   ```java
   interface Animal {
       void eat();  // Abstract method
       void sleep(); // Abstract method
   }
   ```

2. **Default Methods (Introduced in Java 8)**:
   - Interfaces can now have methods with default implementations.
   - They are created with an intent to hold common behavior of classes implementing an interface.
   - Declared using the `default` keyword.

   ```java
   interface Animal {
       default void sleep() {
           System.out.println("Animal is sleeping.");
       }
   }
   ```

3. **Static Methods (Introduced in Java 8)**:
   - Interfaces can have `static` methods, which belong to the interface and not the implementing class.
   - Called using the interface name.

   ```java
   interface Animal {
       static void run() {
           System.out.println("Animals can run.");
       }
   }
   ```

4. **Private Methods (Introduced in Java 9)**:
   - Used for code reuse inside default or static methods of the interface.
   - Not accessible to implementing classes or outside the interface.

   ```java
   interface Animal {
       private void helper() {
           System.out.println("Private helper method.");
       }

       default void perform() {
           helper();
           System.out.println("Performing a task.");
       }
   }
   ```

---

### **Access Levels Allowed on Interfaces and Methods**

1. **Access Levels for Interfaces**:
   - **Interfaces can be `public` or package-private (default)**.
   - If an interface is `public`, it must be declared in a file with the same name as the interface.

2. **Access Levels for Interface Methods**:
   - **Abstract Methods**: Always `public` by default.
   - **Default Methods**: Must be explicitly `public`.
   - **Static Methods**: Must be explicitly `public` or `private`.
   - **Private Methods**: Must be explicitly `private`.

---

### **Changes in Interface from Earlier Versions of Java**

1. **Java 7 and Earlier**:
   - Interfaces could only contain abstract methods and constant fields (static and final by default).

2. **Java 8**:
   - Introduced `default` and `static` methods.
   - Allowed interfaces to provide reusable functionality and backward compatibility.

3. **Java 9**:
   - Introduced `private` methods in interfaces for internal logic reuse.

---

### **Primary Purpose of Interfaces in Industry**

1. **Defining a Contract**:
   - Interfaces establish a contract that implementing classes must adhere to, ensuring a consistent behavior.

2. **Multiple Inheritance**:
   - Java supports multiple inheritance of behavior through interfaces, overcoming the diamond problem faced with multiple class inheritance.

3. **Polymorphism**:
   - Interfaces provide a way to achieve polymorphism, allowing a single interface type to represent multiple implementations.

4. **Decoupling**:
   - Interfaces promote loose coupling between components, making code more modular, maintainable, and testable.

5. **Standardization**:
   - Widely used for creating frameworks, APIs, and libraries to define common standards.

6. **Dependency Injection**:
   - Interfaces are heavily used in dependency injection frameworks to provide abstractions.

---

### **Resolving Multiple Interfaces**

Java allows a class to implement multiple interfaces, but conflicts can arise if two or more interfaces have methods with the same signature. The class must resolve the conflict explicitly.

#### Example: Resolving Method Conflicts
```java
interface InterfaceA {
    default void show() {
        System.out.println("InterfaceA's show method");
    }
}

interface InterfaceB {
    default void show() {
        System.out.println("InterfaceB's show method");
    }
}

class MyClass implements InterfaceA, InterfaceB {
    @Override
    public void show() {
        // Resolve conflict explicitly
        InterfaceA.super.show();
        InterfaceB.super.show();
        System.out.println("MyClass's implementation of show");
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.show();
    }
}
```

**Output**:
```
InterfaceA's show method
InterfaceB's show method
MyClass's implementation of show
```

---

### **Key Differences Between Abstract Classes and Interfaces**

| Feature                  | Abstract Class                               | Interface                                                |
|--------------------------|----------------------------------------------|----------------------------------------------------------|
| **Methods**              | Can have both abstract and concrete methods. | Can have abstract, default, static, and private methods. |
| **Fields**               | Can have instance variables.                 | Can have only constants (static and final).              |
| **Multiple Inheritance** | A class can extend only one abstract class.  | A class can implement multiple interfaces.               |
| **Constructors**         | Can have constructors.                       | Cannot have constructors.                                |
| **Inheritance Purpose**  | Used for shared state and behavior.          | Used to define a contract for behavior.                  |

---

### **Conclusion**

An interface in Java is a powerful tool for abstraction, polymorphism, and achieving multiple inheritance of behavior. With the addition of `default`, `static`, and `private` methods in Java 8 and 9, interfaces have become even more flexible and capable. Their primary role in the industry is to define consistent contracts, promote decoupling, and enable polymorphic behavior, making them indispensable for building scalable and maintainable applications.

---

## **The Diamond Problem in Java**

The **diamond problem** refers to an ambiguity that arises in languages that allow multiple inheritance of classes. It occurs when a class inherits from two classes (or interfaces) that both have a method with the same signature, leading to uncertainty about which method to use.

---

### **Diamond Problem Example**

Consider the following situation:
1. Class `A` defines a method `display()`.
2. Classes `B` and `C` both extend `A` and override the `display()` method.
3. Class `D` inherits from both `B` and `C`.

If `D` calls `display()`, it is unclear whether the method from `B` or `C` should be executed.

#### Illustration:
```
        A
       / \
      B   C
       \ /
        D
```

---

### **Diamond Problem in Java**

Java **does not allow multiple inheritance of classes** to prevent the diamond problem. This is a design decision to avoid ambiguity and maintain simplicity in the inheritance structure.

#### Code Example of Restricted Multiple Inheritance:
```java
class A {
    void display() {
        System.out.println("Display from A");
    }
}

class B extends A {
    @Override
    void display() {
        System.out.println("Display from B");
    }
}

class C extends A {
    @Override
    void display() {
        System.out.println("Display from C");
    }
}

// This will result in a compilation error:
// class D extends B, C { }
```

---

### **Multiple Inheritance with Interfaces**

Java supports **multiple inheritance** through **interfaces**, but it resolves the diamond problem by requiring explicit resolution when a conflict arises.

#### Example of Diamond Problem with Interfaces:
```java
interface InterfaceA {
    default void display() {
        System.out.println("Display from InterfaceA");
    }
}

interface InterfaceB {
    default void display() {
        System.out.println("Display from InterfaceB");
    }
}

class D implements InterfaceA, InterfaceB {
    @Override
    public void display() {
        // Explicit resolution
        InterfaceA.super.display();
        InterfaceB.super.display();
        System.out.println("Display from Class D");
    }
}

public class Main {
    public static void main(String[] args) {
        D obj = new D();
        obj.display();
    }
}
```

**Output**:
```
Display from InterfaceA
Display from InterfaceB
Display from Class D
```

---

### **How Java Solves the Diamond Problem**

1. **No Multiple Inheritance for Classes**:
   - Java disallows a class from inheriting from more than one class, eliminating ambiguity at the source.

2. **Explicit Resolution for Interfaces**:
   - When multiple interfaces have conflicting default methods, the implementing class must override and resolve the ambiguity explicitly using `InterfaceName.super.methodName()`.

---

### **Benefits of Java's Approach**

1. **Simplicity**:
   - The inheritance hierarchy remains simple and predictable.

2. **Avoids Ambiguity**:
   - Java enforces clear rules for resolving conflicts, preventing runtime errors.

3. **Flexibility via Interfaces**:
   - While multiple inheritance of classes is restricted, multiple inheritance of behavior through interfaces is supported.

---

### **Summary**

The **diamond problem** occurs when a class inherits conflicting methods from multiple sources, leading to ambiguity. Java avoids this issue by:
1. Disallowing multiple inheritance of classes.
2. Supporting multiple inheritance of interfaces but requiring explicit resolution of method conflicts when they arise.

This approach ensures both simplicity and flexibility, making Java a robust language for object-oriented programming.