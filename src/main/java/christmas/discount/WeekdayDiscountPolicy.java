package christmas.discount;

import christmas.domain.Date;
import christmas.domain.constants.DayOfWeek;

public class WeekdayDiscountPolicy implements DiscountPolicy {
    private Date date;
    private int weekdayDiscountAmount;

    public WeekdayDiscountPolicy() {
        this.weekdayDiscountAmount = 0;
    }

    public WeekdayDiscountPolicy(Date date) {
        this.date = date;
        if (date.getDay().equals(DayOfWeek.MON)
                || date.getDay().equals(DayOfWeek.TUE)
                || date.getDay().equals(DayOfWeek.WED)
                || date.getDay().equals(DayOfWeek.THU)
                || date.getDay().equals(DayOfWeek.FRI)
        ) {
            weekdayDiscountAmount = 2023;
        }

    }

    @Override
    public int getDiscountAmount() {
        return this.weekdayDiscountAmount;
    }
}
