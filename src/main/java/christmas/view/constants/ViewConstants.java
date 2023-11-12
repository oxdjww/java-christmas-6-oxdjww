package christmas.view.constants;

public enum ViewConstants {
    READ_DATE_MESSAGE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    WELCOME_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");

    private final String message;

    ViewConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
