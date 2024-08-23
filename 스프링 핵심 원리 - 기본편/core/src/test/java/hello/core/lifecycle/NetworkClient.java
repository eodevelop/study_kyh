package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작 시 호출
    public void connect() {
        System.out.println("Connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + ", message = " + message);
    }

    // 서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }

    // 초기화, 소멸 인터페이스의 경우 단점이 있다.
    // 이 인터페이스들은 스프링 전용 인터페이스 이기에 이 기능을 사용하는 클래스들은 스프링에 의존 하고 있어야 한다
    // 초기화, 소멸 메소드의 이름도 변경 불가
    // 그리고 내가 변경할 수 없는 외부 라이브러리에 적용할 수 없다.
    // 현재는 잘 사용되지 않는 방식
//    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

//    @Override
    public void destroy() throws Exception {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }

    // Spring 에서 권장 하는 방식 해당 방식을 사용하면 된다.
    // 어노테이션만 붙이면 되서 편리하고, 스프링에 종속적인 기술이 아니라 자바 표준에 포함되어 있어서 다른 컨테이너에서도 동작한다.
    // 컴포넌트 스캔과도 잘 어울린다.
    @PostConstruct
    public void init() throws Exception {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() throws Exception {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
