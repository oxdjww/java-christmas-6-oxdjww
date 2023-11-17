package christmas.domain.dish.maindish;

import static christmas.domain.constants.Menu.티본스테이크;

import christmas.domain.dish.MainDish;

public class TBoneSteak extends MainDish {
    protected TBoneSteak() {
        super(티본스테이크.name(), 티본스테이크.getPrice());
    }

    public static TBoneSteak create() {
        return new TBoneSteak();
    }
}
