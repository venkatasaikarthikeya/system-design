package LLD.B_design_patterns.structural.decorator.code.usecase3;

public abstract class DataDecorator implements Writable {

    protected Writable writable;

    public DataDecorator(Writable writable) {
        this.writable = writable;
    }
}
