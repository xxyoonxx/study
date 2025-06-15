package practice.week02.vendingMachine.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.week02.vendingMachine.objectClass.Customer;
import practice.week02.vendingMachine.objectClass.Drink;
import practice.week02.vendingMachine.objectClass.Vending;

import static org.junit.jupiter.api.Assertions.*;

public class VendingTest {

    private Customer customer;
    private Vending vending;

    // 음료를 DB에서 가져오는 대역으로 써보기
    // 메서드 이름 바꿔보기(DDD 참고)

    @BeforeEach
    void setUp(){
        customer = new Customer(1000);
        vending = new Vending();
    }

    @DisplayName("손님은 돈을 자판기에 넣을 수 있다.")
    @Test
    void putMoney(){
        customer.putMoney(vending,1000);
        assertEquals(0,customer.getBalance());
    }

    @DisplayName("자판기 관리자는 자판기에 현금을 공급 할 수 있다.")
    @Test
    void getVendingBalance(){
        vending.setBalance(1000);
        assertEquals(1000,vending.getBalance());
    }

    @DisplayName("음료 객체 생성")
    @Test
    void setDrink(){
        Drink cola = new Drink("콜라",100,10);
        assertEquals("콜라", cola.getName());
        assertEquals(100, cola.getPrice());
        assertEquals(10, cola.getQuantity());
    }

    @DisplayName("자판기 관리자는 자판기에 음료를 공급 할 수 있다.")
    @Test
    void addDrink(){
        Drink cola = new Drink("콜라",100,10);
        Drink soda = new Drink("사이다",50,20);
        vending.addDrink(cola);
        vending.addDrink(soda);
        assertEquals(4,vending.getDrinkList().size());
        assertEquals("사이다", vending.getDrinkList().get(1).getName());
    }

    @DisplayName("모든 음료 품절")
    @Test
    void noDrinks(){
        for(Drink drink : vending.getDrinkList()){
            drink.setQuantity(0);
        }
        String message = "모든 음료가 품절입니다.";
        RuntimeException exception = assertThrows(RuntimeException.class, ()->vending.getDrinkList(customer));
        assertEquals(message, exception.getMessage());
    }

    @DisplayName("자판기는 손님이 살 수 있는 음료들을 리스트업 할 수 있다.")
    @Test
    void getDrinkList(){
        customer.putMoney(vending,80);
        vending.setBalance(1000);
        assertEquals("사이다", vending.getDrinkList(customer).get(0).getName());
    }

    // 두개 케이스 나누기
    @DisplayName("손님의 돈이 부족, 판매하지 않는 음료 선택")
    @Test
    void customerNoMoney(){
        vending.setBalance(1000);
        customer.putMoney(vending,80);
        Drink cola = new Drink("콜라",100,10);
        vending.addDrink(cola);
        RuntimeException exception = assertThrows(RuntimeException.class,()->customer.selectDrink(vending, "콜라"));
        assertEquals("소지금액이 부족합니다.",exception.getMessage());
        exception = assertThrows(RuntimeException.class, ()->customer.selectDrink(vending, "오렌지주스"));
        assertEquals("해당 음료는 판매하지 않습니다.",exception.getMessage());
    }

    @DisplayName("자판기는 손님이 고른 음료를 제공 할 수 있다.")
    @Test
    void provideDrink() {
        vending.setBalance(1000);
        customer.putMoney(vending,100);
        assertEquals(9, customer.selectDrink(vending, "콜라").getQuantity());
    }

    @DisplayName("가진 돈으로 뽑을 수 있는 음료가 없으면 잔돈 반환")
    @Test
    void returnChange(){
        vending.setBalance(1000);
        customer.putMoney(vending, 30);
        assertThrows(RuntimeException.class, ()->vending.getDrinkList(customer));
        assertEquals(1000, customer.getBalance());
    }

    @DisplayName("자판기의 보유 현금이 부족해 잔돈 반환")
    @Test
    void returnChangeByNoMoney(){
        vending.setBalance(80);
        customer.putMoney(vending, 1000);
        RuntimeException exception = assertThrows(RuntimeException.class, ()->customer.selectDrink(vending, "콜라"));
        assertEquals("자판기 보유 현금이 부족합니다.", exception.getMessage());
    }

    @DisplayName("음료 구매")
    @Test
    void buyDrinks(){
        vending.setBalance(1000);
        customer.putMoney(vending, 100);
        customer.selectDrink(vending, "물");
        assertAll(
                ()->assertEquals(950, customer.getBalance()),
                ()->assertEquals("물",customer.getInventory().get(0).getName())
        );
    }

    // assertJ 써보기
    
}
