package christmas.controller;

import static christmas.view.InputView.getDate;
import static christmas.view.OutputView.printMessage;
import static christmas.view.constants.ViewConstants.WELCOME_MESSAGE;

import christmas.domain.Date;

public class MainController {
    void run() {
        printMessage(WELCOME_MESSAGE);
        Date date = Date.of(getDate());
    }
}
