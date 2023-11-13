package christmas.benefit.discount;

import static christmas.benefit.constants.BenefitConfig.WEEKDAY_DISCOUNT_UNIT;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.constants.DayOfWeek;

public class WeekdayDiscountPolicy implements DiscountPolicy {
    private Date date;
    private int weekdayDiscountAmount;

    public WeekdayDiscountPolicy() {
        this.weekdayDiscountAmount = 0;
    }

    public WeekdayDiscountPolicy(final Date date, final Order order) {
        this.date = date;
        if (date.getWeekDay(DayOfWeek.SUN)
                || date.getWeekDay(DayOfWeek.MON)
                || date.getWeekDay(DayOfWeek.TUE)
                || date.getWeekDay(DayOfWeek.WED)
                || date.getWeekDay(DayOfWeek.THU)
        ) {
            weekdayDiscountAmount = WEEKDAY_DISCOUNT_UNIT.getValue() * order.getMaindishCount();
        }

    }

    @Override
    public int getDiscountAmount() {
        return this.weekdayDiscountAmount;
    }
}
