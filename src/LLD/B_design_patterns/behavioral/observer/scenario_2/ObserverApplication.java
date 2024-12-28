package LLD.B_design_patterns.behavioral.observer.scenario_2;

public class ObserverApplication {

    public static void main(String[] args) {
        // Event Dispatcher
        EventDispatcher eventDispatcher = new EventDispatcher();

        // Publishers
        OrderNotifier orderNotifier = new OrderNotifier(eventDispatcher);
        PaymentNotifier paymentNotifier = new PaymentNotifier(eventDispatcher);
        RewardsNotifier rewardsNotifier = new RewardsNotifier(eventDispatcher);

        // Events
        String[] events = new String[] {
                "ORDER_COMPLETED", "ORDER_FAILED",
                "PAYMENT_COMPLETED", "PAYMENT_FAILED",
                "REWARDS_COMPLETED", "REWARDS_FAILED"
        };

        // Customers
        Customer[] customers = new Customer[] {
                new Customer("Karthik", "keya@gmail.com", "+1 (562) 837-6946"),
                new Customer("Yamini", "mini@gmail.com", "+1 (562) 837-6947"),
                new Customer("Spuritha", "spuritha@gmail.com", "+1 (562) 837-6948")
        };

        // subscriptions
        for (Customer customer : customers) {
            for (String event : events) {
                eventDispatcher.addSubscriber(event, customer);
            }
        }

        // Publisher state changes
        orderNotifier.publish("ORDER_COMPLETED", "keya@gmail.com", "Proceeding to Payment");
        orderNotifier.publish("ORDER_COMPLETED", "spuritha@gmail.com", "Proceeding to Payment");
        orderNotifier.publish("ORDER_FAILED", "mini@gmail.com", "Items out of stock");

        paymentNotifier.publish("PAYMENT_COMPLETED", "keya@gmail.com", "Proceeding to Rewards");
        paymentNotifier.publish("PAYMENT_FAILED", "spuritha@gmail.com", "Insufficient Funds");

        rewardsNotifier.publish("REWARDS_COMPLETED", "keya@gmail.com", "Order Placed successfully, view rewards");
    }
}
