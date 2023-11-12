package christmas.controller;

import static christmas.view.InputView.readDate;
import static christmas.view.InputView.readOrder;
import static christmas.view.OutputView.printMessage;
import static christmas.view.constants.ViewConstants.WELCOME_MESSAGE;

import christmas.domain.Date;
import christmas.domain.Order;

public class MainController {
    public void run() {
        printMessage(WELCOME_MESSAGE);

        Date date = Date.of(readDate());

        Order order = Order.of(readOrder());
    }
}
