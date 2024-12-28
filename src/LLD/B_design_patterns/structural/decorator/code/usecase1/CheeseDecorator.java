package LLD.B_design_patterns.structural.decorator.code.usecase1;

public class CheeseDecorator extends ToppingDecorator {

    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public Integer getCost() {
        return this.pizza.getCost() + 10;
    }
}
