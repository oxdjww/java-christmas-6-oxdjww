package christmas.domain;

import static christmas.domain.constants.DateConstants.MAXIMUM_DATE;
import static christmas.domain.constants.DateConstants.MINIMUM_DATE;
import static christmas.domain.constants.EventConfig.EVENT_MONTH;
import static christmas.domain.constants.EventConfig.EVENT_YEAR;
import static christmas.exception.constants.ErrorMessage.INVALID_DATE_MESSAGE;

import christmas.domain.constants.DayOfWeek;
import christmas.exception.EventPlannerException;
import java.util.Calendar;
import java.util.List;

public class Date {
    private final int date;
    private final DayOfWeek day;
    private final boolean isSpecialDay;

    private Date(final String date) {
        validate(date);
        this.date = Integer.parseInt(date);
        this.day = defineDay(this.date);
        this.isSpecialDay = defineSpecialDay(this.date);
    }

    public static Date of(final String date) {
        return new Date(date);
    }

    private void validate(String date) {
        validateNumeric(date);
        validateRange(date);
    }

    private void validateNumeric(final String date) {
        try {
            Integer.parseInt(date);
        } catch (NumberFormatException e) {
            throw EventPlannerException.of(INVALID_DATE_MESSAGE);
        }
    }

    private void validateRange(String date) {
        int visitDate = Integer.parseInt(date);
        if (visitDate < MINIMUM_DATE.getDate() || visitDate > MAXIMUM_DATE.getDate()) {
            throw EventPlannerException.of(INVALID_DATE_MESSAGE);
        }
    }

    private DayOfWeek defineDay(int date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(EVENT_YEAR.getValue(), EVENT_MONTH.getValue(), date);
        List<DayOfWeek> days = List.of(DayOfWeek.SUN, DayOfWeek.MON, DayOfWeek.TUE, DayOfWeek.WED, DayOfWeek.THU,
                DayOfWeek.FRI, DayOfWeek.SAT);
        return days.get(calendar.get(Calendar.DAY_OF_WEEK) - 1);
    }

    private boolean defineSpecialDay(int date) {
        List<Integer> specialDays = List.of(3, 10, 17, 24, 31);
        return specialDays.contains(date);
    }

    public boolean isInRange(final int startDate, final int dueDate) {
        return this.date >= startDate && this.date <= dueDate;
    }

    public int getDate() {
        return this.date;
    }

    public DayOfWeek getDay() {
        return this.day;
    }

    public boolean isSpecialDay() {
        return this.isSpecialDay;
    }
}
