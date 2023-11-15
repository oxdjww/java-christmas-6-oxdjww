package christmas.service;

import christmas.domain.order.Date;
import christmas.domain.order.Order;

public class OrderService {
    public Order createOrder(final String order, final Date date) {
        return Order.from(order, date);
    }
}
