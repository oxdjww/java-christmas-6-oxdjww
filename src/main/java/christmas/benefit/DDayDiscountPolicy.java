package christmas.benefit;

import static christmas.benefit.BenefitConfig.DDAY_DEFAULT_DISCOUNT_AMOUNT;
import static christmas.benefit.BenefitConfig.EVENT_DATE;
import static christmas.benefit.BenefitConfig.START_OF_EVENT_MONTH;

import christmas.domain.Date;

public class DDayDiscountPolicy implements DiscountPolicy {
    private Date date;
    private int dDayDiscountAmount;

    public DDayDiscountPolicy() {
        this.dDayDiscountAmount = 0;
    }

    public DDayDiscountPolicy(final Date date) {
        if (date.getDate() > EVENT_DATE.getValue()) {
            this.dDayDiscountAmount = 0;
        }
        if (date.getDate() >= START_OF_EVENT_MONTH.getValue() && date.getDate() <= EVENT_DATE.getValue()) {
            this.dDayDiscountAmount = DDAY_DEFAULT_DISCOUNT_AMOUNT.getValue() + (date.getDate() - 1) * 100;
        }
    }

    @Override
    public int getDiscountAmount() {
        return dDayDiscountAmount;
    }
}
