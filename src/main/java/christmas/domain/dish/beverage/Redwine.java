package christmas.domain.dish.beverage;

import static christmas.domain.constants.Menu.레드와인;

import christmas.domain.dish.Beverage;

public class Redwine extends Beverage {
    protected Redwine() {
        super(레드와인.name(), 레드와인.getPrice());
    }

    public static Redwine create() {
        return new Redwine();
    }
}
