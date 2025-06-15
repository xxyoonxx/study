package practice.week02.vendingMachine;

public class VendingException extends Exception {

    public String message;

    public VendingException(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
