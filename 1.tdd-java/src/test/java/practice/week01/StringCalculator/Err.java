package practice.week01.StringCalculator;

public enum Err {

    NOT_SEPERATOR("구분자가 다릅니다.")
    , IS_DOUBLE("정수만 사용할 수 있습니다.");

    String msg;

    Err(String msg) {
        this.msg = msg;
    }

    public String getMessage(){
        return msg;
    }

}
