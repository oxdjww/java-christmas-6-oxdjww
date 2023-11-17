package christmas.domain.dish.beverage;

import static christmas.domain.constants.Menu.제로콜라;

import christmas.domain.dish.Beverage;

public class Zerocoke extends Beverage {
    protected Zerocoke() {
        super(제로콜라.name(), 제로콜라.getPrice());
    }

    public static Zerocoke create() {
        return new Zerocoke();
    }
}
