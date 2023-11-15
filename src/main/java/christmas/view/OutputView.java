package christmas.view;

import static christmas.domain.constants.Badge.별;
import static christmas.domain.constants.Badge.산타;
import static christmas.domain.constants.Badge.트리;
import static christmas.domain.constants.Menu.샴페인;
import static christmas.view.constants.ViewConstants.BADGE_NOTICE_MESSAGE;
import static christmas.view.constants.ViewConstants.BENEFIT_FORM_MESSAGE;
import static christmas.view.constants.ViewConstants.BENEFIT_NOTICE_MESSAGE;
import static christmas.view.constants.ViewConstants.FINAL_PAYMENT_AMOUNT_MESSAGE;
import static christmas.view.constants.ViewConstants.GIFT_NOTICE_MESSAGE;
import static christmas.view.constants.ViewConstants.NOTHING_MESSAGE;
import static christmas.view.constants.ViewConstants.ORDER_MESSAGE;
import static christmas.view.constants.ViewConstants.TOTAL_BENEFIT_AMOUNT_MESSAGE;
import static christmas.view.constants.ViewConstants.TOTAL_ORDER_AMOUNT_MESSAGE;

import christmas.domain.order.Date;
import christmas.domain.order.Order;
import christmas.domain.order.OrderItem;
import christmas.domain.event.dto.BenefitDTO;
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
        printMessage(ORDER_MESSAGE);

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
        printMessage(TOTAL_ORDER_AMOUNT_MESSAGE);

        System.out.println(formatNumberWithComma(order.getTotalOrderAmount()) + "원");
        printNewLine();
    }

    public static String formatNumberWithComma(final int number) {
        String numberStr = String.valueOf(number);
        int length = numberStr.length();

        StringBuilder formattedNumber = new StringBuilder();

        for (int i = 0; i < length; i++) {
            formattedNumber.append(numberStr.charAt(i));
            if ((length - i - 1) % 3 == 0 && i < length - 1) {
                formattedNumber.append(',');
            }
        }

        return formattedNumber.toString();
    }

    public static void printBenefitNotice(final Date date) {
        System.out.printf(
                BENEFIT_NOTICE_MESSAGE.getMessage(),
                date.getDate()
        );
        printNewLine();
    }

    public static void printGift(final int freeChampagneDiscountAmount) {
        printMessage(GIFT_NOTICE_MESSAGE);

        if (freeChampagneDiscountAmount == 샴페인.getPrice()) {
            System.out.println(샴페인.name() + " 1개");
        }

        if (freeChampagneDiscountAmount == 0) {
            printNothing();
        }
        printNewLine();
    }

    public static void printBenefitForm(final int totalBenefitAmount, final BenefitDTO benefitDTO) {
        printMessage(BENEFIT_FORM_MESSAGE);

        if (totalBenefitAmount == 0) {
            printNothing();
            printNewLine();
            return;
        }

        StringBuilder formattedDiscounts = generateBenefitForm(benefitDTO);

        System.out.println(formattedDiscounts);
    }

    private static StringBuilder generateBenefitForm(final BenefitDTO benefitDTO) {
        StringBuilder formattedDiscounts = new StringBuilder();

        appendDiscount(formattedDiscounts, "크리스마스 디데이 할인", benefitDTO.dDayDiscountAmount());
        appendDiscount(formattedDiscounts, "특별 할인", benefitDTO.specialDiscountAmount());
        appendDiscount(formattedDiscounts, "평일 할인", benefitDTO.weekDayDiscountAmount());
        appendDiscount(formattedDiscounts, "주말 할인", benefitDTO.weekendDiscountAmount());
        appendDiscount(formattedDiscounts, "증정 이벤트", benefitDTO.freeChampagneDiscountAmount());

        return formattedDiscounts;
    }

    private static void appendDiscount(final StringBuilder stringBuilder, final String label,
                                       final int discountAmount) {
        if (discountAmount > 0) {
            stringBuilder.append(
                    String.format("%s: %s원\n", label, formatNumberWithComma(Math.negateExact(discountAmount))));
        }
    }

    public static void printTotalBenefitAmount(final int totalBenefitAmount) {
        printMessage(TOTAL_BENEFIT_AMOUNT_MESSAGE);
        System.out.println(
                String.format("%s원\n", formatNumberWithComma(Math.negateExact(totalBenefitAmount))));
    }

    public static void printFinalPaymentAmount(final int totalOrderAmount, final int totalDiscountAmount) {
        printMessage(FINAL_PAYMENT_AMOUNT_MESSAGE);
        System.out.println(String.format("%s원\n",
                formatNumberWithComma(totalOrderAmount - totalDiscountAmount)));
    }

    public static void printBadge(final int totalBenefitAmount) {
        printMessage(BADGE_NOTICE_MESSAGE);
        if (totalBenefitAmount < 별.getBenefitAmout()) {
            printNothing();
            return;
        }
        printBadgeIfAmountIsHigher(totalBenefitAmount);
    }

    private static void printBadgeIfAmountIsHigher(final int totalBenefitAmount) {
        if (totalBenefitAmount > 산타.getBenefitAmout()) {
            System.out.println(산타.name());
            return;
        }
        if (totalBenefitAmount > 트리.getBenefitAmout()) {
            System.out.println(트리.name());
            return;
        }
        if (totalBenefitAmount > 별.getBenefitAmout()) {
            System.out.println(별.name());
            return;
        }
    }


    private static void printNothing() {
        printMessage(NOTHING_MESSAGE);
    }
}