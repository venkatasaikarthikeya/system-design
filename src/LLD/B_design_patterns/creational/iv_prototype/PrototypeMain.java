package LLD.B_design_patterns.creational.iv_prototype;

public class PrototypeMain {

    public static void main(String[] args) throws CloneNotSupportedException {
        // Prototype Pattern
        Circle circle = new Circle(2, 3, 4);
        Circle clonedCircle = (Circle) circle.getClone();
        System.out.println("circle: " + circle);
        System.out.println("cloned circle: " + clonedCircle);

        // Prototype Pattern with inheritance
        ColoredCircle coloredCircle = new ColoredCircle(1, 2, 5, "White");
        ColoredCircle clonedColoredCircle = (ColoredCircle) coloredCircle.getClone();
        System.out.println("colored circle: " + coloredCircle);
        System.out.println("cloned circle: " + clonedColoredCircle);

        // Prototype Pattern supported by java.lang.Cloneable interface
        Rectangle rectangle = new Rectangle(4,5);
        System.out.println("Rectangle: " + rectangle);
        Rectangle clonedRectangle = (Rectangle) rectangle.clone();
        System.out.println("cloned rectangle: " + clonedRectangle);
    }
}
