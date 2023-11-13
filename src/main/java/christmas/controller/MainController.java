package christmas.controller;

import static christmas.view.InputView.readDate;
import static christmas.view.InputView.readOrder;
import static christmas.view.OutputView.printBadge;
import static christmas.view.OutputView.printBenefitForm;
import static christmas.view.OutputView.printBenefitNotice;
import static christmas.view.OutputView.printErrorMessage;
import static christmas.view.OutputView.printFinalPaymentAmount;
import static christmas.view.OutputView.printGift;
import static christmas.view.OutputView.printMessage;
import static christmas.view.OutputView.printOrder;
import static christmas.view.OutputView.printTotalBenefitAmount;
import static christmas.view.OutputView.printTotalOrderAmount;
import static christmas.view.constants.ViewConstants.WELCOME_MESSAGE;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.exception.EventPlannerException;
import christmas.service.DateService;
import christmas.service.OrderService;

public class MainController {
    private final OrderService orderService;
    private final DateService dateService;

    public MainController(OrderService orderService, DateService dateService) {
        this.orderService = orderService;
        this.dateService = dateService;
    }

    public void run() {
        printMessage(WELCOME_MESSAGE);

        Date date = generateDate();

        Order order = generateOrder(date);

        printBenefitNotice(date);

        printOrder(order);

        printTotalOrderAmount(order);

        printGift(order.getBenefitForm());

        printBenefitForm(order.getBenefitForm());

        printTotalBenefitAmount(order.getBenefitForm());

        printFinalPaymentAmount(order);

        printBadge(order);
    }

    private Date generateDate() {
        while (true) {
            try {
                return dateService.createDate(readDate());
            } catch (EventPlannerException e) {
                printErrorMessage(e);
            }
        }
    }

    private Order generateOrder(final Date date) {
        while (true) {
            try {
                return orderService.createOrder(readOrder(), date);
            } catch (EventPlannerException e) {
                printErrorMessage(e);
            }
        }
    }
}
