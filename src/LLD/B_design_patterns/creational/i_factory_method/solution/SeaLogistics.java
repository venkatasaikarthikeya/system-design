package LLD.B_design_patterns.creational.i_factory_method.solution;

public class SeaLogistics extends Logistics {

    @Override
    public Ship createTransport() {
        return new Ship();
    }
}
