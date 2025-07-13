package lambda.lambda1;

import lambda.Procedure;

public class ProcedureMain1_M1 {

    public static void main(String[] args) {
        Procedure procedure = () -> {
            System.out.println("hello! lambda");
        };

        procedure.run();
    }
}
