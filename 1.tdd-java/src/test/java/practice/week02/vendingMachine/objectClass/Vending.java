package practice.week02.vendingMachine.objectClass;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Vending {

    // 에러코드로 처리해보기

    private int balance;
    private int insertedMoney;
    List<Drink> drinkList = new ArrayList<>();

    public Vending() {
        drinkList.addAll(List.of(
                new Drink("콜라",100,10),
                new Drink("사이다",80,10),
                new Drink("레모네이드",120,10),
                new Drink("물",50,10)
        ));
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance += balance;
    }

    public void receiveMoney(int money) {
        this.insertedMoney += money;
    }

    public void addDrink(Drink drink) {
        boolean flag = false;
        for(Drink drinkInfo : drinkList) {
            if(drink.getName().contains(drinkInfo.getName())) {
                int drinkSum = drink.getQuantity() + drinkInfo.getQuantity();
                drinkInfo.setQuantity(drinkSum);
                flag = true;
            }
        }
        if(!flag) drinkList.add(drink);
    }

    public List<Drink> getDrinkList(){
        return drinkList;
    }

    /**
     * 구매 가능한 음료 리스트
     * @param customer
     * @return
     */
    public List<Drink> getDrinkList(Customer customer) {
        try {
            int drinkSum = 0;
            for (Drink drinkInfo : drinkList) {
                drinkSum += drinkInfo.getQuantity();
            }
            if (drinkSum == 0) throw new RuntimeException("모든 음료가 품절입니다.");

            List<Drink> availableDrinks = new ArrayList<>();
            for (Drink drink : drinkList) {
                if (drink.getPrice() <= insertedMoney) availableDrinks.add(drink);
            }

            if (availableDrinks.isEmpty()) throw new RuntimeException("구매 가능한 음료가 없습니다.");

            System.out.println("구매 가능한 음료 리스트: " + availableDrinks.stream().map(Drink::getName).collect(Collectors.joining(", ")));

            return availableDrinks;
        } catch(RuntimeException e) {
            returnChange(customer);
            throw e;
        }
    }

    /**
     * 음료 선택
     * @param selectedDrink
     * @return
     */
    public Drink selectDrink(String selectedDrink, Customer customer) {
        try {
            Drink drinkInfo = findDrinkByName(selectedDrink);

            if (balance - drinkInfo.getPrice() < 0) {
                throw new RuntimeException("자판기 보유 현금이 부족합니다.");
            }

            if (insertedMoney < drinkInfo.getPrice()) {
                throw new RuntimeException("소지금액이 부족합니다.");
            }

            int quantity = drinkInfo.getQuantity();
            if (quantity > 0) {
                drinkInfo.setQuantity(quantity - 1);
                insertedMoney -= drinkInfo.getPrice();
                return drinkInfo;
            }

            throw new RuntimeException("재고가 부족합니다.");
        } finally {
            returnChange(customer);
        }
    }

    public Drink findDrinkByName(String drink){
        for(Drink drinkInfo : drinkList) {
            if (drink.equals(drinkInfo.getName())) return drinkInfo;
        }
        throw new RuntimeException("해당 음료는 판매하지 않습니다.");
    }

    /**
     * 잔돈 반환
     * @param customer
     * @return
     */
    public void returnChange(Customer customer){
        customer.setBalance(insertedMoney);
        insertedMoney = 0;
    }

}
