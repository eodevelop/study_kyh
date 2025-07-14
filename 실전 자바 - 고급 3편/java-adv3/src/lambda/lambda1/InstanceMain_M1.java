package lambda.lambda1;

import lambda.Procedure;

public class InstanceMain_M1 {

    public static void main(String[] args) {
        Procedure procedure = new Procedure() {
            @Override
            public void run() {
                System.out.println("hello! lambda");
            }
        };

        System.out.println(procedure.getClass());
        System.out.println(procedure);

        Procedure procedure2 = () -> {
            System.out.println("hello! lambda2");
        };

        System.out.println(procedure2.getClass());
        System.out.println(procedure2);
    }
}
