package LLD.B_design_patterns.creational.v_singleton;

public class DatabaseConnection {

    private static DatabaseConnection instance;

    private DatabaseConnection() {}

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }
}

/*
- Using a Holder Class instead of Double Locking in Java:
The Holder Class pattern works by utilizing the lazy-loading behavior of static nested classes.
In Java:
    - Static nested classes are not loaded into memory until they are referenced.
This means the Singleton instance is not created until the getInstance() method is first called.
The JVM ensures thread safety when loading classes, so no additional synchronization is required.

public class DatabaseConnection {

    private DatabaseConnection() {}

    private static final class InstanceHolder {
        private static final DatabaseConnection instance = new DatabaseConnection();
    }

    public static DatabaseConnection getInstance() {
        return InstanceHolder.instance;
    }
}
*/
