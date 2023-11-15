package christmas.controller;

import static christmas.view.OutputView.printBadge;
import static christmas.view.OutputView.printBenefitForm;
import static christmas.view.OutputView.printBenefitNotice;
import static christmas.view.OutputView.printFinalPaymentAmount;
import static christmas.view.OutputView.printGift;
import static christmas.view.OutputView.printOrder;
import static christmas.view.OutputView.printTotalBenefitAmount;
import static christmas.view.OutputView.printTotalOrderAmount;

import christmas.domain.order.Date;
import christmas.domain.order.Order;
import christmas.domain.event.dto.BenefitDTO;
import christmas.service.EventService;

public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    public void showEventMessage(Date date) {
        printBenefitNotice(date);
    }

    public void showOrderBeforeEvent(Order order) {
        printOrderInfo(order);
    }

    private void printOrderInfo(Order order) {
        printOrder(order);

        printTotalOrderAmount(order);
    }

    public void showGiftDetails() {
        printGift(eventService.getFreeChampagneDiscountAmount());
    }

    public void showBenefitDetails(Order order) {
        printBenefitInfo(order);
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

}
