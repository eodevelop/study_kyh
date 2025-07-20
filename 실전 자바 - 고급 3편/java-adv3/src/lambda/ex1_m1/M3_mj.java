package lambda.ex1_m1;

import lambda.Procedure;

import java.util.Arrays;

public class M3_mj {

    public static void measure(Procedure p) {
        long startNs = System.nanoTime();
        p.run(); // 바뀌는 로직 실행 (익명 클래스 or 람다로 전달)
        long endNs = System.nanoTime();
        System.out.println("실행 시간: " + (endNs - startNs) + "ns");
    }

    public static void main(String[] args) {
        Procedure add = new Procedure() {
            @Override
            public void run() {
                int n = 10;
                int sum = 0;
                for (int i = 1; i <= n; i++) {
                    sum += i;
                }
            }
        };

        measure(add);

        Procedure sort = new Procedure() {
            @Override
            public void run() {
                int[] arr = {4, 3, 2, 1};
                Arrays.sort(arr);
            }
        };

        measure(sort);
    }
}
