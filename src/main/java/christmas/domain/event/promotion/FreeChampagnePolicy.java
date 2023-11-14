package christmas.domain.event.promotion;

import static christmas.domain.constants.Menu.샴페인;

import christmas.domain.event.discount.DiscountPolicy;
import christmas.domain.event.constants.EventConfig;

public class FreeChampagnePolicy implements DiscountPolicy {
    private int freeChampagneDiscountAmount = 0;

    public FreeChampagnePolicy() {
    }

    public FreeChampagnePolicy(final int totalOrderAmount) {
        if (totalOrderAmount >= EventConfig.MINIMUM_FREE_CHAMPAGNE_ORDER_AMOUNT.getValue()) {
            this.freeChampagneDiscountAmount = 샴페인.getPrice();
        }
    }

    @Override
    public int getDiscountAmount() {
        return freeChampagneDiscountAmount;
    }
}
