package christmas.domain.dish.dessert;

import static christmas.domain.constants.Menu.초코케이크;

import christmas.domain.dish.Dessert;

public class ChocolateCake extends Dessert {
    protected ChocolateCake() {
        super(초코케이크.name(), 초코케이크.getPrice());
    }

    public static ChocolateCake create() {
        return new ChocolateCake();
    }
}
