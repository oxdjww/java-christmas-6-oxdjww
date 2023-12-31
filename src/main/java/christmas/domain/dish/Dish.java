package christmas.domain.dish;

import christmas.domain.constants.Category;

public abstract class Dish {
    private final String name;
    private final int price;
    private final Category category;

    protected Dish(final String name, final int price, final Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public Category getCategory() {
        return this.category;
    }
}
