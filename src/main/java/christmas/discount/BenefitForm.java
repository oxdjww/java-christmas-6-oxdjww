package christmas.discount;

import christmas.domain.Date;

public class BenefitForm {
    private final DDayDiscountPolicy dDayDiscountPolicy;
    private final WeekdayDiscountPolicy weekdayDiscountPolicy;
    private final WeekendDiscountPolicy weekendDiscountPolicy;
    private final SpecialDiscountPolicy specialDiscountPolicy;
    private final FreeChampagnePolicy freeChampagnePolicy;
    private final int totalBenefitAmount;

    public BenefitForm() {
        this.dDayDiscountPolicy = new DDayDiscountPolicy();
        this.weekdayDiscountPolicy = new WeekdayDiscountPolicy();
        this.weekendDiscountPolicy = new WeekendDiscountPolicy();
        this.specialDiscountPolicy = new SpecialDiscountPolicy();
        this.freeChampagnePolicy = new FreeChampagnePolicy();
        this.totalBenefitAmount = 0;
    }

    public BenefitForm(final Date date, int totalOrderAmount) {
        this.dDayDiscountPolicy = new DDayDiscountPolicy(date);
        this.weekdayDiscountPolicy = new WeekdayDiscountPolicy(date);
        this.weekendDiscountPolicy = new WeekendDiscountPolicy(date);
        this.specialDiscountPolicy = new SpecialDiscountPolicy(date);
        this.freeChampagnePolicy = new FreeChampagnePolicy(totalOrderAmount);
        this.totalBenefitAmount =
                dDayDiscountPolicy.getDiscountAmount()
                        + weekdayDiscountPolicy.getDiscountAmount()
                        + weekendDiscountPolicy.getDiscountAmount()
                        + specialDiscountPolicy.getDiscountAmount()
                        + freeChampagnePolicy.getDiscountAmount();
    }

    public static BenefitForm of(final Date date, final int totalOrderAmount) {
        if (totalOrderAmount < 10000) {
            return new BenefitForm();
        }
        return new BenefitForm(date, totalOrderAmount);
    }

    public int getDDayDiscountAmount() {
        return this.dDayDiscountPolicy.getDiscountAmount();
    }

    public int getWeekDayDiscountAmount() {
        return this.weekdayDiscountPolicy.getDiscountAmount();
    }

    public int getWeekendDiscountAmount() {
        return this.weekendDiscountPolicy.getDiscountAmount();
    }

    public int getSpecialDiscountAmount() {
        return this.specialDiscountPolicy.getDiscountAmount();
    }

    public int getFreeChampagneDiscountAmount() {
        return this.freeChampagnePolicy.getDiscountAmount();
    }

    public int getTotalBenefitAmount() {
        return this.totalBenefitAmount;
    }
}
