package christmas.view;

import static christmas.view.OutputView.printMessage;
import static christmas.view.constants.ViewConstants.READ_DATE_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getDate() {
        printMessage(READ_DATE_MESSAGE);
        return Console.readLine();
    }
}