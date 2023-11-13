package christmas.service;

import christmas.domain.Date;
import christmas.domain.Order;

public class OrderService {
    public Order createOrder(final String order, final Date date) {
        return Order.from(order, date);
    }
}
