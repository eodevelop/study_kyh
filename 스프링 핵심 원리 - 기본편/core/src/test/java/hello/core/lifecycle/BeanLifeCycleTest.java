package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifCycleConfig {

        @Bean //(initMethod = "init", destroyMethod = "close")
        // 속성방식의 장점은 코드가 아니라 설정 정보를 사용하기 때문에 외부라이브러리에도 초기화, 종료 메소드를 적용할 수 있다.
        // Bean 으로 사용할 때 destroyMethod 에는 특별한 기능이 하나 있다.
        // 이 기능은 기본 메소드의 Default 가 (inferred) 로 들어 있는데
        // 이때 클래스 안에 close, shutdown 과 같은 이름의 메소드가 있다면 자동으로 등록해서 종료해준다.
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            // 개발자는 의존 관계 주입의 완료 시점을 알 수 없다.
            // 그렇기에 스프링에서 콜백 메소드를 통해 초기화 시점을 알려준다.

            // 생성자에서 초기화를 하지 않는 이유는
            // 객체의 생성과 초기화는 분리하는게 좋기 떄문.
            // 이유는 단일책임 원칙과 같이 생성에만 집중하고
            // 초기화는 동작의 개념이기 때문에 값의 할당에만 집중하는것이기 때문.
            // 이렇게 나누면 유지 보수 관점에서 더 유리해지게 된다.
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
