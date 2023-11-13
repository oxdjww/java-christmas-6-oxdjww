package christmas.benefit;

import static christmas.benefit.BenefitConfig.MINIMUM_FREE_CHAMPAGNE_ORDER_AMOUNT;
import static christmas.domain.constants.Menu.샴페인;

public class FreeChampagnePolicy implements DiscountPolicy {
    private int freeChampagneDiscountAmount = 0;

    public FreeChampagnePolicy() {
    }

    public FreeChampagnePolicy(final int totalOrderAmount) {
        if (totalOrderAmount > MINIMUM_FREE_CHAMPAGNE_ORDER_AMOUNT.getValue()) {
            this.freeChampagneDiscountAmount = 샴페인.getPrice();
        }
    }

    @Override
    public int getDiscountAmount() {
        return freeChampagneDiscountAmount;
    }
}
