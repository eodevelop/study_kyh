package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/hello.dat", true);
        // 파일이 없으면 다시 만들지만 그게 아니라면 덮어쓴다.
        // 두번째 매개변수로 true를 추가하면 append 방식으로 이어서 쓰게된다.

        fos.write(65);
        fos.write(66);
        fos.write(67);

        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");

        int data;
        // byte로 저장했지만 int로 반환한다.
        // 자바에서 byte는 EOF를 위한 특별한 값을 할당하기 어려워 지지만, 이를 방지하기 위해서 int로 반환하게 된다.
        // 즉 1바이트의 크기인 256가지가 아니라 257가지의 값을 표현하기 위해 int로 읽어온다.
        // 별로 안중요함
        while ((data = fis.read()) != -1) { // 최종의 -1 은 파일의 끝을 뜻한다. 이를 EOF(End of File) 이라고도 한다.
            System.out.println(data);
        }

        fis.close();
    }
}
