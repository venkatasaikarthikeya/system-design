package LLD.B_design_patterns.behavioral.observer.scenario_1;

public class ObserverApplication {

    public static void main(String[] args) {

        // Publisher
        AppleStore appleStore = new AppleStore();

        // Publisher Events
        String EVENT_WATCH_SERIES_10 = "EVENT_WATCH_SERIES_10";
        String EVENT_PHONE_17 = "EVENT_PHONE_17";
        String EVENT_VISION_PRO = "EVENT_VISION_PRO";

        // Customers
        Customer c1 = new Customer("Karthik", "keya@gmail.com", "+1 (562) 837-6946");
        Customer c2 = new Customer("Yamini", "mini@gmail.com", "+1 (562) 837-6947");
        Customer c3 = new Customer("Spuritha", "spuritha@gmail.com", "+1 (562) 837-6948");
        Customer c4 = new Customer("Geetha", "gee@gmail.com", "+1 (562) 837-6949");
        Customer c5 = new Customer("Akanksha", "aku@gmail.com", "+1 (562) 837-6950");

        // Subscribers
        appleStore.addSubscriber(EVENT_WATCH_SERIES_10, c1);
        appleStore.addSubscriber(EVENT_PHONE_17, c1);
        appleStore.addSubscriber(EVENT_WATCH_SERIES_10, c2);
        appleStore.addSubscriber(EVENT_PHONE_17, c3);
        appleStore.addSubscriber(EVENT_VISION_PRO, c3);
        appleStore.addSubscriber(EVENT_PHONE_17, c4);
        appleStore.addSubscriber(EVENT_VISION_PRO, c4);
        appleStore.addSubscriber(EVENT_PHONE_17, c5);
        appleStore.addSubscriber(EVENT_WATCH_SERIES_10, c5);
        appleStore.addSubscriber(EVENT_VISION_PRO, c5);

        // Publisher state changes
        appleStore.notifySubscribers(EVENT_WATCH_SERIES_10, "iWatch Series 10 is available now");
        appleStore.notifySubscribers(EVENT_PHONE_17, "iPhone 17 is available now");
        appleStore.notifySubscribers(EVENT_VISION_PRO, "Vision Pro is available now");
    }
}
