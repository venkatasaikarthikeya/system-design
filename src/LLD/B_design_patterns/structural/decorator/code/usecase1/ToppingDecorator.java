package LLD.B_design_patterns.structural.decorator.code.usecase1;

public abstract class ToppingDecorator implements Pizza {

    protected Pizza pizza;

    public ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public Integer getCost() {
        return pizza.getCost();
    }
}
