package chap07.userRegister;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserRegisterMockTest {

    private UserRegister userRegister;
    private WeakPasswordChecker mockPasswordChecker = Mockito.mock(WeakPasswordChecker.class);
    private MemoryUserRepository fakeRepository = new MemoryUserRepository();
    private EmailNotifier mockEmailNotifier = Mockito.mock(EmailNotifier.class);

    @BeforeEach
    void setUp(){
        userRegister = new UserRegister(mockPasswordChecker, fakeRepository, mockEmailNotifier);
    }

    // mock
    // 특정 동작을 수행하는지 확인하는 '행위검증'을 위한 객체
    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword(){
        // checkPasswordWeak("pw") 호출시 true return
        BDDMockito.given(mockPasswordChecker.checkPasswordWeak("pw")).willReturn(true);

        assertThrows(WeakPasswordException.class, ()-> {
           userRegister.register("id","pw","email");
        });
    }

    @DisplayName("회원가입시 암호검사 수행")
    @Test
    void checkPassword(){
        userRegister.register("id","pw","email");

        BDDMockito.then(mockPasswordChecker).should() // mockPasswordChecker 호출 검증
                .checkPasswordWeak(BDDMockito.anyString()); // checkPasswordWeak가 문자열을 return받는지 검증
    }

    @DisplayName("가입시 메일 전송")
    @Test
    void whenRegisterThenSendMail(){
        userRegister.register("id","pw","email@email.com");

        // String 타입의 인자를 캡처하는 객체 'captor' 생성
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        // sendRegisterEmail 메서드 호출 여부 확인 후 전달된 인자를 captor가 캡처
        BDDMockito.then(mockEmailNotifier)
                .should().sendRegisterEmail(captor.capture());

        // captor가 캡처한 값을 realEmail에 저장
        String realEmail = captor.getValue();
        assertEquals("email@email.com", realEmail);
    }

}
