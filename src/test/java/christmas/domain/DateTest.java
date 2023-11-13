package christmas.domain;


import static christmas.domain.constants.DayOfWeek.FRI;
import static christmas.domain.constants.DayOfWeek.WED;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DateTest {
    @Test
    @DisplayName("날짜에 맞게끔 요일이 잘 생성된다.")
    void createValidDay() {
        Assertions.assertEquals(Date.of("1").getDay(), FRI);
        Assertions.assertEquals(Date.of("13").getDay(), WED);
    }

}