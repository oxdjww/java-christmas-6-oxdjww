package christmas.domain.event.discount;

import christmas.domain.constants.DayOfWeek;
import christmas.domain.event.constants.EventConfig;
import christmas.domain.order.Date;
import christmas.domain.order.Order;

public class WeekdayDiscountPolicy implements DiscountPolicy {
    private int weekdayDiscountAmount = 0;

    public WeekdayDiscountPolicy(final Order order, final boolean eventEnabled) {
        if (eventEnabled) {
            Date date = order.getOrderDate();
            if (date.is(DayOfWeek.SUN)
                    || date.is(DayOfWeek.MON)
                    || date.is(DayOfWeek.TUE)
                    || date.is(DayOfWeek.WED)
                    || date.is(DayOfWeek.THU)
            ) {
                weekdayDiscountAmount = EventConfig.WEEKDAY_DISCOUNT_UNIT.getValue() * order.getMaindishCount();
            }
        }
    }

    @Override
    public int getDiscountAmount() {
        return this.weekdayDiscountAmount;
    }
}
