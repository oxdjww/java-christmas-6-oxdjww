package christmas.benefit;

import christmas.domain.Date;
import christmas.domain.Order;

public class BenefitForm {
    private final DDayDiscountPolicy dDayDiscountPolicy;
    private final WeekdayDiscountPolicy weekdayDiscountPolicy;
    private final WeekendDiscountPolicy weekendDiscountPolicy;
    private final SpecialDiscountPolicy specialDiscountPolicy;
    private final FreeChampagnePolicy freeChampagnePolicy;
    private final int totalBenefitAmount;

    // 이벤트가 적용되지 않을 경우 할인금액이 0으로 되어있는 기본 생성자들 호출
    public BenefitForm() {
        this.dDayDiscountPolicy = new DDayDiscountPolicy();
        this.weekdayDiscountPolicy = new WeekdayDiscountPolicy();
        this.weekendDiscountPolicy = new WeekendDiscountPolicy();
        this.specialDiscountPolicy = new SpecialDiscountPolicy();
        this.freeChampagnePolicy = new FreeChampagnePolicy();
        this.totalBenefitAmount = 0;
    }

    public BenefitForm(final Date date, final Order order) {
        this.dDayDiscountPolicy = new DDayDiscountPolicy(date);
        this.weekdayDiscountPolicy = new WeekdayDiscountPolicy(date,order);
        this.weekendDiscountPolicy = new WeekendDiscountPolicy(date,order);
        this.specialDiscountPolicy = new SpecialDiscountPolicy(date);
        this.freeChampagnePolicy = new FreeChampagnePolicy(order.getTotalOrderAmount());
        this.totalBenefitAmount =
                dDayDiscountPolicy.getDiscountAmount()
                        + weekdayDiscountPolicy.getDiscountAmount()
                        + weekendDiscountPolicy.getDiscountAmount()
                        + specialDiscountPolicy.getDiscountAmount()
                        + freeChampagnePolicy.getDiscountAmount();
    }

    public static BenefitForm of(final Date date, final Order order) {
        if ( order.getTotalOrderAmount() < 10000) {
            return new BenefitForm();
        }
        return new BenefitForm(date, order);
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

    public int getTotalDiscountAmount() {
        return this.totalBenefitAmount - getFreeChampagneDiscountAmount();
    }
}
