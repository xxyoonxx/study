# 자판기 도메인
우리가 관리할 자판기는 음료 자판기다.
음료 자판기에는 콜라, 사이다, 레몬에이드, 물 4가지 종류 음료를 판매하고 있다.
자판기 관리자가 주기적으로 자판기에 음료 및 현금을 공급한다.
소비자가 자판기에 돈을 넣으면 뽑을 수 있는 음료 버튼에 불이 들어오고 원하는 음료의 버튼을 눌러 음료를 뽑을 수 있다.
만일 뽑을 수 있는 음료가 없으면 돈을 반환한다. 자판기가 보유하고 있는 현금이 부족해 소비자에게 잔돈을 돌려줄 수 없는 경우에도 음료를 판매할 수 없다.

# 1. Customer.java
- getBalance: 손님은 잔돈을 받을 수 있다.
- setBalance: 손님은 돈을 자판기에 넣을 수 있다.

- selectDrink: 손님은 자판기에서 음료를 선택할 수 있다.
- getDrink: 손님은 음료를 받을 수 있다.

## 예외
- 음료 > 가진 돈
- 음료 품절
- 없는 음료 선택

# 2. Manager.java
setDrink: 자판기 관리자는 자판기에 음료를 공급 할 수 있다.
setMoney: 자판기 관리자는 자판기에 현금을 공급 할 수 있다.

# 3. Vending.java
provideDrink: 자판기는 손님이 고른 음료를 제공 할 수 있다.
returnChange: 자판기는 잔돈을 반환할 수 있다.
getList: 자판기는 손님이 살 수 있는 음료들을 리스트업 할 수 있다.

# 4. Drink.java
addDrink: 음료를 추가 할 수 있다.

## 예외
- 잔돈이 부족
- 손님이 고른 음료가 품절
- 모든 재고가 품절

# 5. Drink.java
이름, 수량, 가격

## References
[자판기 시뮬레이션](https://github.com/sogoagain/tdd-exercises/tree/master/05-VendingMachine)