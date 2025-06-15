package practice.week02.vendingMachine.objectClass;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private int balance;

    private List<Drink> inventory;

    public Customer(int balance) {
        this.balance = balance;
        this.inventory = new ArrayList<>();
    }

    public void putMoney(Vending vending, int money){
        this.balance -= money;
        vending.receiveMoney(money);
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int money){
        this.balance += money;
    }

    public List<Drink> getInventory() {
        return inventory;
    }

    public Drink selectDrink(Vending vending, String drink) {
        Drink drinkInfo = vending.selectDrink(drink, this);
        inventory.add(drinkInfo);
        return drinkInfo;
    }

}
