package christmas.exception;

import christmas.exception.constants.ErrorMessage;

public class EventPlannerException extends IllegalArgumentException {
    private EventPlannerException(final ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static EventPlannerException of(final ErrorMessage errorMessage) {
        return new EventPlannerException(errorMessage);
    }
}
