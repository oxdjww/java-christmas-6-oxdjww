package christmas.benefit.discount;

import static christmas.benefit.constants.BenefitConfig.WEEKEND_DISCOUNT_UNIT;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.constants.DayOfWeek;

public class WeekendDiscountPolicy implements DiscountPolicy{
    private Date date;
    private int weekEndDiscountAmount;

    public WeekendDiscountPolicy() {
        this.weekEndDiscountAmount = 0;
    }

    public WeekendDiscountPolicy(final Date date, final Order order) {
        if (date.getWeekDay(DayOfWeek.FRI)
                || date.getWeekDay(DayOfWeek.SAT)) {
            weekEndDiscountAmount = WEEKEND_DISCOUNT_UNIT.getValue() * order.getDessertCount();
        }
    }
    @Override
    public int getDiscountAmount() {
        return this.weekEndDiscountAmount;
    }
}
