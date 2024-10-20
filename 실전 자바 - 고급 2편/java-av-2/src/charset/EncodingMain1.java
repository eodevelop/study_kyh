package charset;

import java.nio.charset.Charset;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.*;

public class EncodingMain1 {

    private static final Charset EUC_KR = Charset.forName("EUC-KR");
    private static final Charset MS_949 = Charset.forName("MS_949");

    public static void main(String[] args) {
        System.out.println("== ASCII 영문 처리 == ");
        encoding("A", US_ASCII);
        encoding("A", ISO_8859_1);
        encoding("A", EUC_KR);
        encoding("A", UTF_8);
        encoding("A", UTF_16BE); // [0, 65] 앞에 0이 하나 더 붙어서 호환이 되지 않는다

        // 음수로 보이는 이유는 첫번째 비트가 음수와 양수를 구분하는 비트이기 때문
        System.out.println("== 한글 지원 ==");
        encoding("가", EUC_KR);
        encoding("가", MS_949);
        encoding("가", UTF_8);
        encoding("가", UTF_16BE);

        // 항상 인코딩 표를 넣어야한다. 넣지 않으면 디폴트 값이 들어가는것 뿐이다.
        String str = "hello";
        byte[] bytes = str.getBytes();
        System.out.println("bytes = " + Arrays.toString(bytes));
    }

    private static void encoding(String text, Charset charset) {
        byte[] bytes = text.getBytes(charset);
        System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte\n", text, charset, Arrays.toString(bytes), bytes.length);
    }
}
