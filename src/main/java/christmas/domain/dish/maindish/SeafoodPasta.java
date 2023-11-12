package christmas.domain.dish.maindish;

import static christmas.domain.constants.Menu.해산물파스타;

import christmas.domain.dish.MainDish;

public class SeafoodPasta extends MainDish {
    protected SeafoodPasta() {
        super(해산물파스타.name(), 해산물파스타.getPrice());
    }

    public static SeafoodPasta create() {
        return new SeafoodPasta();
    }
}
