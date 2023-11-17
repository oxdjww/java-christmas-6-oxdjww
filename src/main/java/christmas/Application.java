package christmas;

import christmas.controller.EventController;
import christmas.controller.OrderController;
import christmas.domain.order.Date;
import christmas.domain.order.Order;
import christmas.service.EventService;
import christmas.service.OrderService;

public class Application {
    public static void main(String[] args) {
        OrderController orderController = new OrderController(new OrderService());

        orderController.showGreetingMessage();

        Date date = orderController.createDate();
        Order order = orderController.createOrder(date);

        EventController eventController = new EventController(new EventService(order));

        eventController.showEventMessage(date);
        eventController.showOrderBeforeEvent(order);
        eventController.showGiftDetails();
        eventController.showBenefitDetails(order);
    }
}
