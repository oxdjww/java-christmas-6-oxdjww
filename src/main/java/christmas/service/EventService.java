package christmas.service;

import christmas.domain.Order;
import christmas.domain.event.constants.EventConfig;
import christmas.domain.event.discount.DDayDiscountPolicy;
import christmas.domain.event.discount.SpecialDiscountPolicy;
import christmas.domain.event.discount.WeekdayDiscountPolicy;
import christmas.domain.event.discount.WeekendDiscountPolicy;
import christmas.domain.event.promotion.FreeChampagnePolicy;

public class EventService {
    private DDayDiscountPolicy dDayDiscountPolicy;
    private SpecialDiscountPolicy specialDiscountPolicy;
    private WeekdayDiscountPolicy weekdayDiscountPolicy;
    private WeekendDiscountPolicy weekendDiscountPolicy;
    private FreeChampagnePolicy freeChampagnePolicy;
    private int totalBenefitAmount;

    public EventService() {
    }

    public void setEvent(final Order order) {
        boolean eventEnable = true;
        if (order.getTotalOrderAmount() < EventConfig.MINIMUM_EVENT_ORDER_AMOUNT.getValue()) {
            eventEnable = false;
        }
        this.dDayDiscountPolicy = new DDayDiscountPolicy(order, eventEnable);
        this.specialDiscountPolicy = new SpecialDiscountPolicy(order, eventEnable);
        this.weekdayDiscountPolicy = new WeekdayDiscountPolicy(order, eventEnable);
        this.weekendDiscountPolicy = new WeekendDiscountPolicy(order, eventEnable);
        this.freeChampagnePolicy = new FreeChampagnePolicy(order.getTotalOrderAmount());
        this.totalBenefitAmount =
                dDayDiscountPolicy.getDiscountAmount()
                        + weekdayDiscountPolicy.getDiscountAmount()
                        + weekendDiscountPolicy.getDiscountAmount()
                        + specialDiscountPolicy.getDiscountAmount()
                        + freeChampagnePolicy.getDiscountAmount();
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
