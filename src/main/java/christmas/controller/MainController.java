package christmas.controller;

import static christmas.view.InputView.readDate;
import static christmas.view.InputView.readOrder;
import static christmas.view.OutputView.printErrorMessage;
import static christmas.view.OutputView.printMessage;
import static christmas.view.OutputView.printOrder;
import static christmas.view.constants.ViewConstants.WELCOME_MESSAGE;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.exception.EventPlannerException;
import christmas.service.OrderService;

public class MainController {
    OrderService orderService = new OrderService();

    public void run() {
        printMessage(WELCOME_MESSAGE);

        Date date = generateDate();

        Order order = generateOrder();

        printOrder(order);
    }

    private Date generateDate() {
        while (true) {
            try {
                return Date.of(readDate());
            } catch (EventPlannerException e) {
                printErrorMessage(e);
            }
        }
    }

    private Order generateOrder() {
        while (true) {
            try {
                return orderService.createOrder(readOrder());
            } catch (EventPlannerException e) {
                printErrorMessage(e);
            }
        }
    }
}
