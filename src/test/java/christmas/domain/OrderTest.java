package christmas.domain;

import static christmas.exception.constants.ErrorMessage.INVALID_ORDER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.exception.EventPlannerException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    @DisplayName("주문 수량을 입력하지 않으면 예외가 발생한다.")
    void createOrderWithNoCount() {
        assertInvalidOrder("타파스-1,제로콜라");
    }

    @Test
    @DisplayName("주문 메뉴를 입력하지 않으면 예외가 발생한다.")
    void createOrderWithNoMenu() {
        assertInvalidOrder("타파스-1,-3");
    }

    @Test
    @DisplayName("주문을 잘못된 양식으로 입력하면 예외가 발생한다.")
    void createInvalidFormatOrder() {
        assertInvalidOrder("b");
    }

    @Test
    @DisplayName("메뉴의 개수가 1개 이상 정수가 아니면 예외가 발생한다.")
    void createInvalidOrderCount() {
        assertInvalidOrder("타파스-1,제로콜라-0");
        assertInvalidOrder("타파스-&,제로콜라-1");
    }

    @Test
    @DisplayName("메뉴판에 없는 메뉴를 주문하면 예외가 발생한다.")
    void createOrderWithNotExistingMenu() {
        assertInvalidOrder("타파스-1,제로사이다-1");
    }

    @Test
    @DisplayName("중복된 메뉴를 주문하면 예외가 발생한다.")
    void createDuplicateOrder() {
        assertInvalidOrder("타파스-1,타파스-2");
    }

    @Test
    @DisplayName("주문 메뉴 수량이 최대치를 넘어가면 예외가 발생한다.")
    void createOrderWithOverLimit() { assertInvalidOrder("타파스-1,제로콜라-20"); }

    @Test
    @DisplayName("음료만 주문시 예외가 발생한다.")
    void createOrderWithOnlyBeverage() {
        assertInvalidOrder("제로콜라-2");
    }

    @Test
    @DisplayName("주문의 메인디쉬 개수를 측정한다.")
    void createOrderWithMaindish() {
        // given
        Order order1 = Order.from("티본스테이크-2,샴페인-2,해산물파스타-1", Date.of("3"));
        Order order2 = Order.from("티본스테이크-5,샴페인-2", Date.of("3"));

        // when & then
        Assertions.assertEquals(3,order1.getMaindishCount());
        Assertions.assertEquals(5,order2.getMaindishCount());
    }

    @Test
    @DisplayName("주문의 디저트 개수를 측정한다.")
    void createOrderWithDessert() {
        // given
        Order order1 = Order.from("티본스테이크-2,샴페인-2,해산물파스타-1", Date.of("3"));
        Order order2 = Order.from("티본스테이크-2,샴페인-2,해산물파스타-1,초코케이크-5", Date.of("3"));

        // when & then
        Assertions.assertEquals(0,order1.getDessertCount());
        Assertions.assertEquals(5,order2.getDessertCount());
    }

    private void assertInvalidOrder(String orderString) {
        assertThatThrownBy(() -> Order.from(orderString, Date.of("1")))
                .isInstanceOf(EventPlannerException.class)
                .hasMessageContaining(INVALID_ORDER.getMessage());
    }
}
