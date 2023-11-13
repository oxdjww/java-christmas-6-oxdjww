package christmas.discount;

import christmas.domain.Date;

public class DDayDiscountPolicy implements DiscountPolicy {
    private Date date;
    private int dDayDiscountAmount;
    private static final int DEFAULT_DISCOUNT_AMOUNT = 1000;

    public DDayDiscountPolicy() {
        this.dDayDiscountAmount = 0;
    }

    public DDayDiscountPolicy(Date date) {
        if (date.getDate() > 25) {
            this.dDayDiscountAmount = 0;
        }
        if (date.getDate() >= 1 && date.getDate() <= 25) {
            this.dDayDiscountAmount = DEFAULT_DISCOUNT_AMOUNT + (date.getDate() - 1) * 100;
        }
    }

    @Override
    public int getDiscountAmount() {
        return dDayDiscountAmount;
    }
}
