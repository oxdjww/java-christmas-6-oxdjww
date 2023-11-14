package christmas.domain.event.discount;

import christmas.domain.Order;
import christmas.domain.event.constants.EventConfig;

public class SpecialDiscountPolicy implements DiscountPolicy {
    private int specialDiscountAmount = 0;
    private boolean eventEnabled;

    public SpecialDiscountPolicy(final Order order, final boolean eventEnabled) {
        if (eventEnabled) {
            if (order.getOrderDate().isSpecialDay()) {
                specialDiscountAmount = EventConfig.SPECIAL_DISCOUNT_AMOUNT.getValue();
            }
        }
        this.eventEnabled = eventEnabled;
    }

    @Override
    public int getDiscountAmount() {
        return this.specialDiscountAmount;
    }
}
