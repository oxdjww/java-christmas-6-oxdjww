package christmas.domain;

import static christmas.exception.constants.ErrorMessage.INVALID_DATE_MESSAGE;

import christmas.exception.EventPlannerException;

public class Date {
    private final int date;

    private Date(final String date) {
        validate(date);
        this.date = Integer.parseInt(date);
    }

    public static Date of(final String date) {
        return new Date(date);
    }

    private void validate(String date) {
        validateNumeric(date);
    }

    private void validateNumeric(final String date) {
        try {
            Integer.parseInt(date);
        } catch (NumberFormatException e) {
            throw EventPlannerException.of(INVALID_DATE_MESSAGE);
        }
    }
}
