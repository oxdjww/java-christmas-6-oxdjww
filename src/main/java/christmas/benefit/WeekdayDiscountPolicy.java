package christmas.benefit;

import static christmas.benefit.BenefitConfig.WEEKDAY_DISCOUNT_UNIT;

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
        if (date.getDay().equals(DayOfWeek.SUN)
                || date.getDay().equals(DayOfWeek.MON)
                || date.getDay().equals(DayOfWeek.TUE)
                || date.getDay().equals(DayOfWeek.WED)
                || date.getDay().equals(DayOfWeek.THU)
        ) {
            weekdayDiscountAmount = WEEKDAY_DISCOUNT_UNIT.getValue() * order.getMaindishCount();
        }

    }

    @Override
    public int getDiscountAmount() {
        return this.weekdayDiscountAmount;
    }
}
