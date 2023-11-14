package christmas.domain.event.discount;

import christmas.domain.Order;
import christmas.domain.event.constants.EventConfig;

public class DDayDiscountPolicy implements DiscountPolicy {
    private int dDayDiscountAmount = 0;
    private boolean eventEnabled;

    public DDayDiscountPolicy(final Order order, final boolean eventEnabled) {
        if (eventEnabled) {
            if (order.getOrderDate()
                    .isInRange(EventConfig.START_OF_EVENT_MONTH.getValue(), EventConfig.EVENT_DATE.getValue())) {
                this.dDayDiscountAmount = EventConfig.DDAY_DEFAULT_DISCOUNT_AMOUNT.getValue()
                        + (order.getOrderDate().getDate() - 1) * 100;
            }
        }
        this.eventEnabled = eventEnabled;
    }

    @Override
    public int getDiscountAmount() {
        return dDayDiscountAmount;
    }
}
