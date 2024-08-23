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

        @Bean
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
