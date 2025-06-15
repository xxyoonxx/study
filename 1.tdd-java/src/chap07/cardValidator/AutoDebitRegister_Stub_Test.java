package cardValidator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AutoDebitRegister_Stub_Test {

    private AutoDebitRegister register;
    private StubCardNumberValidator stubValidator;
    private StubAutoDebitInfoRepository stubRepository;

    @BeforeEach
    void setUp(){
        stubValidator = new StubCardNumberValidator();
        stubRepository = new StubAutoDebitInfoRepository();
        register = new AutoDebitRegister(stubValidator, stubRepository);
    }

    @Test
    void invalidCard(){
        stubValidator.setInvalidNo("111122223333"); // 임의의 사용불가한 카드번호 생성

        AutoDebitReq req = new AutoDebitReq("user1","111122223333"); // 테스트할 사용자와 카드번호 생성
        RegisterResult result = register.register(req); // 검증. 아마 setValidity가 있을 것임

        assertEquals(INVALID, result.getValidity());
    }

}
