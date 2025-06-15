package practice.week01.StringCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    /*
    1. 구분자를 기준으로 숫자를 분리한 뒤 숫자들의 합을 구한다.
    2. 입력 문자열 앞부분에 '//'와 '\n' 사이에 문자가 위치하면 커스텀 구분자로 사용한다.
    3. 커스텀 구분자가 없으면 ','과':'를 구분자로 사용한다. (기본 구분자)
    4. 숫자 이외의 값이 입력되면 RuntimeException을 throw 한다.
    5. 음수가 전달되면 RuntimeException을 throw 한다.
    6. 빈 문자열 또는 null이 입력되면 0을 반환한다.
    7. 숫자 하나만 입력되면 해당 숫자를 반환한다.
     */

    private StringCalculator calculator;

    @BeforeEach
    void setUp(){
        // 매 Test시작 전 새로운 인스턴스를 생성하여 테스트에 서로 영향을 주지 않는 테스트 격리(Test Isolation) 보장
        calculator = new StringCalculator();
    }

    // String을 array로 바로 담아서
    // 정규식 확인. 소수도 포함해서 체크해보기
    // MaxInteger 처리
    
    // 7. 숫자 하나만 입력되면 해당 숫자를 반환
    @Test
    void getOnlyNumber() {
        assertAll(
                () -> assertEquals(3,calculator.returnNum("3")),
                () -> assertEquals(4, calculator.returnNum("4"))
        );
    }

    // 3. 커스텀 구분자가 없으면 ','과':'를 구분자로 사용한다. (기본 구분자)
    @Test
    void getSplitNumber() {
        assertAll(
                () -> assertEquals(5, calculator.returnNum("3:2")),
                () -> assertEquals(6, calculator.returnNum("3,3")),
                () -> assertEquals(9, calculator.returnNum("3:3,3"))
        );
    }

    // 6. 빈 문자열 또는 null이 입력되면 0을 반환한다.
    @Test
    void getZero(){
        assertAll(
                ()->assertEquals(0,calculator.returnNum(null)),
                ()->assertEquals(0,calculator.returnNum(""))
        );
    }

    // 5. 음수가 전달되면 RuntimeException을 throw 한다.
    // 4. 숫자 이외의 값이 입력되면 RuntimeException을 throw 한다.
    @Test
    void getRuntimeExceptionByNegative(){
        // assertThrows: 발생한 Exception객체를 return
        assertThrows(RuntimeException.class,()->{calculator.returnNum("-1");});
        assertThrows(RuntimeException.class, ()->{ calculator.returnNum("*1*2*3");});
    }

    // 2. 입력 문자열 앞부분에 '//'와 '\n' 사이에 문자가 위치하면 커스텀 구분자로 사용한다.
    @Test
    void getCustomedSplitedNumber(){
        assertAll(
                ()-> assertEquals(6,calculator.returnNum("//*\n1*2*3")),
                ()-> assertEquals(7,calculator.returnNum("//)\n2)2)3"))
        );
    }

    // 규칙 외. 구분자가 다를 때, 소수일 때
    @Test
    void getRuntimeExceptionByStr() {
        assertThrows(RuntimeException.class, () -> calculator.returnNum("//:\n1;2;3")); // 처리 필요
        assertThrows(RuntimeException.class, ()->calculator.returnNum("1.23"));
        assertThrows(RuntimeException.class, ()->calculator.returnNum("abc"));
    }

}
