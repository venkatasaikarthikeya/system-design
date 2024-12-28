package LLD.B_design_patterns.structural.adapter.code;

public class UnitConversionAdapter implements UnitConvertible {

    private final USCustomarySystem usCustomarySystem;

    public UnitConversionAdapter(USCustomarySystem usCustomarySystem) {
        this.usCustomarySystem = usCustomarySystem;
    }

    @Override
    public Double getMileFromKilometer(Integer kilometer) {
        return usCustomarySystem.getMile(kilometer);
    }
}
