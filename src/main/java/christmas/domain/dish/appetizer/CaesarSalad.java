package christmas.domain.dish.appetizer;

import static christmas.domain.constants.Menu.시저샐러드;

import christmas.domain.dish.Appetizer;

public class CaesarSalad extends Appetizer {
    protected CaesarSalad() {
        super(시저샐러드.name(), 시저샐러드.getPrice());
    }

    public static CaesarSalad create() {
        return new CaesarSalad();
    }
}
