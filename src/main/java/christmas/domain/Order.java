package christmas.domain;

import static christmas.domain.constants.Category.BEVERAGE;
import static christmas.exception.constants.ErrorMessage.INVALID_ORDER;

import christmas.exception.EventPlannerException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Order {
    public static final int MAXIMUM_ORDER_COUNT = 20;
    private final List<OrderItem> orderItems;
    private int totalOrderAmount;

    private Order(final String orderItems) {
        this.orderItems = validate(orderItems);
    }

    public static Order of(final String orderItems) {
        return new Order(orderItems);
    }

    private List<OrderItem> validate(String orderItems) {
        List<OrderItem> validFormatMenu = validateFormat(orderItems);
        validateDuplicateDish(validFormatMenu);
        validateOrderAmount(validFormatMenu);
        validateOnlyBeverage(validFormatMenu);
        return validFormatMenu;
    }

    private List<OrderItem> validateFormat(String orderItems) {
        try {
            List<String> order = new ArrayList<>(Arrays.asList(orderItems.split(",")));

            return order.stream()
                    .map(OrderItem::of)
                    .toList();
        } catch (NumberFormatException e) {
            throw EventPlannerException.of(INVALID_ORDER);
        }
    }

    private void validateDuplicateDish(List<OrderItem> validFormatMenu) {
        if (!validFormatMenu.stream()
                .collect(Collectors.groupingBy(orderItem -> orderItem.getDish().getName(),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet())
                .isEmpty()) {
            throw EventPlannerException.of(INVALID_ORDER);
        }
    }

    private void validateOrderAmount(List<OrderItem> validFormatMenu) {
        int orderCount = validFormatMenu.stream()
                .mapToInt(OrderItem::getCount)
                .sum();
        if (orderCount > MAXIMUM_ORDER_COUNT) {
            throw EventPlannerException.of(INVALID_ORDER);
        }
    }

    private void validateOnlyBeverage(List<OrderItem> validFormatMenu) {
        boolean onlyBeverage = validFormatMenu.stream()
                .allMatch(orderItem -> orderItem.getDish().getCategory().equals(BEVERAGE));
        if (onlyBeverage) {
            throw EventPlannerException.of(INVALID_ORDER);
        }
    }

    public List<OrderItem> getOrderItems() {
        return Collections.unmodifiableList(this.orderItems);
    }

    public int getTotalOrderAmount() {
        return (int) orderItems.stream()
                .mapToDouble(orderItem ->
                        orderItem.getDish().getPrice() * orderItem.getCount())
                .sum();
    }
}