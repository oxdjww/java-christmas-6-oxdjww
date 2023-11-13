package christmas.service;

import christmas.domain.Date;

public class DateService {
    public Date createDate(final String readDate) {
        return Date.of(readDate);
    }
}
