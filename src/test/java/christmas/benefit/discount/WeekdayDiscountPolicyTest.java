package christmas.benefit.discount;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.constants.DayOfWeek;
import christmas.domain.event.constants.EventConfig;
import christmas.domain.event.discount.WeekdayDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WeekdayDiscountPolicyTest {

    @Test
    @DisplayName("평일 할인이 평일 날짜에 대해 올바르게 계산됩니다.")
    void calculateWeekdayDiscountAmountOnWeekday() {
        // given
        Date mockDate = createMockDate(DayOfWeek.MON, true);
        Order mockOrder = createMockOrder(3,"13");

        // when
        WeekdayDiscountPolicy weekdayDiscountPolicy = new WeekdayDiscountPolicy(mockOrder, true);
        int actualDiscount = weekdayDiscountPolicy.getDiscountAmount();

        // then
        assertEquals(EventConfig.WEEKDAY_DISCOUNT_UNIT.getValue() * 3, actualDiscount);
    }

    @Test
    @DisplayName("평일 할인이 주말 날짜에 대해는 0입니다.")
    void calculateWeekdayDiscountAmountOnWeekend() {
        // given
        Date mockDate = createMockDate(DayOfWeek.FRI, true);
        Order mockOrder = createMockOrder(2,"1");

        // when
        WeekdayDiscountPolicy weekdayDiscountPolicy = new WeekdayDiscountPolicy(mockOrder, true);
        int actualDiscount = weekdayDiscountPolicy.getDiscountAmount();

        // then
        assertEquals(0, actualDiscount);
    }

    private Date createMockDate(DayOfWeek dayOfWeek, boolean isWeekendOrWeekDay) {
        Date mockDate = mock(Date.class);
        when(mockDate.is(dayOfWeek)).thenReturn(isWeekendOrWeekDay);
        return mockDate;
    }

    private Order createMockOrder(int mainDishCount, String orderDate) {
        Order mockOrder = mock(Order.class);
        when(mockOrder.getMaindishCount()).thenReturn(mainDishCount);
        when(mockOrder.getOrderDate()).thenReturn(Date.of(orderDate));
        return mockOrder;
    }
}
