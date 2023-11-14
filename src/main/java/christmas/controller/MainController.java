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
import christmas.domain.event.dto.BenefitDTO;
import christmas.exception.EventPlannerException;
import christmas.service.DateService;
import christmas.service.EventService;
import christmas.service.OrderService;

public class MainController {
    private final OrderService orderService;
    private final DateService dateService;
    private final EventService eventService;

    public MainController(OrderService orderService, DateService dateService, EventService eventService) {
        this.orderService = orderService;
        this.dateService = dateService;
        this.eventService = eventService;
    }

    public void run() {
        printMessage(WELCOME_MESSAGE);

        Date date = generateDate();

        Order order = generateOrder(date);

        eventService.setEvent(order);

        printGift(eventService.getFreeChampagneDiscountAmount());

        printBenefitNotice(date);

        printOrderInfo(order);

        printBenefitInfo(order);
    }

    private static void printOrderInfo(Order order) {
        printOrder(order);

        printTotalOrderAmount(order);
    }

    private void printBenefitInfo(Order order) {
        printBenefitForm(eventService.getTotalBenefitAmount(), new BenefitDTO(
                eventService.getDDayDiscountAmount(), eventService.getSpecialDiscountAmount(),
                eventService.getWeekDayDiscountAmount(), eventService.getWeekendDiscountAmount(),
                eventService.getFreeChampagneDiscountAmount()));

        printTotalBenefitAmount(eventService.getTotalBenefitAmount());

        printFinalPaymentAmount(order.getTotalOrderAmount(), eventService.getTotalDiscountAmount());

        printBadge(eventService.getTotalBenefitAmount());
    }

    private Date generateDate() {
        try {
            return dateService.createDate(readDate());
        } catch (EventPlannerException e) {
            printErrorMessage(e);
            return generateDate();
        }
    }

    private Order generateOrder(final Date date) {
        try {
            return orderService.createOrder(readOrder(), date);
        } catch (EventPlannerException e) {
            printErrorMessage(e);
            return generateOrder(date);
        }
    }
}
