package LLD.B_design_patterns.creational.i_factory_method.solution;

public class Truck implements Transport {

    @Override
    public void deliver(String item) {
        System.out.println("Deliver the " + item + " by truck");
    }
}
