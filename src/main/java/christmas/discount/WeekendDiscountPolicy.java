package christmas.discount;

import christmas.domain.Date;
import christmas.domain.constants.DayOfWeek;

public class WeekendDiscountPolicy implements DiscountPolicy{
    private Date date;
    private int weekEndDiscountAmount;

    public WeekendDiscountPolicy() {
        this.weekEndDiscountAmount = 0;
    }

    public WeekendDiscountPolicy(Date date) {
        if (date.getDay().equals(DayOfWeek.FRI)
                || date.getDay().equals(DayOfWeek.SAT)) {
            weekEndDiscountAmount = 2023;
        }
    }
    @Override
    public int getDiscountAmount() {
        return this.weekEndDiscountAmount;
    }
}
