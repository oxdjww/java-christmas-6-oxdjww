package christmas.domain.event.discount;

import christmas.domain.event.constants.EventConfig;
import christmas.domain.order.Order;

public class DDayDiscountPolicy implements DiscountPolicy {
    private int dDayDiscountAmount = 0;

    public DDayDiscountPolicy(final Order order, final boolean eventEnabled) {
        if (eventEnabled) {
            if (order.getOrderDate()
                    .isInRange(EventConfig.START_OF_EVENT_MONTH.getValue(), EventConfig.EVENT_DATE.getValue())) {
                this.dDayDiscountAmount = EventConfig.DDAY_DEFAULT_DISCOUNT_AMOUNT.getValue()
                        + (order.getOrderDate().getDate() - 1) * 100;
            }
        }
    }

    @Override
    public int getDiscountAmount() {
        return dDayDiscountAmount;
    }
}
