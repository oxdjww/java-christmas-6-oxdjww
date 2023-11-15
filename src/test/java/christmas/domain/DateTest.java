package christmas.domain;


import static christmas.domain.constants.DayOfWeek.FRI;
import static christmas.domain.constants.DayOfWeek.WED;
import static christmas.exception.constants.ErrorMessage.INVALID_DATE_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.order.Date;
import christmas.exception.EventPlannerException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DateTest {
    @Test
    @DisplayName("날짜에 맞게끔 요일이 잘 생성된다.")
    void createValidDate() {
        Assertions.assertEquals(Date.of("1").getDay(), FRI);
        Assertions.assertEquals(Date.of("13").getDay(), WED);
    }

    @Test
    @DisplayName("특수 문자로 날짜 생성 시 예외가 발생한다.")
    void createDateWithNonNumeric() {
        assertInvalidDate("!@#");
    }

    @Test
    @DisplayName("음수로 날짜 생성 시 예외가 발생한다.")
    void createDateWithNegativeNumeric() {
        assertInvalidDate("-1");
    }

    @Test
    @DisplayName("일반 문자로 날짜 생성 시 예외가 발생한다.")
    void createDateWithChar() {
        assertInvalidDate("B");
    }

    @Test
    @DisplayName("날짜의 최대값(31)을 넘는 날짜 생성 시 예외가 발생한다.")
    void createDateWithOverMax() {
        assertInvalidDate("35");
    }

    private void assertInvalidDate(String dateString) {
        assertThatThrownBy(() -> Date.of(dateString))
                .isInstanceOf(EventPlannerException.class)
                .hasMessageContaining(INVALID_DATE_MESSAGE.getMessage());
    }
}