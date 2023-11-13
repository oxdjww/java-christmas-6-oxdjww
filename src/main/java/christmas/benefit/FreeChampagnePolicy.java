package christmas.benefit;

import static christmas.domain.constants.Menu.샴페인;

public class FreeChampagnePolicy implements DiscountPolicy {
    private int freeChampagneDiscountAmount = 0;

    public FreeChampagnePolicy() {
    }

    public FreeChampagnePolicy(int totalOrderAmount) {
        if (totalOrderAmount > 120000) {
            this.freeChampagneDiscountAmount = 샴페인.getPrice();
        }
    }

    @Override
    public int getDiscountAmount() {
        return freeChampagneDiscountAmount;
    }
}
