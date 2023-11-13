package christmas.benefit;

import static christmas.benefit.BenefitConfig.SPECIAL_DISCOUNT_AMOUNT;

import christmas.domain.Date;

public class SpecialDiscountPolicy implements DiscountPolicy{
    private Date date;
    private int specialDiscountAmount = 0;

    public SpecialDiscountPolicy() {

    }

    public SpecialDiscountPolicy(Date date) {
        if (date.isSpecialDay()) {
            specialDiscountAmount = SPECIAL_DISCOUNT_AMOUNT.getValue();
        }
    }

    @Override
    public int getDiscountAmount() {
        return this.specialDiscountAmount;
    }
}
