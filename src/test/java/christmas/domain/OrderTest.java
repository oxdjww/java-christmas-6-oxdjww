package christmas.domain;

import static christmas.exception.constants.ErrorMessage.INVALID_ORDER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.exception.EventPlannerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    @DisplayName("주문 양식이 올바르지 않으면 예외가 발생한다.")
    void createInvalidFormatOrder() {
        assertInvalidOrder("타파스-1,제로콜라");
        assertInvalidOrder("----");
    }

    @Test
    @DisplayName("메뉴의 개수가 1개 이상이 아니면 예외가 발생한다.")
    void createInvalidOrderCount() {
        assertInvalidOrder("타파스-1,제로콜라-0");
        assertInvalidOrder("타파스-&,제로콜라-1");
    }

    @Test
    @DisplayName("메뉴판에 없는 메뉴를 주문하면 예외가 발생한다.")
    void createNotExistingMenu() {
        assertInvalidOrder("타파스-1,제로사이다-1");
    }

    @Test
    @DisplayName("중복된 메뉴를 주문하면 예외가 발생한다.")
    void createDuplicateOrder() {
        assertInvalidOrder("타파스-1,타파스-2");
    }

    @Test
    @DisplayName("주문 메뉴 수량이 최대치를 넘어가면 예외가 발생한다.")
    void createMenuOverLimit() {
        assertInvalidOrder("타파스-1,제로콜라-20");
    }

    private void assertInvalidOrder(String orderString) {
        assertThatThrownBy(() -> Order.from(orderString, Date.of("1")))
                .isInstanceOf(EventPlannerException.class)
                .hasMessageContaining(INVALID_ORDER.getMessage());
    }
}
