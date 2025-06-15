package chap02.password;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {

    private PasswordStrengthMeter meter = new PasswordStrengthMeter();
    // 공통코드 메서드화
    private void assertStrength(String password, PasswordStrength expStr) {
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }

    @Test
    void name(){ }

    // 결과값부터 작성 > 결과값을 가진 메서드 작성(최소한의 코드만으로 작성)

    // 1. 모든 조건 충족
    @Test
    void meetsAllCriteria_Then_Strong(){
/*
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@AB");
        assertEquals(PasswordStrength.STRONG, result);
        PasswordStrength result2 = meter.meter("ab1!!Add");
        assertEquals(PasswordStrength.STRONG, result2);
*/
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
        assertStrength("ab1!!Add", PasswordStrength.STRONG);
    }

/*
    // 2. 길이만 부족(NORMAL)
    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal(){
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab!@AB");
        assertEquals(PasswordStrength.NORMAL, result);
        PasswordStrength result2 = meter.meter("axd!@Dd");
        assertEquals(PasswordStrength.NORMAL, result);
        assertStrength("ab!@AB", PasswordStrength.NORMAL);
        assertStrength("axd!@Dd", PasswordStrength.NORMAL);
    }
*/

    // 3. 숫자만 미포함
    @Test
    void meetsOtherCriteria_except_for_number_Then_Normal() {
/*
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab!@ABqwer");
        assertEquals(PasswordStrength.NORMAL, result);
*/
        assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
    }

    // 4. 값이 없는 경우
    @Test
    void NullInput_Then_Invalid(){
        assertStrength(null, PasswordStrength.INVALID);
    }
    @Test
    void emptyInput_Then_Invalid(){
        assertStrength("",PasswordStrength.INVALID);
    }

    // 5. 대문자가 없는 경우
    @Test
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal() {
        assertStrength("ab12!@df", PasswordStrength.NORMAL);
    }

    // 6. 길이만 충족
    @Test
    void meetsOnlyLengthCriteria_Then_Weak(){
        assertStrength("absdfzxc", PasswordStrength.WEAK);
    }

    // 7. 숫자만 충족
    @Test
    void meetsOnlyNumCriteria_Then_Weak(){
        assertStrength("12345", PasswordStrength.WEAK);
    }

    // 8. 대문자만 충족
    @Test
    void meetsOnlyUpperCriteria_Then_Weak() {
        assertStrength("ABZEF", PasswordStrength.WEAK);
    }

    // 9. 모두 미충족
    @Test
    void meetsNoCriteria_Then_Weak() {
        assertStrength("abc", PasswordStrength.WEAK);
    }

}
