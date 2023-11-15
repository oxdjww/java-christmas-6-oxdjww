package christmas.domain.event.discount;

import christmas.domain.order.Order;
import christmas.domain.event.constants.EventConfig;

public class SpecialDiscountPolicy implements DiscountPolicy {
    private int specialDiscountAmount = 0;

    public SpecialDiscountPolicy(final Order order, final boolean eventEnabled) {
        if (eventEnabled) {
            if (order.getOrderDate().isSpecialDay()) {
                specialDiscountAmount = EventConfig.SPECIAL_DISCOUNT_AMOUNT.getValue();
            }
        }
    }

    @Override
    public int getDiscountAmount() {
        return this.specialDiscountAmount;
    }
}
