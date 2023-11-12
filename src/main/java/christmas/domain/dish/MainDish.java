package christmas.domain.dish;

import christmas.domain.constants.Category;

public abstract class MainDish extends Dish {
    protected MainDish(String name, int price) {
        super(name, price, Category.MAINDISH);
    }
}
