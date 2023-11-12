package christmas.controller;

import static christmas.view.OutputView.printMessage;
import static christmas.view.constants.ViewConstants.WELCOME_MESSAGE;

public class MainController {
    void run() {
        printMessage(WELCOME_MESSAGE);
    }
}
