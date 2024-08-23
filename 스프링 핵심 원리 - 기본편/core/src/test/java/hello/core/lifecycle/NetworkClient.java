package hello.core.lifecycle;

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

    public void init() throws Exception {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    public void close() throws Exception {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
