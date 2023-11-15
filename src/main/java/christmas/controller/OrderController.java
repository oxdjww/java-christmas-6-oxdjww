package christmas.controller;

import static christmas.view.InputView.readDate;
import static christmas.view.OutputView.printErrorMessage;
import static christmas.view.OutputView.printMessage;
import static christmas.view.constants.ViewConstants.WELCOME_MESSAGE;

import christmas.domain.order.Date;
import christmas.domain.order.Order;
import christmas.exception.EventPlannerException;
import christmas.service.OrderService;
import christmas.view.InputView;

public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void showGreetingMessage() {
        printMessage(WELCOME_MESSAGE);
    }

    public Date createDate() {
        try {
            return Date.of(readDate());
        } catch (EventPlannerException e) {
            printErrorMessage(e);
            return createDate();
        }
    }

    public Order createOrder(Date date) {
        try {
            return orderService.createOrder(InputView.readOrder(), date);
        } catch (EventPlannerException e) {
            printErrorMessage(e);
            return createOrder(date);
        }
    }

    public void showOrder() {

    }
}
