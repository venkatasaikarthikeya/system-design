The Singleton design pattern ensures that a class has only one instance and provides a global point of access to that
instance.

There are 4 ways to create a Singleton. They are:
1. Eager
2. Lazy
3. Synchronized
4. Double Locking (Industry Standard)

The evolution of Singleton implementation techniques (Eager, Lazy, Synchronized, Double Locking) is primarily driven
by considerations of **PERFORMANCE, THREAD SAFETY, and SIMPLICITY**. Let’s explore each method, its purpose, and
why the evolution occurred.
---

### 1. **Eager Initialization**
In this approach, the singleton instance is created at the time of class loading.

#### Code Example:
```java
public class EagerSingleton {
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    // Private constructor to prevent instantiation
    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}
```

#### Key Points:
- **Pros**: Simple to implement and thread-safe because the instance is created when the class is loaded.
- **Cons**: The instance is created even if it’s not used, which might waste resources in scenarios where creating the singleton is expensive, and it’s used rarely or never.

#### Why move away?
Resource-heavy initialization might be unnecessary if the singleton is never used. This led to the **Lazy Initialization** method.

---

### 2. **Lazy Initialization**
The singleton instance is created only when it’s needed, i.e., the first time `getInstance` is called.

#### Code Example:
```java
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
```

#### Key Points:
- **Pros**: Avoids unnecessary creation of the instance. Saves resources if the instance is never used.
- **Cons**: Not thread-safe. If two threads call `getInstance` simultaneously, they might create two separate instances.

#### Why move away?
Concurrency issues in multi-threaded environments inspired the **Synchronized Singleton**.

---

### 3. **Synchronized Initialization**
The `getInstance` method is synchronized to ensure thread safety. Only one thread can access the method at a time.

#### Code Example:
```java
public class SynchronizedSingleton {
    private static SynchronizedSingleton instance;

    private SynchronizedSingleton() {}

    public static synchronized SynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new SynchronizedSingleton();
        }
        return instance;
    }
}
```

#### Key Points:
- **Pros**: Thread-safe. Guarantees that only one instance is created, even in multi-threaded environments.
- **Cons**: Synchronization introduces a performance overhead, especially when `getInstance` is called frequently.

#### Why move away?
The synchronization overhead is unnecessary after the instance is created. This inspired the **Double-Checked Locking** method.

---

### 4. **Double-Checked Locking**
This approach minimizes synchronization overhead by checking the instance twice:
1. Outside the synchronized block for performance.
2. Inside the synchronized block for thread safety.

#### Code Example:
```java
public class DoubleCheckedLockingSingleton {
    private static volatile DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {}

    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) { // First check (no locking)
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) { // Second check (with locking)
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }
}
```

#### Key Points:
- **Pros**: Thread-safe and avoids the performance overhead of synchronized methods after the instance is initialized.
- **Cons**: Slightly more complex implementation.

#### Why move to this?
- Provides the benefits of both lazy initialization and thread safety without the performance penalty of full synchronization.

---

### Summary of Evolution
1. **Eager Initialization**:
    - Works in single-threaded and multi-threaded environments.
    - Always creates the instance, even if unused (wastes resources).

2. **Lazy Initialization**:
    - Defers instance creation until needed (efficient).
    - Not thread-safe.

3. **Synchronized Initialization**:
    - Solves thread safety but introduces performance overhead due to synchronization.

4. **Double-Checked Locking**:
    - Combines the benefits of lazy initialization and thread safety while optimizing performance by reducing unnecessary synchronization.

---

### Why is Synchronized not enough?
- **Performance Concern**: Synchronization is expensive in scenarios where `getInstance` is called frequently after the singleton instance is initialized.
- **Optimization**: Double-Checked Locking avoids synchronization overhead after the instance is created by synchronizing only during the first access.

---

### Modern Singleton Alternative: Enum Singleton
A simpler and thread-safe way to implement Singleton in Java is using an `enum`, which is inherently thread-safe.

#### Code Example:
```java
public enum EnumSingleton {
    INSTANCE;

    public void someMethod() {
        // Add logic here
    }
}
```

#### Key Points:
- **Pros**: Thread-safe, prevents reflection-based attacks, and easy to implement.
- **Cons**: Cannot perform lazy initialization.

--- 

By understanding these approaches, you can decide which implementation suits your use case best based on resource management and performance requirements.