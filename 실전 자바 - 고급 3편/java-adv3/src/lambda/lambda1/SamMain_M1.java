package lambda.lambda1;

public class SamMain_M1 {

    public static void main(String[] args) {
        SamInterface sam = () -> {
            System.out.println("hello! lambda");
        };
        sam.run();

//        NotSamInterface nSam = () -> {
//            System.out.println("hello! lambda");
//        };
//
//        nSam.go();
//        nSam.run();
    }
}
