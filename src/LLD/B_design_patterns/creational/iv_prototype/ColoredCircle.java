package LLD.B_design_patterns.creational.iv_prototype;

public class ColoredCircle extends Circle {

    private final String color;

    public ColoredCircle(int x, int y, int radius, String color) {
        super(x, y, radius);
        this.color = color;
    }

    public ColoredCircle(ColoredCircle coloredCircle) {
        super(coloredCircle);
        this.color = coloredCircle.color;
    }

    public Prototype getClone() {
        return new ColoredCircle(this);
    }

    @Override
    public String toString() {
        return super.toString() + ", color: " + color;
    }
}
