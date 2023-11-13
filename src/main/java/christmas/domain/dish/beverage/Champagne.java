package christmas.domain.dish.beverage;

import static christmas.domain.constants.Menu.샴페인;

import christmas.domain.dish.Beverage;

public class Champagne extends Beverage {
    protected Champagne() {
        super(샴페인.name(), 샴페인.getPrice());
    }

    public static Champagne create() {
        return new Champagne();
    }
}
