package christmas.discount;

import christmas.domain.Date;

public class SpecialDiscountPolicy implements DiscountPolicy{
    private Date date;
    private int specialDiscountAmount = 0;

    public SpecialDiscountPolicy() {

    }

    public SpecialDiscountPolicy(Date date) {
        if (date.isSpecialDay()) {
            specialDiscountAmount = 1000;
        }
    }

    @Override
    public int getDiscountAmount() {
        return this.specialDiscountAmount;
    }
}
