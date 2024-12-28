package LLD.B_design_patterns.creational.i_factory_method.solution;

public abstract class Logistics {

    public void planDelivery(String source, String destination, String date, String item) {
        Transport transport = createTransport();
        System.out.println("Delivery from " + source + " to " + destination + " with date: " + date + " and item: " + item);
        transport.deliver(item);
    }

    abstract  Transport createTransport();
}
