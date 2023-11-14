package christmas.domain.event.discount;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.event.constants.EventConfig;
import christmas.domain.constants.DayOfWeek;

public class WeekendDiscountPolicy implements DiscountPolicy {
    private int weekEndDiscountAmount = 0;
    private boolean eventEnabled;

    public WeekendDiscountPolicy(final Order order, final boolean eventEnabled) {
        if (eventEnabled) {
            Date date = order.getOrderDate();
            if (date.is(DayOfWeek.FRI)
                    || date.is(DayOfWeek.SAT)) {
                weekEndDiscountAmount = EventConfig.WEEKEND_DISCOUNT_UNIT.getValue() * order.getDessertCount();
            }
        }
        this.eventEnabled = eventEnabled;
    }

    @Override
    public int getDiscountAmount() {
        return this.weekEndDiscountAmount;
    }
}
