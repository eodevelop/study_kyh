package network.tcp.v1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static util.MyLogger.log;

public class ClientV1 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");
        Socket socket = new Socket("localhost", PORT); // 클라이언트의 포트는 보통 지정하지 않는다.
        // 보통 연결하려면 클라이언트와 서버 양측모두 포트를 지정해주어야 한다.
        // 클라이언트의 포트를 지정하지 않으면 남는 포트중 하나를 할당해준다.

        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        log("소켓 연결: " + socket);

        // 서버에게 문자 보내기
        String toSend = "Hello";
        output.writeUTF(toSend);
        log("client -> server: " + toSend);

        // 서버로 부터 문자 받기
        String received = input.readUTF();
        log("client <- server: " + received);

        //자원 정리
        log("연결 종료 : " + socket);
        input.close();
        output.close();
        socket.close();
    }
}
