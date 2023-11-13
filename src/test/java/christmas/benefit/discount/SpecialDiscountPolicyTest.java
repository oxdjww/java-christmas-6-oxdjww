package christmas.benefit.discount;

import static christmas.benefit.constants.BenefitConfig.SPECIAL_DISCOUNT_AMOUNT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import christmas.domain.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpecialDiscountPolicyTest {

    @Test
    @DisplayName("특별 할인이 특별 날짜에 대해 올바르게 계산됩니다.")
    void calculateSpecialDiscountAmountOnSpecialDay() {
        // given
        Date mockDate = createMockDate(true);

        // when
        SpecialDiscountPolicy specialDiscountPolicy = new SpecialDiscountPolicy(mockDate);
        int actualDiscount = specialDiscountPolicy.getDiscountAmount();

        // then
        assertEquals(SPECIAL_DISCOUNT_AMOUNT.getValue(), actualDiscount);
    }

    @Test
    @DisplayName("특별 할인이 특별 날짜가 아닌 경우에는 0입니다.")
    void calculateSpecialDiscountAmountOnNonSpecialDay() {
        // given
        Date mockDate = createMockDate(false);

        // when
        SpecialDiscountPolicy specialDiscountPolicy = new SpecialDiscountPolicy(mockDate);
        int actualDiscount = specialDiscountPolicy.getDiscountAmount();

        // then
        assertEquals(0, actualDiscount);
    }

    private Date createMockDate(boolean isSpecialDay) {
        Date mockDate = mock(Date.class);
        when(mockDate.isSpecialDay()).thenReturn(isSpecialDay);
        return mockDate;
    }
}
