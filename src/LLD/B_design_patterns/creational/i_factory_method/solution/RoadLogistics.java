package LLD.B_design_patterns.creational.i_factory_method.solution;

public class RoadLogistics extends Logistics {

    @Override
    public Truck createTransport() {
        return new Truck();
    }
}
