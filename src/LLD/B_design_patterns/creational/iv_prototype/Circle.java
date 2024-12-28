package LLD.B_design_patterns.creational.iv_prototype;

public class Circle implements Prototype {

    private final int x;
    private final int y;
    private final int radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle(Circle circle) {
        this.x = circle.x;
        this.y = circle.y;
        this.radius = circle.radius;
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y + ", radius=" + radius;
    }

    @Override
    public Prototype getClone() {
        return new Circle(this);
    }
}
