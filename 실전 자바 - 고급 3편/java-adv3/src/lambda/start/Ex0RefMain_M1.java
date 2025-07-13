package lambda.start;

public class Ex0RefMain_M1 {
    public static void helloPrint(String str) {
        System.out.println("프로그램 시작");
        System.out.println(str);
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {
        helloPrint("helloJava");
        helloPrint("helloSpring");
    }
}