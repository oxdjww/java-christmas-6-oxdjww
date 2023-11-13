package christmas.domain.constants;

import static java.util.Calendar.DECEMBER;

public enum EventConfig {
    EVENT_YEAR(2023),
    EVENT_MONTH(DECEMBER);

    private final int value;

    EventConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
