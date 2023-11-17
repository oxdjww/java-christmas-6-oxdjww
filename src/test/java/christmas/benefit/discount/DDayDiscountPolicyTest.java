package christmas.benefit.discount;

import static christmas.domain.event.constants.EventConfig.DDAY_DEFAULT_DISCOUNT_AMOUNT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import christmas.domain.event.discount.DDayDiscountPolicy;
import christmas.domain.order.Date;
import christmas.domain.order.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DDayDiscountPolicyTest {

    private Date mockDate;
    private Order mockOrder;

    @BeforeEach
    void setUp() {
        mockDate = mock(Date.class);
        mockOrder = mock(Order.class);
    }

    @Test
    @DisplayName("이벤트 월 내 날짜에 대한 D-Day 할인 금액이 올바르게 계산됩니다.")
    void calculateDDayDiscountAmountWithinEventMonth() {
        // given
        givenDateInRange(true, 5);
        when(mockOrder.getOrderDate()).thenReturn(mockDate);

        // when
        DDayDiscountPolicy dDayDiscountPolicy = new DDayDiscountPolicy(mockOrder, true);
        int actualDiscount = dDayDiscountPolicy.getDiscountAmount();

        // then
        assertEquals(DDAY_DEFAULT_DISCOUNT_AMOUNT.getValue() + (5 - 1) * 100, actualDiscount);
    }

    @Test
    @DisplayName("이벤트 월 외 날짜에 대한 D-Day 할인 금액이 0입니다.")
    void calculateDDayDiscountAmountOutsideEventMonth() {
        // given
        givenDateInRange(false, 0);
        when(mockOrder.getOrderDate()).thenReturn(mockDate);

        // when
        DDayDiscountPolicy dDayDiscountPolicy = new DDayDiscountPolicy(mockOrder, true);
        int actualDiscount = dDayDiscountPolicy.getDiscountAmount();

        // then
        assertEquals(0, actualDiscount);
    }

    private void givenDateInRange(boolean isInRange, int date) {
        when(mockDate.isInRange(1, 25)).thenReturn(isInRange);
        when(mockDate.getDate()).thenReturn(date);
    }
}