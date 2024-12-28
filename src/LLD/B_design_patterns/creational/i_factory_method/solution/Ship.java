package LLD.B_design_patterns.creational.i_factory_method.solution;

public class Ship implements Transport {

    @Override
    public void deliver(String item) {
        System.out.println("Deliver the " + item + " by ship");
    }
}
