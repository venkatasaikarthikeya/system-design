package LLD.B_design_patterns.behavioral.observer;

public interface Subscriber {
    void notify(String eventType, String data);
}