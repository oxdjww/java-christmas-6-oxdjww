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
            if (date.getWeekDay(DayOfWeek.SUN)
                    || date.getWeekDay(DayOfWeek.MON)
                    || date.getWeekDay(DayOfWeek.TUE)
                    || date.getWeekDay(DayOfWeek.WED)
                    || date.getWeekDay(DayOfWeek.THU)
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
