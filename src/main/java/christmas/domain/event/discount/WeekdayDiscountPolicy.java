package christmas.domain.event.discount;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.constants.DayOfWeek;
import christmas.domain.event.constants.EventConfig;

public class WeekdayDiscountPolicy implements DiscountPolicy {
    private int weekdayDiscountAmount = 0;
    private boolean eventEnabled;

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
        this.eventEnabled = eventEnabled;
    }

    @Override
    public int getDiscountAmount() {
        return this.weekdayDiscountAmount;
    }
}
