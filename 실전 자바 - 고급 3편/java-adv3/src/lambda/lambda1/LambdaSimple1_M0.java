package lambda.lambda1;

import lambda.MyFunction;

public class LambdaSimple1_M0 {

    public static void main(String[] args) {
        MyFunction fun1 = (int a, int b) -> {
            return a + b;
        };
        System.out.println("1 : " + fun1.apply(1, 2));

        MyFunction fun2 = (a, b) -> a + b;
        System.out.println("2 : " + fun2.apply(2, 2));

        MyFunction fun3 = (int a, int b) -> {
            System.out.println("람다 실행");
            return a + b;
        };
        System.out.println("3 : " + fun3.apply(3, 3));
    }
}
