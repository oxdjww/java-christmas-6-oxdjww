package christmas.domain.constants;

public enum DateConstants {
    MINIMUM_DATE(1),
    MAXIMUM_DATE(31);

    private final int date;

    DateConstants(final int date) {
        this.date = date;
    }

    public int getDate() {
        return date;
    }
}
