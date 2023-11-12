package christmas.domain;

public class Date {
    private final int date;

    private Date(final String date) {
        this.date = Integer.parseInt(date);
    }

    public static Date of(final String date) {
        return new Date(date);
    }
}
