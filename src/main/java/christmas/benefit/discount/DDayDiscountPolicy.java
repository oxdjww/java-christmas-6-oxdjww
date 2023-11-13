package christmas.benefit.discount;

import static christmas.benefit.constants.BenefitConfig.DDAY_DEFAULT_DISCOUNT_AMOUNT;
import static christmas.benefit.constants.BenefitConfig.EVENT_DATE;
import static christmas.benefit.constants.BenefitConfig.START_OF_EVENT_MONTH;

import christmas.domain.Date;

public class DDayDiscountPolicy implements DiscountPolicy {
    private Date date;
    private int dDayDiscountAmount = 0;

    public DDayDiscountPolicy() {
    }

    public DDayDiscountPolicy(final Date date) {
        if (date.isInRange(START_OF_EVENT_MONTH.getValue(), EVENT_DATE.getValue())) {
            this.dDayDiscountAmount = DDAY_DEFAULT_DISCOUNT_AMOUNT.getValue() + (date.getDate() - 1) * 100;
        }
    }

    @Override
    public int getDiscountAmount() {
        return dDayDiscountAmount;
    }
}
