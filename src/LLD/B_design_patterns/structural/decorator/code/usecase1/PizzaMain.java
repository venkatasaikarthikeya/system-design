package LLD.B_design_patterns.structural.decorator.code.usecase1;

public class PizzaMain {

    public static void main(String[] args) {

        // Base
        Pizza margheritaPizza = new MargheritaPizza();

        // Toppings added to Base
        Pizza cheesePizza = new CheeseDecorator(margheritaPizza);

        // Now cheese pizza becomes new base and we are going to add toppings to it
        Pizza veggiePizza = new OnionTomatoDecorator(cheesePizza);

        System.out.println(veggiePizza.getCost());
    }
}
