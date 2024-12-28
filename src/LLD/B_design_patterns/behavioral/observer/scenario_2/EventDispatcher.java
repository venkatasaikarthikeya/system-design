package LLD.B_design_patterns.behavioral.observer.scenario_2;

import LLD.B_design_patterns.behavioral.observer.Subscriber;

import java.util.ArrayList;
import java.util.HashMap;

public class EventDispatcher {

    private final HashMap<String, ArrayList<Subscriber>> subscribers;

    public EventDispatcher() {
        subscribers = new HashMap<>();
    }

    public void addSubscriber(String event, Subscriber subscriber) {
        if (subscribers.containsKey(event)) {
            subscribers.get(event).add(subscriber);
        } else {
            ArrayList<Subscriber> subscriberList = new ArrayList<>();
            subscriberList.add(subscriber);
            subscribers.put(event, subscriberList);
        }
    }

    public void removeSubscriber(String event, Subscriber subscriber) {
        if (subscribers.containsKey(event)) {
            subscribers.get(event).remove(subscriber);
        }
    }

    public void notifySubscribers(String event, String email, String data) {
        if (subscribers.containsKey(event)) {
            for (Subscriber subscriber : subscribers.get(event)) {
                Customer customer = (Customer) subscriber;
                if (customer.getEmail().equals(email)) {
                    subscriber.notify(event, data);
                }
            }
        }
    }
}
