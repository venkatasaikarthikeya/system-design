package LLD.B_design_patterns.creational.i_factory_method.solution;

public class LogisticsApp {

    public static void main(String[] args) {
        Logistics logistics = new SeaLogistics();
        logistics.planDelivery("Long Beach", "Austin", "12/15/2024", "Spectacles");
    }
}
