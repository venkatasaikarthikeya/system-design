package LLD.B_design_patterns.creational.i_factory_method.problem;

public class Logistics {

    public void planDelivery(String source, String destination, String date, String item) {
        Truck truck = createTransport();
        System.out.println("Delivery from " + source + " to " + destination + " with date: " + date + " and item: " + item);
        truck.deliver(item);
    }

    public Truck createTransport() {
        return new Truck();
    }
}
