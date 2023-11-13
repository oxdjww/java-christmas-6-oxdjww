package christmas.benefit.discount;

import static christmas.benefit.constants.BenefitConfig.WEEKDAY_DISCOUNT_UNIT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.constants.DayOfWeek;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekdayDiscountPolicyTest {

    @Test
    @DisplayName("평일 할인이 평일 날짜에 대해 올바르게 계산됩니다.")
    void calculateWeekdayDiscountAmountOnWeekday() {
        // given
        Date mockDate = createMockDate(DayOfWeek.MON, false);
        Order mockOrder = createMockOrder(3);

        // when
        WeekdayDiscountPolicy weekdayDiscountPolicy = new WeekdayDiscountPolicy(mockDate, mockOrder);
        int actualDiscount = weekdayDiscountPolicy.getDiscountAmount();

        // then
        assertEquals(WEEKDAY_DISCOUNT_UNIT.getValue() * 3, actualDiscount);
    }

    @Test
    @DisplayName("평일 할인이 주말 날짜에 대해는 0입니다.")
    void calculateWeekdayDiscountAmountOnWeekend() {
        // given
        Date mockDate = createMockDate(DayOfWeek.FRI, true);
        Order mockOrder = createMockOrder(2);

        // when
        WeekdayDiscountPolicy weekdayDiscountPolicy = new WeekdayDiscountPolicy(mockDate, mockOrder);
        int actualDiscount = weekdayDiscountPolicy.getDiscountAmount();

        // then
        assertEquals(0, actualDiscount);
    }

    private Date createMockDate(DayOfWeek dayOfWeek, boolean isWeekend) {
        Date mockDate = mock(Date.class);
        when(mockDate.getWeekDay(dayOfWeek)).thenReturn(isWeekend);
        return mockDate;
    }

    private Order createMockOrder(int mainDishCount) {
        Order mockOrder = mock(Order.class);
        when(mockOrder.getMaindishCount()).thenReturn(mainDishCount);
        return mockOrder;
    }
}

