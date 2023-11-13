package christmas.benefit.promotion;

import static christmas.benefit.constants.BenefitConfig.MINIMUM_FREE_CHAMPAGNE_ORDER_AMOUNT;
import static christmas.domain.constants.Menu.샴페인;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FreeChampagnePolicyTest {
    @Test
    @DisplayName("샴페인 증정 금액 조건 아래의 구매금액일 경우 샴페인을 증정하지 않습니다.")
    void createFreeChampagnePolicyUnderCondition() {
        assertDiscountAmount(0, MINIMUM_FREE_CHAMPAGNE_ORDER_AMOUNT.getValue() - 1);
    }

    @Test
    @DisplayName("샴페인 증정 금액 조건 위의 구매금액일 경우 샴페인을 증정합니다.")
    void createFreeChampagnePolicyOverCondition() {
        assertDiscountAmount(샴페인.getPrice(), MINIMUM_FREE_CHAMPAGNE_ORDER_AMOUNT.getValue());
    }

    private void assertDiscountAmount(int expectedDiscount, int totalOrderAmount) {
        // given
        FreeChampagnePolicy freeChampagnePolicy = new FreeChampagnePolicy(totalOrderAmount);

        // when
        int discountAmount = freeChampagnePolicy.getDiscountAmount();

        // then
        assertEquals(expectedDiscount, discountAmount);
    }
}
