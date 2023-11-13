package christmas.view.constants;

public enum ViewConstants {
    READ_DATE_MESSAGE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    WELCOME_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    GET_ORDER_MESSAGE("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    ORDER_MESSAGE("<주문 메뉴>"),
    TOTAL_ORDER_AMOUNT_MESSAGE("<할인 전 총주문 금액>"),
    BENEFIT_NOTICE_MESSAGE("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!%n"),
    GIFT_NOTICE_MESSAGE("<증정 메뉴>"),
    BENEFIT_FORM_MESSAGE("<혜택 내역>"),
    TOTAL_BENEFIT_AMOUNT_MESSAGE("<총혜택 금액>"),
    FINAL_PAYMENT_AMOUNT_MESSAGE("<할인 후 예상 결제 금액>"),
    BADGE_NOTICE_MESSAGE("<12월 이벤트 배지>"),
    NOTHING_MESSAGE("없음");


    private final String message;

    ViewConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
