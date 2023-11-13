package christmas.view;

import static christmas.domain.constants.Menu.샴페인;

import christmas.discount.BenefitForm;
import christmas.domain.Date;
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

    public static void printNewLine() {
        System.out.println();
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
        printNewLine();
    }

    public static void printTotalOrderAmount(final Order order) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(formatNumberWithComma(order.getTotalOrderAmount()) + "원");
        printNewLine();
    }

    public static String formatNumberWithComma(int number) {
        String numberStr = String.valueOf(number);
        int length = numberStr.length();

        StringBuilder formattedNumber = new StringBuilder();

        for (int i = 0; i < length; i++) {
            formattedNumber.append(numberStr.charAt(i));

            int remainingDigits = length - i - 1;
            if (remainingDigits > 0 && remainingDigits % 3 == 0) {
                formattedNumber.append(',');
            }
        }

        return formattedNumber.toString();
    }

    public static void printBenefitNotice(final Date date) {
        System.out.printf(
                "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!%n",
                date.getDate()
        );
        printNewLine();
    }

    public static void printGift(final BenefitForm benefitForm) {
        System.out.println("<증정 메뉴>");

        if (benefitForm.getFreeChampagneDiscountAmount() == 샴페인.getPrice()) {
            System.out.println(샴페인.name() + " 1개");
        }

        if (benefitForm.getFreeChampagneDiscountAmount() == 0) {
            System.out.println("없음");
        }
        printNewLine();
    }

    public static void printBenefitForm(final BenefitForm benefitForm) {
        System.out.println("<혜택 내역>");

        if (benefitForm.getDDayDiscountAmount() == 0 &&
                benefitForm.getWeekDayDiscountAmount() == 0 &&
                benefitForm.getSpecialDiscountAmount() == 0 &&
                benefitForm.getWeekendDiscountAmount() == 0 &&
                benefitForm.getFreeChampagneDiscountAmount() == 0) {
            System.out.println("없음");
            printNewLine();
            return;
        }

        StringBuilder formattedDiscounts = new StringBuilder();

        if (benefitForm.getDDayDiscountAmount() > 0) {
            formattedDiscounts.append(String.format("크리스마스 디데이 할인: %s원\n", formatNumberWithComma(Math.negateExact(benefitForm.getDDayDiscountAmount()))));
        }
        if (benefitForm.getWeekDayDiscountAmount() > 0) {
            formattedDiscounts.append(String.format("평일 할인: %s원\n", formatNumberWithComma(Math.negateExact(benefitForm.getWeekDayDiscountAmount()))));
        }
        if (benefitForm.getSpecialDiscountAmount() > 0) {
            formattedDiscounts.append(String.format("특별 할인: %s원\n", formatNumberWithComma(Math.negateExact(benefitForm.getSpecialDiscountAmount()))));
        }
        if (benefitForm.getWeekendDiscountAmount() > 0) {
            formattedDiscounts.append(String.format("주말 할인: %s원\n", formatNumberWithComma(Math.negateExact(benefitForm.getWeekendDiscountAmount()))));
        }
        if (benefitForm.getFreeChampagneDiscountAmount() > 0) {
            formattedDiscounts.append(String.format("증정 이벤트: %s원\n", formatNumberWithComma(Math.negateExact(benefitForm.getFreeChampagneDiscountAmount()))));
        }

        System.out.println(formattedDiscounts);
        printNewLine();
    }

}