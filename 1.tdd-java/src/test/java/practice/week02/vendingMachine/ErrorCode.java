package practice.week02.vendingMachine;

public enum ErrorCode {
    No_ALL_Stock("모든 음료가 품절입니다."),
    NO_STOCK("현재 품절입니다."),
    CUSTOMER_NO_MONEY("소지금이 부족합니다."),
    VENDING_NO_MONEY("자판기의 잔고가 부족합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
