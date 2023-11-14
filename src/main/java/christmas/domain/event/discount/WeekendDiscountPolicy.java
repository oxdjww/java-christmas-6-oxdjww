package christmas.domain.event.discount;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.constants.DayOfWeek;
import christmas.domain.event.constants.EventConfig;

public class WeekendDiscountPolicy implements DiscountPolicy {
    private int weekEndDiscountAmount = 0;

    public WeekendDiscountPolicy(final Order order, final boolean eventEnabled) {
        if (eventEnabled) {
            Date date = order.getOrderDate();
            if (date.is(DayOfWeek.FRI)
                    || date.is(DayOfWeek.SAT)) {
                weekEndDiscountAmount = EventConfig.WEEKEND_DISCOUNT_UNIT.getValue() * order.getDessertCount();
            }
        }
    }

    @Override
    public int getDiscountAmount() {
        return this.weekEndDiscountAmount;
    }
}
