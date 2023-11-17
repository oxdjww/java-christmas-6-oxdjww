package christmas.view;

import static christmas.view.OutputView.printMessage;
import static christmas.view.constants.ViewConstants.GET_ORDER_MESSAGE;
import static christmas.view.constants.ViewConstants.READ_DATE_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readDate() {
        printMessage(READ_DATE_MESSAGE);
        return Console.readLine();
    }

    public static String readOrder() {
        printMessage(GET_ORDER_MESSAGE);
        return Console.readLine();
    }

}