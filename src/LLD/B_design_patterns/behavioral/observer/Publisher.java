package LLD.B_design_patterns.behavioral.observer;

public interface Publisher {
    void publish(String event, String customerEmail, String data);
}
