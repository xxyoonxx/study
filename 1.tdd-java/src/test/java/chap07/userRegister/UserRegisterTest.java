package chap07.userRegister;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRegisterTest {

    private UserRegister userRegister;
    private StubWeakPasswordChecker stubPasswordChecker = new StubWeakPasswordChecker();
    private MemoryUserRepository fakeRepository = new MemoryUserRepository();
    private SpyEmailNotifier spyEmailNotifier = new SpyEmailNotifier();

    @BeforeEach
    void setUp(){
        userRegister = new UserRegister(stubPasswordChecker, fakeRepository, spyEmailNotifier);
    }

    // 출처: https://giron.tistory.com/104

    /*
    // stub
    // stub: 단순 구현. 단순히 원하는 동작을 수행. 기능 구현은 안되어 있으며 상태 검증을 위한 객체
    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword(){
        stubPasswordChecker.setWeak(true);
        assertThrows(WeakPasswordException.class,
                ()-> {
                    userRegister.register("id","pw","email"); // 단순 상태 반환
                });
    }

    // fake 가짜
    // 인메모리DB. 디비가 처리하는 것처럼 로직 작성
    @DisplayName("같은 ID 존재 시 가입 실패")
    @Test
    void dupIdExists(){
        // 같은 ID 존재하는 상황 구현
        fakeRepository.save(new User("id","pw1","email@email.com")); // db처리 흉내

        assertThrows(DupIdException.class, ()->{
            userRegister.register("id","pw2","email");
        });
    }

    @DisplayName("같은 ID가 없으면 가입 성공")
    @Test
    void noDupId_RegisterSuccess(){
        userRegister.register("id","pw","email");

        User savedUser = fakeRepository.findById("id");
        assertEquals("id", savedUser.getId());
        assertEquals("email", savedUser.getEmail());
    }
    */

    // spy
    // 호출 내역 기록
    @DisplayName("가입하면 메일 전송")
    @Test
    void whenRegisterThenSendMail() {
        userRegister.register("id","pw","email@email.com");

        assertTrue(spyEmailNotifier.isCalled());
        assertEquals("email@email.com", spyEmailNotifier.getEmail());
    }

}