package LLD.B_design_patterns.structural.adapter.code;

public class FormulaeComputer {

    private final UnitConvertible unitConvertible;

    public FormulaeComputer(UnitConvertible unitConvertible) {
        this.unitConvertible = unitConvertible;
    }

    public Double speed(Integer distance, Integer time) {
        return unitConvertible.getMileFromKilometer(distance) / time;
    }
}
