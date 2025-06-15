package cardValidator;

public class StubCardNumberValidator extends CardNumberValidator{

    private String invalidNo;

    // 임의로 테스트용 번호 지정
    public void setInvalidNo(String invalidNo){
        this.invalidNo = invalidNo;
    }

    private String theftNo;

    public void setTheftNo(String theftNo) {
        this.theftNo = theftNo;
    }

    @Override
    public CardValidity validate(String cardNumber){
        if(invalidNo != null && invalidNo.equals(cardNumber)) {
            return CardValidity.INVALID;
        }
        if(theftNo != null && theftNo.equals(cardNumber)){
            return CardValidity.THEFT;
        }
        return CardValidity.VALID;
    }

}
