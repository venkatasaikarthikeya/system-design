package LLD.B_design_patterns.behavioral.observer.scenario_2;

import LLD.B_design_patterns.behavioral.observer.Publisher;

public class OrderNotifier implements Publisher {

    private final EventDispatcher eventDispatcher;

    public OrderNotifier(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public void publish(String event, String customerEmail, String data) {
        eventDispatcher.notifySubscribers(event, customerEmail, data);
    }
}
