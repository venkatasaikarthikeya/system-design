package LLD.B_design_patterns.structural.adapter.code;

public class AdapterMain {

    public static void main(String[] args) {
        // Adaptee (typically a third party library)
        USCustomarySystem usCustomarySystem = new USCustomarySystem();

        // Adapter (which we write, and it wraps the adaptee, so that client doesn't even know about it and it only interacts with adapter)
        UnitConvertible unitConvertible = new UnitConversionAdapter(usCustomarySystem);

        // Client (It is a class whose interface is incompatible with Third party library)
        FormulaeComputer formulaeComputer = new FormulaeComputer(unitConvertible);

        // Using client in our application
        System.out.println(formulaeComputer.speed(80, 1));
    }
}
