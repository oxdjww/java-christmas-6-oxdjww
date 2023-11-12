package christmas.exception.constants;

public enum ErrorMessage {
    INVALID_DATE_MESSAGE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER("유효하지 않은 주문입니다.다시 입력해 주세요.");

    private final String message;
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MESSAGE_PREFIX + message;
    }
}
