package LLD.B_design_patterns.structural.decorator.code.usecase1;

public class OnionTomatoDecorator extends ToppingDecorator {

    public OnionTomatoDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public Integer getCost() {
        return this.pizza.getCost() + 25;
    }
}
