package christmas.domain;

import static christmas.exception.constants.ErrorMessage.INVALID_ORDER;

import christmas.domain.constants.Category;
import christmas.domain.dish.Dish;
import christmas.domain.dish.DishGenerator;
import christmas.exception.EventPlannerException;

public class OrderItem {
    private final Dish dish;
    private final int count;

    private OrderItem(final String order) {
        String[] orderItemPair = order.split("-");
        try {
            String orderItemName = orderItemPair[0].trim();
            String orderItemCount = orderItemPair[1].trim();

            validateFormat(orderItemPair);

            validateCount(orderItemCount);

            this.dish = DishGenerator.of(orderItemName);
            this.count = Integer.parseInt(orderItemCount);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw EventPlannerException.of(INVALID_ORDER);
        }

    }

    public static OrderItem of(final String order) {
        return new OrderItem(order);
    }

    private static void validateFormat(final String[] orderItemPair) {
        // "-"가 한개인지. 즉, 유효한 형식인지 검증
        if (orderItemPair.length != 2) {
            throw EventPlannerException.of(INVALID_ORDER);
        }
    }

    private static void validateCount(final String orderItemCount) {
        // 주문 개수가 1개 이상인지 검증
        try {
            if (Integer.parseInt(orderItemCount) <= 0) {
                throw EventPlannerException.of(INVALID_ORDER);
            }
        } catch (NumberFormatException e) {
            // 정수가 아닐 경우 대비
            throw EventPlannerException.of(INVALID_ORDER);
        }
    }

    public Dish getDish() {
        return this.dish;
    }

    public int getCount() {
        return count;
    }

    public Category getDishCategory() {
        return this.dish.getCategory();
    }
}
