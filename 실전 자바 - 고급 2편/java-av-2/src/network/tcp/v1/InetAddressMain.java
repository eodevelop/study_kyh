package network.tcp.v1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress localhost = InetAddress.getByName("localhost");
        System.out.println("localhost = " + localhost);

        InetAddress google = InetAddress.getByName("google.com");
        System.out.println("google = " + google); // 구글은 그때그때 결과가 다를수도 있다.(위치, 지역에 따라서도 다를 수 있음)
        // InetAddress 클래스를 사용하면 호스트 이름으로 대상 IP를 찾을 수 있다.
    }
}
