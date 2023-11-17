package christmas.domain.event.constants;

public enum EventConfig {
    MINIMUM_EVENT_ORDER_AMOUNT(10_000),
    DDAY_DEFAULT_DISCOUNT_AMOUNT(1_000),
    START_OF_EVENT_MONTH(1),
    EVENT_DATE(25),
    MINIMUM_FREE_CHAMPAGNE_ORDER_AMOUNT(120_000),
    SPECIAL_DISCOUNT_AMOUNT(1_000),
    WEEKDAY_DISCOUNT_UNIT(2_023),
    WEEKEND_DISCOUNT_UNIT(2_023);

    private final int value;

    EventConfig(final int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
