package christmas.domain.dish;

import static christmas.domain.constants.Category.DESSERT;

public abstract class Dessert extends Dish {
    protected Dessert(String name, int price) {
        super(name, price, DESSERT);
    }
}
