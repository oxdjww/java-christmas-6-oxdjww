package christmas.domain.dish.appetizer;

import static christmas.domain.constants.Menu.타파스;

import christmas.domain.dish.Appetizer;

public class Tapas extends Appetizer {
    protected Tapas() {
        super(타파스.name(), 타파스.getPrice());
    }

    public static Tapas create() {
        return new Tapas();
    }
}
