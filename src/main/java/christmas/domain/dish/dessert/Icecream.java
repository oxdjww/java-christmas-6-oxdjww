package christmas.domain.dish.dessert;

import static christmas.domain.constants.Menu.아이스크림;

import christmas.domain.dish.Dessert;

public class Icecream extends Dessert {
    protected Icecream() {
        super(아이스크림.name(), 아이스크림.getPrice());
    }

    public static Icecream create() {
        return new Icecream();
    }
}
