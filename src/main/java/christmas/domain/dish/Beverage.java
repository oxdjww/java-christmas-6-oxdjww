package christmas.domain.dish;

import static christmas.domain.constants.Category.BEVERAGE;

public abstract class Beverage extends Dish {
    protected Beverage(String name, int price) {
        super(name, price, BEVERAGE);
    }
}
