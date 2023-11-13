package christmas.benefit.discount;

import static christmas.benefit.constants.BenefitConfig.WEEKEND_DISCOUNT_UNIT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.constants.DayOfWeek;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekendDiscountPolicyTest {

    @Test
    @DisplayName("주말 할인이 주말 날짜에 대해 올바르게 계산됩니다.")
    void calculateWeekendDiscountAmountOnWeekend() {
        // given
        Date mockDate = createMockDate(DayOfWeek.SAT, true);
        Order mockOrder = createMockOrder(2);

        // when
        WeekendDiscountPolicy weekendDiscountPolicy = new WeekendDiscountPolicy(mockDate, mockOrder);
        int actualDiscount = weekendDiscountPolicy.getDiscountAmount();

        // then
        assertEquals(WEEKEND_DISCOUNT_UNIT.getValue() * 2, actualDiscount);
    }

    @Test
    @DisplayName("주말 할인이 평일 날짜에 대해는 0입니다.")
    void calculateWeekendDiscountAmountOnWeekday() {
        // given
        Date mockDate = createMockDate(DayOfWeek.THU, false);
        Order mockOrder = createMockOrder(3);

        // when
        WeekendDiscountPolicy weekendDiscountPolicy = new WeekendDiscountPolicy(mockDate, mockOrder);
        int actualDiscount = weekendDiscountPolicy.getDiscountAmount();

        // then
        assertEquals(0, actualDiscount);
    }

    private Date createMockDate(DayOfWeek dayOfWeek, boolean isWeekend) {
        Date mockDate = mock(Date.class);
        when(mockDate.getWeekDay(dayOfWeek)).thenReturn(isWeekend);
        return mockDate;
    }

    private Order createMockOrder(int dessertCount) {
        Order mockOrder = mock(Order.class);
        when(mockOrder.getDessertCount()).thenReturn(dessertCount);
        return mockOrder;
    }
}
