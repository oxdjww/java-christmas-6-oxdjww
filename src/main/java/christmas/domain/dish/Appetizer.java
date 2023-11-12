package christmas.domain.dish;

import static christmas.domain.constants.Category.APPETIZER;

public abstract class Appetizer extends Dish {
    protected Appetizer(final String name, final int price) {
        super(name, price, APPETIZER);
    }
}
