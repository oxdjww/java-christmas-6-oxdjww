package christmas.domain.dish.beverage;

import static christmas.domain.constants.Menu.샴페인;

import christmas.domain.dish.Beverage;

public class Chanpagne extends Beverage {
    protected Chanpagne() {
        super(샴페인.name(), 샴페인.getPrice());
    }

    public static Chanpagne create() {
        return new Chanpagne();
    }
}
