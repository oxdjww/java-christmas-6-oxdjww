package christmas.domain.dish.appetizer;

import static christmas.domain.constants.Menu.양송이수프;

import christmas.domain.dish.Appetizer;

public class MushroomSoup extends Appetizer {
    protected MushroomSoup() {
        super(양송이수프.name(), 양송이수프.getPrice());
    }

    public static MushroomSoup create() {
        return new MushroomSoup();
    }
}
