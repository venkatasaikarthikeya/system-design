package LLD.B_design_patterns.structural.adapter.code;

public class USCustomarySystem {

    public USCustomarySystem() { }

    public Double getMile(Integer kilometer) {
        return kilometer * 0.621371;
    }
}
