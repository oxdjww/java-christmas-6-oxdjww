package christmas.view;

import christmas.domain.Order;
import christmas.domain.OrderItem;
import christmas.view.constants.ViewConstants;
import java.util.List;

public class OutputView {
    public static void printMessage(final ViewConstants vc) {
        System.out.println(vc.getMessage());
    }

    public static void printErrorMessage(final Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printOrder(final Order order) {
        System.out.println("<주문 메뉴>");
        List<OrderItem> orderItems = order.getOrderItems();

        for (OrderItem orderItem : orderItems) {
            String formattedLine = String.format("%s %d개",
                    orderItem.getDish().getName(),
                    orderItem.getCount());

            System.out.println(formattedLine);
        }
    }
}