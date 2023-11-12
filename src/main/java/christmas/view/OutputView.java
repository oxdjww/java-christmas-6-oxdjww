package christmas.view;

import christmas.view.constants.ViewConstants;

public class OutputView {
    public static void printMenu() {
        System.out.println("<주문 메뉴>");
        // ...
    }
    public static void printMessage(final ViewConstants vc) {
        System.out.println(vc.getMessage());
    }

    public static void printErrorMessage(final Exception e) {
        System.out.println(e.getMessage());
    }
}