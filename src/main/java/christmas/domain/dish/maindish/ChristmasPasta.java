package christmas.domain.dish.maindish;

import static christmas.domain.constants.Menu.크리스마스파스타;

import christmas.domain.dish.MainDish;

public class ChristmasPasta extends MainDish {
    protected ChristmasPasta() {
        super(크리스마스파스타.name(), 크리스마스파스타.getPrice());
    }

    public static ChristmasPasta create() {
        return new ChristmasPasta();
    }
}
