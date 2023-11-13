package christmas.benefit;

import static christmas.benefit.BenefitConfig.WEEKEND_DISCOUNT_UNIT;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.constants.DayOfWeek;

public class WeekendDiscountPolicy implements DiscountPolicy{
    private Date date;
    private int weekEndDiscountAmount;

    public WeekendDiscountPolicy() {
        this.weekEndDiscountAmount = 0;
    }

    public WeekendDiscountPolicy(Date date, Order order) {
        if (date.getDay().equals(DayOfWeek.FRI)
                || date.getDay().equals(DayOfWeek.SAT)) {
            weekEndDiscountAmount = WEEKEND_DISCOUNT_UNIT.getValue() * order.getDessertCount();
        }
    }
    @Override
    public int getDiscountAmount() {
        return this.weekEndDiscountAmount;
    }
}
