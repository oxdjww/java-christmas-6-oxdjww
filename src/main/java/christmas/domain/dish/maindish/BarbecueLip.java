package christmas.domain.dish.maindish;

import static christmas.domain.constants.Menu.바비큐립;

import christmas.domain.dish.MainDish;

public class BarbecueLip extends MainDish {
    protected BarbecueLip() {
        super(바비큐립.name(), 바비큐립.getPrice());
    }

    public static BarbecueLip create() {
        return new BarbecueLip();
    }
}
