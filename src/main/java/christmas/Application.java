package christmas;

import christmas.controller.MainController;
import christmas.service.DateService;
import christmas.service.EventService;
import christmas.service.OrderService;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController(new OrderService(), new DateService(), new EventService());
        mainController.run();
    }
}
